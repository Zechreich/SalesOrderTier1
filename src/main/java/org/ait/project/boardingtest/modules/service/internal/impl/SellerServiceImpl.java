package org.ait.project.boardingtest.modules.service.internal.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ait.project.boardingtest.modules.dto.request.SalesOrderReq;
import org.ait.project.boardingtest.modules.dto.response.CustomerRes;
import org.ait.project.boardingtest.modules.dto.response.ProductRes;
import org.ait.project.boardingtest.modules.dto.response.SalesAccumulateRes;
import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.ait.project.boardingtest.modules.model.entity.Product;
import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.ait.project.boardingtest.modules.service.delegate.CustomerDelegate;
import org.ait.project.boardingtest.modules.service.delegate.ProductDelegate;
import org.ait.project.boardingtest.modules.service.delegate.TransactionDelegate;
import org.ait.project.boardingtest.modules.service.internal.SellerService;
import org.ait.project.boardingtest.modules.dto.response.SalesOrderRes;
import org.ait.project.boardingtest.modules.transform.SalesOrderTransform;
import org.ait.project.boardingtest.shared.constant.enums.ResponseEnum;
import org.ait.project.boardingtest.shared.dto.template.ResponseDetail;
import org.ait.project.boardingtest.shared.dto.template.ResponseList;
import org.ait.project.boardingtest.shared.dto.template.ResponseTemplate;
import org.ait.project.boardingtest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final ResponseHelper responseHelper;
    private final TransactionDelegate transactionDelegate;

    private final CustomerDelegate customerDelegate;

    private final ProductDelegate productDelegate;
    private final SalesOrderTransform salesOrderTransform;

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrder(Pageable pageable) {
        Page<Transaction> lstTransaction = transactionDelegate.getAllTransaction(pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                salesOrderTransform.createJPHTransactionEntityToDTOList(lstTransaction.getContent()));
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdCustomer(Long idCustomer, Pageable pageable) {
        Page<Transaction> lstTransaction = transactionDelegate.getAllTransactionByIdCustomerPage(idCustomer, pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                salesOrderTransform.createJPHTransactionEntityToDTOList(lstTransaction.getContent()));
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdProduct(Long idProduct, Pageable pageable) {
        Page<Transaction> lstTransaction = transactionDelegate.getAllTransaction(pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                salesOrderTransform.createJPHTransactionEntityToDTOList(lstTransaction.getContent()));
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<SalesAccumulateRes>>> getSalesOrderAccumulatePrice() {
        List<Transaction> lstTransaction = transactionDelegate.getAllTransaction();
        List<Product> lstProduct = productDelegate.getAllProduct();

        List<SalesAccumulateRes> lstSalesAccumulate = new ArrayList<SalesAccumulateRes>();
        for (Product prod : lstProduct) {
            SalesAccumulateRes salesAccumulateRes = new SalesAccumulateRes();
            salesAccumulateRes.setIdProduct(prod.getId());
            salesAccumulateRes.setNamaProduct(prod.getProductName());
            salesAccumulateRes.setProductCategory(prod.getProductCategory());
            Integer totalSold = 0;
            BigInteger totalRevenue = BigInteger.ZERO;
            for(Transaction transaction : lstTransaction){
                if(transaction.getIdProduct().equals(prod.getId())){
                    totalRevenue = totalRevenue.add(transaction.getTotalPrice());
                    totalSold = totalSold + transaction.getQuantity();
                }
            }
            salesAccumulateRes.setTotalRevenue(totalRevenue);
            salesAccumulateRes.setTotalSold(totalSold);

            lstSalesAccumulate.add(salesAccumulateRes);
        }

        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null, lstSalesAccumulate);
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerRes>>> getAllCustomer(Pageable pageable) {
        Page<Customer> lstCustomer = customerDelegate.getAllCustomerPage(pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                salesOrderTransform.createJPHCustomerEntityToDTOList(lstCustomer.getContent()));
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<ProductRes>>> getAllProduct(Pageable pageable) {
        Page<Product> lstProduct = productDelegate.getAllProductPage(pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                salesOrderTransform.createJPHProductEntityToDTOList(lstProduct.getContent()));
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseTemplate<ResponseDetail<SalesOrderRes>>> setNewSalesOrder(SalesOrderReq salesOrderReq) {
        Integer qtyPembelian = salesOrderReq.getQuantity();

        if(salesOrderReq.getBankTransferNumber().isEmpty()){
            return responseHelper.createResponseDetail(ResponseEnum.valueOf("Masukan bukti nomor resi bank"), salesOrderTransform.createJPHSalesOrderRequestToResponse(salesOrderReq));
        }


        if(qtyPembelian < 1){
            return responseHelper.createResponseDetail(ResponseEnum.valueOf("Minimal 1 order pembelian (Quantity tidak boleh 0)"), salesOrderTransform.createJPHSalesOrderRequestToResponse(salesOrderReq));
        }else {
            Product product = productDelegate.getProduct(salesOrderReq.getIdProduct());
            Integer stock = product.getStock();
            if (product.getStock() < qtyPembelian) {
                return responseHelper.createResponseDetail(ResponseEnum.valueOf("Stock " + product.getProductName() + " tidak cukup, hanya tersisa " + product.getStock() + " unit"), salesOrderTransform.createJPHSalesOrderRequestToResponse(salesOrderReq));
            } else {

                Transaction transaction = new Transaction();
                transaction.setIdProduct(salesOrderReq.getIdProduct());
                transaction.setQuantity(salesOrderReq.getQuantity());
                transaction.setTotalPrice(salesOrderReq.getTotalPrice());
                transaction.setIdCustomer(salesOrderReq.getIdCustomer());
                transaction.setCreateAt(new Date());

                transactionDelegate.save(transaction);

                stock = stock - qtyPembelian;
                product.setStock(stock);

                productDelegate.save(product);

                return responseHelper.createResponseDetail(ResponseEnum.SUCCESS, salesOrderTransform.createJPHTransactionEntityToDTO(transaction));

            }
        }
    }

    @Override
    @Transactional
    public void setProductSeederData() {
        List<Product> lstProduct = new ArrayList<Product>(
                Arrays.asList(
                        new Product(null, "Bimoli", "Kitchen", new BigInteger("6000"), 120, new Date()),
                        new Product(null, "Pepsondent", "Bathroom", new BigInteger("4000"), 400, new Date()),
                        new Product(null, "Garam", "Kitchen", new BigInteger("2500"), 1200, new Date()),
                        new Product(null, "Sunsilk", "Bathroom", new BigInteger("10000"), 40, new Date()),
                        new Product(null, "Minyak Kayu Putih", "Bedroom", new BigInteger("20000"), 35, new Date()),
                        new Product(null, "Body Lotion", "Bedroom", new BigInteger("15000"), 20, new Date()
                        )
                )
        );

        List<Customer> lstCustomer = new ArrayList<Customer>(
                Arrays.asList(
                        new Customer(null, "Christian", 38, new Date()),
                        new Customer(null, "Harry", 30, new Date()),
                        new Customer(null, "Bintang", 31, new Date())
                )
        );

        productDelegate.saveAll(lstProduct);
        customerDelegate.saveAll(lstCustomer);
    }
}

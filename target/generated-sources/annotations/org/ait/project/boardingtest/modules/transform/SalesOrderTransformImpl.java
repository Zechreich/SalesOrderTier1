package org.ait.project.boardingtest.modules.transform;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.ait.project.boardingtest.modules.dto.request.SalesOrderReq;
import org.ait.project.boardingtest.modules.dto.response.CustomerRes;
import org.ait.project.boardingtest.modules.dto.response.ProductRes;
import org.ait.project.boardingtest.modules.dto.response.SalesOrderRes;
import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.ait.project.boardingtest.modules.model.entity.Product;
import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T14:57:53+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class SalesOrderTransformImpl implements SalesOrderTransform {

    @Override
    public SalesOrderRes createJPHTransactionEntityToDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        SalesOrderRes salesOrderRes = new SalesOrderRes();

        salesOrderRes.setIdCustomer( transaction.getIdCustomer() );
        salesOrderRes.setIdProduct( transaction.getIdProduct() );
        salesOrderRes.setQuantity( transaction.getQuantity() );
        salesOrderRes.setBankTransferNumber( transaction.getBankTransferNumber() );
        salesOrderRes.setTotalPrice( transaction.getTotalPrice() );

        return salesOrderRes;
    }

    @Override
    public ProductRes createJPHProductEntityToDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRes productRes = new ProductRes();

        productRes.setProductCategory( product.getProductCategory() );
        productRes.setStock( product.getStock() );

        return productRes;
    }

    @Override
    public CustomerRes createJPHCustomerEntityToDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerRes customerRes = new CustomerRes();

        customerRes.setId( customer.getId() );
        customerRes.setName( customer.getName() );
        customerRes.setAge( customer.getAge() );

        return customerRes;
    }

    @Override
    public List<SalesOrderRes> createJPHTransactionEntityToDTOList(List<Transaction> lstTransaction) {
        if ( lstTransaction == null ) {
            return null;
        }

        List<SalesOrderRes> list = new ArrayList<SalesOrderRes>( lstTransaction.size() );
        for ( Transaction transaction : lstTransaction ) {
            list.add( transactionToSalesOrderRes( transaction ) );
        }

        return list;
    }

    @Override
    public List<ProductRes> createJPHProductEntityToDTOList(List<Product> lstProduct) {
        if ( lstProduct == null ) {
            return null;
        }

        List<ProductRes> list = new ArrayList<ProductRes>( lstProduct.size() );
        for ( Product product : lstProduct ) {
            list.add( productToProductRes( product ) );
        }

        return list;
    }

    @Override
    public List<CustomerRes> createJPHCustomerEntityToDTOList(List<Customer> lstCustomer) {
        if ( lstCustomer == null ) {
            return null;
        }

        List<CustomerRes> list = new ArrayList<CustomerRes>( lstCustomer.size() );
        for ( Customer customer : lstCustomer ) {
            list.add( customerToCustomerRes( customer ) );
        }

        return list;
    }

    @Override
    public Transaction createJPHTransactionDTOToEntity(SalesOrderRes salesOrderRes) {
        if ( salesOrderRes == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setIdCustomer( salesOrderRes.getIdCustomer() );
        transaction.setIdProduct( salesOrderRes.getIdProduct() );
        transaction.setQuantity( salesOrderRes.getQuantity() );
        transaction.setTotalPrice( salesOrderRes.getTotalPrice() );
        transaction.setBankTransferNumber( salesOrderRes.getBankTransferNumber() );

        return transaction;
    }

    @Override
    public Product createJPHProductDTOToEntity(ProductRes productRes) {
        if ( productRes == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductCategory( productRes.getProductCategory() );
        product.setStock( productRes.getStock() );

        return product;
    }

    @Override
    public Customer createJPHCustomerDTOToEntity(CustomerRes customerRes) {
        if ( customerRes == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRes.getId() );
        customer.setName( customerRes.getName() );
        customer.setAge( customerRes.getAge() );

        return customer;
    }

    @Override
    public List<Transaction> createJPHTransactionDTOToEntityList(List<SalesOrderRes> lstSalesOrderRes) {
        if ( lstSalesOrderRes == null ) {
            return null;
        }

        List<Transaction> list = new ArrayList<Transaction>( lstSalesOrderRes.size() );
        for ( SalesOrderRes salesOrderRes : lstSalesOrderRes ) {
            list.add( salesOrderResToTransaction( salesOrderRes ) );
        }

        return list;
    }

    @Override
    public List<Product> createJPHProductDTOToEntityList(List<ProductRes> lstProductRes) {
        if ( lstProductRes == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( lstProductRes.size() );
        for ( ProductRes productRes : lstProductRes ) {
            list.add( productResToProduct( productRes ) );
        }

        return list;
    }

    @Override
    public List<Customer> createJPHCustomerDTOToEntityList(List<CustomerRes> lstCustomerRes) {
        if ( lstCustomerRes == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( lstCustomerRes.size() );
        for ( CustomerRes customerRes : lstCustomerRes ) {
            list.add( customerResToCustomer( customerRes ) );
        }

        return list;
    }

    @Override
    public SalesOrderRes createJPHSalesOrderRequestToResponse(SalesOrderReq salesOrderReq) {
        if ( salesOrderReq == null ) {
            return null;
        }

        SalesOrderRes salesOrderRes = new SalesOrderRes();

        salesOrderRes.setIdCustomer( salesOrderReq.getIdCustomer() );
        salesOrderRes.setIdProduct( salesOrderReq.getIdProduct() );
        salesOrderRes.setQuantity( salesOrderReq.getQuantity() );
        salesOrderRes.setBankTransferNumber( salesOrderReq.getBankTransferNumber() );
        salesOrderRes.setTotalPrice( salesOrderReq.getTotalPrice() );

        return salesOrderRes;
    }

    protected SalesOrderRes transactionToSalesOrderRes(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        SalesOrderRes salesOrderRes = new SalesOrderRes();

        salesOrderRes.setIdCustomer( transaction.getIdCustomer() );
        salesOrderRes.setIdProduct( transaction.getIdProduct() );
        salesOrderRes.setQuantity( transaction.getQuantity() );
        salesOrderRes.setBankTransferNumber( transaction.getBankTransferNumber() );
        salesOrderRes.setTotalPrice( transaction.getTotalPrice() );

        return salesOrderRes;
    }

    protected ProductRes productToProductRes(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRes productRes = new ProductRes();

        productRes.setProductCategory( product.getProductCategory() );
        productRes.setStock( product.getStock() );

        return productRes;
    }

    protected CustomerRes customerToCustomerRes(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerRes customerRes = new CustomerRes();

        customerRes.setId( customer.getId() );
        customerRes.setName( customer.getName() );
        customerRes.setAge( customer.getAge() );

        return customerRes;
    }

    protected Transaction salesOrderResToTransaction(SalesOrderRes salesOrderRes) {
        if ( salesOrderRes == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setIdCustomer( salesOrderRes.getIdCustomer() );
        transaction.setIdProduct( salesOrderRes.getIdProduct() );
        transaction.setQuantity( salesOrderRes.getQuantity() );
        transaction.setTotalPrice( salesOrderRes.getTotalPrice() );
        transaction.setBankTransferNumber( salesOrderRes.getBankTransferNumber() );

        return transaction;
    }

    protected Product productResToProduct(ProductRes productRes) {
        if ( productRes == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductCategory( productRes.getProductCategory() );
        product.setStock( productRes.getStock() );

        return product;
    }

    protected Customer customerResToCustomer(CustomerRes customerRes) {
        if ( customerRes == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRes.getId() );
        customer.setName( customerRes.getName() );
        customer.setAge( customerRes.getAge() );

        return customer;
    }
}

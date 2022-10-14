package org.ait.project.boardingtest.modules.controller;

import feign.Body;
import lombok.RequiredArgsConstructor;
import org.ait.project.boardingtest.modules.dto.request.SalesOrderReq;
import org.ait.project.boardingtest.modules.dto.response.CustomerRes;
import org.ait.project.boardingtest.modules.dto.response.ProductRes;
import org.ait.project.boardingtest.modules.dto.response.SalesAccumulateRes;
import org.ait.project.boardingtest.modules.service.internal.SellerService;
import org.ait.project.boardingtest.modules.dto.response.SalesOrderRes;
import org.ait.project.boardingtest.shared.dto.template.ResponseDetail;
import org.ait.project.boardingtest.shared.dto.template.ResponseList;
import org.ait.project.boardingtest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SellerController implements SellerService {

    private final SellerService service;

    @Override
    @GetMapping("/seller/getallsalesorder")
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrder(Pageable pageable) {
        return service.getAllSalesOrder(pageable);
    }

    @Override
    @GetMapping("/seller/getallsalesorderbyidcustomer/{idcustomer}")
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdCustomer(@PathVariable(name = "idcustomer") Long idCustomer, Pageable pageable) {
        return service.getAllSalesOrderByIdCustomer(idCustomer, pageable);
    }

    @Override
    @GetMapping("/seller/getallsalesorderbyidproduct/{idproduct}")
    public ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdProduct(@PathVariable(name = "idproduct") Long idProduct, Pageable pageable) {
        return service.getAllSalesOrderByIdProduct(idProduct, pageable);
    }

    @Override
    @PostMapping("/seller/getsalesaccumulateprice")
    public ResponseEntity<ResponseTemplate<ResponseList<SalesAccumulateRes>>> getSalesOrderAccumulatePrice() {
        return service.getSalesOrderAccumulatePrice();
    }

    @Override
    @GetMapping("/seller/getallcustomer")
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerRes>>> getAllCustomer(Pageable pageable) {
        return service.getAllCustomer(pageable);
    }

    @Override
    @GetMapping("/seller/getallproduct")
    public ResponseEntity<ResponseTemplate<ResponseList<ProductRes>>> getAllProduct(Pageable pageable) {
        return service.getAllProduct(pageable);
    }

    @Override
    @GetMapping("/seller/setnewsalesorder")
    public ResponseEntity<ResponseTemplate<ResponseDetail<SalesOrderRes>>> setNewSalesOrder(@RequestBody SalesOrderReq salesOrderReq) {
        return service.setNewSalesOrder(salesOrderReq);
    }

    @Override
    @GetMapping("/seller/setnewseeder")
    public void setProductSeederData() {
        service.setProductSeederData();
    }


}

package org.ait.project.boardingtest.modules.service.internal;

import org.ait.project.boardingtest.modules.dto.request.SalesOrderReq;
import org.ait.project.boardingtest.modules.dto.response.CustomerRes;
import org.ait.project.boardingtest.modules.dto.response.ProductRes;
import org.ait.project.boardingtest.modules.dto.response.SalesAccumulateRes;
import org.ait.project.boardingtest.modules.dto.response.SalesOrderRes;
import org.ait.project.boardingtest.shared.dto.template.ResponseDetail;
import org.ait.project.boardingtest.shared.dto.template.ResponseList;
import org.ait.project.boardingtest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface SellerService {

    ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrder(Pageable pageable);

    ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdCustomer(Long idCustomer, Pageable pageable);

    ResponseEntity<ResponseTemplate<ResponseList<SalesOrderRes>>> getAllSalesOrderByIdProduct(Long idProduct, Pageable pageable);

    ResponseEntity<ResponseTemplate<ResponseList<SalesAccumulateRes>>> getSalesOrderAccumulatePrice();

    ResponseEntity<ResponseTemplate<ResponseList<CustomerRes>>> getAllCustomer(Pageable pageable);

    ResponseEntity<ResponseTemplate<ResponseList<ProductRes>>> getAllProduct(Pageable pageable);

    ResponseEntity<ResponseTemplate<ResponseDetail<SalesOrderRes>>> setNewSalesOrder(SalesOrderReq salesOrderReq);

    void setProductSeederData();

}

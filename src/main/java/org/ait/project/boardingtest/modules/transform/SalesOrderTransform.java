package org.ait.project.boardingtest.modules.transform;

import org.ait.project.boardingtest.modules.dto.request.SalesOrderReq;
import org.ait.project.boardingtest.modules.dto.response.CustomerRes;
import org.ait.project.boardingtest.modules.dto.response.ProductRes;
import org.ait.project.boardingtest.modules.dto.response.SalesOrderRes;
import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.ait.project.boardingtest.modules.model.entity.Product;
import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring") // for Dependency Injection Spring
public interface SalesOrderTransform {

  @Named("createJPHTransactionEntityToDTO")
  SalesOrderRes createJPHTransactionEntityToDTO(Transaction transaction);
  @Named("createJPHProductEntityToDTO")
  ProductRes createJPHProductEntityToDTO(Product product);
  @Named("createJPHCustomerEntityToDTO")
  CustomerRes createJPHCustomerEntityToDTO(Customer customer);

  @Named("createJPHTransactionEntityToDTOList")
  List<SalesOrderRes> createJPHTransactionEntityToDTOList(List<Transaction> lstTransaction);
  @Named("createJPHProductEntityToDTOList")
  List<ProductRes> createJPHProductEntityToDTOList(List<Product> lstProduct);
  @Named("createJPHCustomerEntityToDTOList")
  List<CustomerRes> createJPHCustomerEntityToDTOList(List<Customer> lstCustomer);

  @Named("createJPHTransactionDTOToEntity")
  Transaction createJPHTransactionDTOToEntity(SalesOrderRes salesOrderRes);
  @Named("createJPHProductDTOToEntity")
  Product createJPHProductDTOToEntity(ProductRes productRes);
  @Named("createJPHCustomerDTOToEntity")
  Customer createJPHCustomerDTOToEntity(CustomerRes customerRes);

  @Named("createJPHTransactionDTOToEntityList")
  List<Transaction> createJPHTransactionDTOToEntityList(List<SalesOrderRes> lstSalesOrderRes);
  @Named("createJPHProductDTOToEntityList")
  List<Product> createJPHProductDTOToEntityList(List<ProductRes> lstProductRes);
  @Named("createJPHCustomerDTOToEntityList")
  List<Customer> createJPHCustomerDTOToEntityList(List<CustomerRes> lstCustomerRes);

  @Named("createJPHSalesOrderRequestToResponse")
  SalesOrderRes createJPHSalesOrderRequestToResponse(SalesOrderReq salesOrderReq);
}

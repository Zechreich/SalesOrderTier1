package org.ait.project.boardingtest.modules.service.delegate;

import org.ait.project.boardingtest.modules.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDelegate {

    List<Product> getAllProductPage();

    Page<Product> getAllProductPage(Pageable pageable);

    Product getProduct(Long id);

    List<Product> saveAll(List<Product> lstProduct);

    Product save(Product product);

    List<Product> getAllProduct();
}

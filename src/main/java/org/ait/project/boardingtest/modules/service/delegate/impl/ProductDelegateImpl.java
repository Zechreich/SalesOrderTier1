package org.ait.project.boardingtest.modules.service.delegate.impl;

import lombok.AllArgsConstructor;
import org.ait.project.boardingtest.modules.model.entity.Product;
import org.ait.project.boardingtest.modules.model.repository.ProductRepository;
import org.ait.project.boardingtest.modules.exception.JPHNotFoundException;
import org.ait.project.boardingtest.modules.service.delegate.ProductDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductDelegateImpl implements ProductDelegate {

    private final ProductRepository repository;

    @Override
    public List<Product> getAllProductPage() {
        return repository.findAll();
    }

    @Override
    public Page<Product> getAllProductPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow(JPHNotFoundException::new);
    }

    @Override
    public List<Product> saveAll(List<Product> lstProduct) {
        return repository.saveAll(lstProduct);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }
}

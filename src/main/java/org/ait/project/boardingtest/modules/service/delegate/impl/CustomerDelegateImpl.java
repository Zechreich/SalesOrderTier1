package org.ait.project.boardingtest.modules.service.delegate.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ait.project.boardingtest.modules.exception.JPHNotFoundException;
import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.ait.project.boardingtest.modules.model.repository.CustomerRepository;
import org.ait.project.boardingtest.modules.service.delegate.CustomerDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerDelegateImpl implements CustomerDelegate {

    private final CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomerPage() {
        return repository.findAll();
    }

    @Override
    public Page<Customer> getAllCustomerPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer getCustomer(Long id) {
        return repository.findById(id).orElseThrow(JPHNotFoundException::new);
    }

    @Override
    public List<Customer> saveAll(List<Customer> lstCustomer) {
        return repository.saveAll(lstCustomer);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }
}

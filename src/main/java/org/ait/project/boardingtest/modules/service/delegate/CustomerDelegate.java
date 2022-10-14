package org.ait.project.boardingtest.modules.service.delegate;

import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerDelegate {

    List<Customer> getAllCustomerPage();

    Page<Customer> getAllCustomerPage(Pageable pageable);

    Customer getCustomer(Long id);

    List<Customer> saveAll(List<Customer> lstCustomer);

    Customer save(Customer customer);
}

package org.ait.project.boardingtest.modules.model.repository;

import org.ait.project.boardingtest.modules.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

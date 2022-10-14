package org.ait.project.boardingtest.modules.model.repository;

import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByIdCustomer(Pageable pageable);

    Page<Transaction> findByIdProduct(Pageable pageable);
}

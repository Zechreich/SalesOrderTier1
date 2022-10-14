package org.ait.project.boardingtest.modules.service.delegate;

import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionDelegate {

    List<Transaction> getAllTransaction();

    Page<Transaction> getAllTransaction(Pageable pageable);

    Page<Transaction> getAllTransactionByIdCustomerPage(Long idCustomer, Pageable pageable);

    Page<Transaction> getAllTransactionByIdProductPage(Long idProduct, Pageable pageable);

    Transaction getTransaction(Long id);

    List<Transaction> saveAll(List<Transaction> lstTransaction);

    Transaction save(Transaction transaction);

}

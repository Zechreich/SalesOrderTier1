package org.ait.project.boardingtest.modules.service.delegate.impl;

import lombok.AllArgsConstructor;
import org.ait.project.boardingtest.modules.exception.JPHNotFoundException;
import org.ait.project.boardingtest.modules.model.entity.Transaction;
import org.ait.project.boardingtest.modules.model.repository.TransactionRepository;
import org.ait.project.boardingtest.modules.service.delegate.TransactionDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionDelegateImpl implements TransactionDelegate {

    private final TransactionRepository repository;

    @Override
    public List<Transaction> getAllTransaction() {
        return repository.findAll();
    }

    @Override
    public Page<Transaction> getAllTransaction(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Transaction> getAllTransactionByIdCustomerPage(Long idCustomer, Pageable pageable) {
        return repository.findByIdCustomer(pageable);
    }

    @Override
    public Page<Transaction> getAllTransactionByIdProductPage(Long idProduct, Pageable pageable) {
        return repository.findByIdProduct(pageable);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return repository.findById(id).orElseThrow(JPHNotFoundException::new);
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> lstTransaction) {
        return repository.saveAll(lstTransaction);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
}

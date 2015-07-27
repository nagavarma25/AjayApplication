package com.vijayadiamonds.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.repository.TransactionRepository;
import com.vijayadiamonds.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Optional<Transaction> addTransaction(Transaction transaction) {
        return Optional.ofNullable(transactionRepository.save(transaction));
    }

    @Override
    public Optional<Transaction> getTransaction(Long id) {
        return Optional.ofNullable(transactionRepository.findOne(id));
    }

    @Override
    public List<Transaction> findByCustomer(Customer customer) {
        return transactionRepository.findByCustomer(customer);
    }

    @Override
    public Transaction settleTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findOne(transactionId);
        transaction.setPaidAmount(transaction.getTotalAmount());
        transactionRepository.save(transaction);
        return transaction;
    }
}

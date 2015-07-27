package com.vijayadiamonds.service;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<Transaction> addTransaction(Transaction transaction);

    Optional<Transaction> getTransaction(Long id);

    List<Transaction> findByCustomer(Customer customer);

    public Transaction settleTransaction(Long transactionId);
}

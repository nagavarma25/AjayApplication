package com.vijayadiamonds.service;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction addTransaction(Transaction transaction);

    Transaction getTransaction(Long id);

    List<Transaction> findByCustomer(Customer customer);

    public Transaction settleTransaction(Long transactionId);
}

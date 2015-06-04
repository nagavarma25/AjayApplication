package com.vijayadiamonds.service;

import java.util.List;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;

public interface TransactionService {

	Transaction addTransaction(Transaction transaction);
	Transaction getTransaction(Long id);
	List<Transaction> findByCustomer(Customer customer);
}

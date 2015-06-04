package com.vijayadiamonds.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;

public interface TransactionRepository extends
		PagingAndSortingRepository<Transaction, Long> {

	List<Transaction> findByCustomer(Customer customer);
}

package com.vijayadiamonds.service.impl;

import java.util.List;

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
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getTransaction(Long id) {
		return transactionRepository.findOne(id);
	}
	
	@Override 
	public List<Transaction> findByCustomer(Customer customer){
		return transactionRepository.findByCustomer(customer);
	}

}

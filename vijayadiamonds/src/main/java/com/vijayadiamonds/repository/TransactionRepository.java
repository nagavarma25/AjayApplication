package com.vijayadiamonds.repository;

import com.vijayadiamonds.model.Customer;
import com.vijayadiamonds.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TransactionRepository extends
        PagingAndSortingRepository<Transaction, Long> {

    List<Transaction> findByCustomer(Customer customer);
}

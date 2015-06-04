package com.vijayadiamonds.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vijayadiamonds.model.Customer;

/**
 * Repository class used to interact with {@link Customer} entity
 * 
 * @author Janardhan
 *
 */
public interface CustomerRepository extends
		PagingAndSortingRepository<Customer, Long> {
	@Query("select c from Customer c")
	Set<Customer> findAll();
}

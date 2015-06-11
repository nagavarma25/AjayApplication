package com.vijayadiamonds.repository;

import com.vijayadiamonds.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

/**
 * Repository class used to interact with {@link Customer} entity
 *
 * @author Janardhan
 */
public interface CustomerRepository extends
        PagingAndSortingRepository<Customer, Long> {
    @Query("select c from Customer c")
    Set<Customer> findAll();
}

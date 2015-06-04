package com.vijayadiamonds.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vijayadiamonds.model.Sale;

/**
 * Repository class used to interact with {@link Sales} entity
 * 
 * @author Janardhan
 *
 */
public interface SaleRepository extends
		PagingAndSortingRepository<Sale, Long> {

}

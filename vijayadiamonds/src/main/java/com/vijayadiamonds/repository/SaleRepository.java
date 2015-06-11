package com.vijayadiamonds.repository;

import com.vijayadiamonds.model.Sale;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository class used to interact with {@link Sales} entity
 *
 * @author Janardhan
 */
public interface SaleRepository extends
        PagingAndSortingRepository<Sale, Long> {

}

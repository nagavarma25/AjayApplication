package com.vijayadiamonds.repository;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

/**
 * Repository class used to interact with {@link Item} entity
 *
 * @author Janardhan
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    Set<Item> findAll();

    @Query("select i.name from Item i")
    Set<String> getItemNames();

    Item findByNameAndShape(String name, Shape shape);
}

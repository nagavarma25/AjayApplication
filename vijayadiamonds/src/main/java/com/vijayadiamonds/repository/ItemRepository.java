package com.vijayadiamonds.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;

/**
 * Repository class used to interact with {@link Item} entity
 * 
 * @author Janardhan
 *
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

	Set<Item> findAll();

	@Query("select i.name from Item i")
	Set<String> getItemNames();

	Item findByNameAndShape(String name , Shape shape);
}

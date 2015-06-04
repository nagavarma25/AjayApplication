package com.vijayadiamonds.service;

import java.util.Set;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;

/**
 * Provide service for {@link Item} operations
 *
 */
public interface ItemService {

	/**
	 * Get a {@link Item} which has the id given
	 * 
	 * @param id
	 *            id of the {@link Item}
	 * @return
	 */
	public Item getItemById(Long id);

	/**
	 * Returns collection of all {@link Item} in the database
	 * 
	 * @return
	 */
	public Set<Item> getAllItems();

	/**
	 * Save an {@link Item} to the database
	 * 
	 * @param item
	 *            {@link Item} to be saved
	 * @return
	 */
	public Item addItem(Item item);

	/**
	 * Returns name of all {@link Item} in database
	 * 
	 * @return
	 */
	Set<String> getItemNames();

	/**
	 * Returns an {@link Item} by it's name and shape
	 * 
	 * @param name
	 *            Name of the {@link Item}
	 * @param shape
	 *            Shape of the {@link Item}
	 * @return
	 */
	Item getItemByNameAndShape(String name, Shape shape);
}

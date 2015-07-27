package com.vijayadiamonds.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.repository.ItemRepository;
import com.vijayadiamonds.service.ItemService;

/**
 * Implementation for {@link ItemService}
 *
 * @author Janardhan
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Item> getItemById(Long id) {
		return Optional.ofNullable(itemRepository.findOne(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Item> getAllItems() {
		return itemRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Item> addItem(Item item) {
		return Optional.ofNullable(itemRepository.save(item));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> getItemNames() {
		return itemRepository.getItemNames();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Item> getItemByNameAndShape(String name, Shape shape) {
		return Optional.ofNullable(itemRepository.findByNameAndShape(name,
				shape));
	}

	public Set<String> getShapesByName(final String name) {
		List<Item> items = itemRepository.findByName(name);
		Set<String> shapes = new HashSet<String>();
		for (Item item : items) {
			shapes.add(item.getShape().toString());
		}
		return shapes;
	}
}

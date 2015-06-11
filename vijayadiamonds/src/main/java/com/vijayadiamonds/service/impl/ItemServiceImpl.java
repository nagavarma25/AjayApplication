package com.vijayadiamonds.service.impl;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.repository.ItemRepository;
import com.vijayadiamonds.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public Item getItemById(Long id) {
        return itemRepository.findOne(id);
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
    public Item addItem(Item item) {
        return itemRepository.save(item);
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
    public Item getItemByNameAndShape(String name, Shape shape) {
        return itemRepository.findByNameAndShape(name, shape);
    }

}

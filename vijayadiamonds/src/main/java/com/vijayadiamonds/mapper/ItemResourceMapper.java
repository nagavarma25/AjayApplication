package com.vijayadiamonds.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.resource.ItemResource;

@Service
public class ItemResourceMapper implements Function<Item, ItemResource> {

	@Override
	public ItemResource apply(Item item) {
		return new ItemResource(item.getId(), item.getName(),item.getShape().name(), item.getUnit(),
				item.getUnitPrice(),null , null);
	}

}

package com.vijayadiamonds.billgeneration;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijayadiamonds.mapper.ItemResourceMapper;
import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.resource.ItemResource;
import com.vijayadiamonds.service.ItemService;
import com.vijayadiamonds.service.ShapeService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ShapeService shapeService;

	@Autowired
	private ItemResourceMapper itemResourceMapper;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Set<ItemResource> getAllItems() {
		Set<ItemResource> resources = itemService.getAllItems().stream()
				.map(itemResourceMapper).collect(Collectors.toSet());
		return resources;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String loadAddPage() {
		return "additem";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Item addItem(@RequestBody ItemResource itemResource) {
		String itemName = Objects.requireNonNull(itemResource.getName(),
				"Item name cannot be null");
		String itemShape = Objects.requireNonNull(itemResource.getShape(),
				"Item shape cannot be null");
		String unit = Objects.requireNonNull(itemResource.getUnit(),
				"Item unit cannot be null");
		Long unitPrice = Objects.requireNonNull(itemResource.getUnitPrice(),
				"Unit price of the item cannot be null");
		Item item = new Item(itemName, unit, unitPrice,
				shapeService.getShapeNameFromValue(itemShape));
		return itemService.addItem(item);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String loadEditPage(Locale locale, Model model) {
		return "edititem";
	}

	@RequestMapping(value = "/allshapes", method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getShapes() {
		EnumSet<Shape> all = EnumSet.allOf(Shape.class);
		Set<String> shapes = new HashSet<String>();
		for (Shape s : all) {
			shapes.add(s.toString());
		}
		return shapes;
	}

	@RequestMapping(value = "/itemnames", method = RequestMethod.GET)
	@ResponseBody
	public Set<String> getItemNames() {
		return itemService.getItemNames();
	}

	@RequestMapping(value = "/getbynameandshape", method = RequestMethod.GET)
	@ResponseBody
	public Item getItemByNameAndShape(@RequestParam("name") String name,
			@RequestParam("shape") String shape) {
		System.out.println(name + shape);
		Item i = itemService.getItemByNameAndShape(name, shapeService.getShapeNameFromValue(shape));
		// System.out.println(i.getUnit());
		return i;
	}


}

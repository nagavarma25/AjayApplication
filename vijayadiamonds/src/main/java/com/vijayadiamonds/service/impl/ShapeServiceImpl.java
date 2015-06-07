package com.vijayadiamonds.service.impl;

import org.springframework.stereotype.Service;

import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.service.ShapeService;

@Service
public class ShapeServiceImpl implements ShapeService {

	public Shape getShapeNameFromValue(String value) {
		Shape shape = null;
		for (Shape s : Shape.values()) {
			if (s.toString().equals(value)) {
				shape = s;
				break;
			}
		}
		return shape;
	}
}

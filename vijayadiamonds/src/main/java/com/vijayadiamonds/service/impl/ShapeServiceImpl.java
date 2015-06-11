package com.vijayadiamonds.service.impl;

import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.service.ShapeService;
import org.springframework.stereotype.Service;

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

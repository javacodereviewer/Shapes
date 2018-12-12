package com.epam.shapes.services;

import com.epam.shapes.entity.Shape;

import java.util.List;

public interface ShapeFactory {
    List<? extends Shape> getShapes() throws NoValidDataExcepiton;

}

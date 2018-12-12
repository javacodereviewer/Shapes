package com.epam.shapes.services;

import com.epam.shapes.entity.Point;

import java.util.List;

public interface ShapeAnalyzer {
    //площадь
    double getArea();

    //периметр
    double getPerimeter();

    boolean isTriangle(List<Point> points);



}

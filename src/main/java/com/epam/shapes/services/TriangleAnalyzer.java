package com.epam.shapes.services;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleAnalyzer implements ShapeAnalyzer {
    private static final Logger LOGGER = LogManager.getLogger(TriangleAnalyzer.class);
    private Triangle triangle;
    private double side1;
    private double side2;
    private double side3;

    public TriangleAnalyzer(Triangle triangle) {
        this.triangle = triangle;
        this.side1 = triangle.getSide1();
        this.side2 = triangle.getSide2();
        this.side3 = triangle.getSide3();
    }

    // равносторонний
    public boolean isEquilateral() {
        if ((Double.compare(side1, side2) == 0) && (Double.compare(side1, side3) == 0)) {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is equilateral", side1, side2, side3));
            return true;
        } else {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is not equilateral", side1, side2, side3));
            return false;
        }
    }

    //тупоугольный
    //cos <C = (a²+b²-c²)/2ab
    public boolean isObtuse() {
        List<Double> sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        Collections.sort(sides);
        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);

        double cosOfMaxSide = (a * a + b * b - c * c) / 2 * a * b;

        if (cosOfMaxSide < 0) {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is obtuse", side1, side2, side3));
            return true;
        } else {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is not obtuse", side1, side2, side3));
            return false;
        }
    }

    //остроугольный
    public boolean isAcute() {
        boolean result = !isObtuse() && !isRightAngle();
        if (result) {
            LOGGER.info("Trianle is accute");
        } else {
            LOGGER.info("Triangle is not accute");
        }
        return result;
    }

    // равнобедренный
    public boolean isIsosceles() {
        if (((Double.compare(side1, side2) == 0) ||
                (Double.compare(side1, side3) == 0)) ||
                (Double.compare(side2, side3) == 0)) {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is isosceles", side1, side2, side3));
            return true;
        } else {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is not isosceles", side1, side2, side3));
            return false;
        }
    }




    // прямоугольный
    public boolean isRightAngle() {
        double side1Square = side1 * side1;
        double side2Square = side2 * side2;
        double side3Square = side3 * side3;

        if ((Double.compare(side1Square, (side2Square + side3Square)) == 0) ||
                (Double.compare(side2Square, (side1Square + side3Square)) == 0) ||
                (Double.compare(side3Square, (side2Square + side1Square)) == 0)) {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is rightangle", side1, side2, side3));
            return true;
        } else {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is not rightangle", side1, side2, side3));
            return false;
        }
    }


    /*
    Площадь тругольника по формуле Герона равна корню из
    произведения разностей полупериметра
    треугольника (p) и каждой из его сторон (a, b, c):
     */
    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1)
                * (semiPerimeter - side2) * (semiPerimeter - side3));
        LOGGER.info(String.format("Triangle area is %f", triangleArea));
        return triangleArea;
    }

    @Override
    public double getPerimeter() {
        double result = side1 + side2 + side3;
        LOGGER.info(String.format("Triangle perimeter is %f", result));
        return result;
    }

    @Override
    public boolean isTriangle(List<Point> points) {
        if (points.size() != 3) {
            return false;
        }
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        if (((Double.compare(x1, x2) + Double.compare(x2, x3)) != 0) &&
                ((Double.compare(y1, y2) + Double.compare(y2, y3)) != 0)) {
            LOGGER.info("These three points are a triangle");
            return true;
        } else {
            LOGGER.info("These three points are not a triangle");
            return false;
        }
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
        this.side1 = triangle.getSide1();
        this.side2 = triangle.getSide2();
        this.side3 = triangle.getSide3();
    }
}

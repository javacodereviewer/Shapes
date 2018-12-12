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

    /**
     * Returns true when all sides of a triangle are equal
     */
    public boolean isEquilateral() {
        if ((Double.compare(side1, side2) == 0) && (Double.compare(side1, side3) == 0)) {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is equilateral", side1, side2, side3));
            return true;
        } else {
            LOGGER.info(String.format("Triangle with sides %f, %f, %f is not equilateral", side1, side2, side3));
            return false;
        }
    }

    /**
     * Returns true when the area of the square whose side is the hypotenuse
     * (the side opposite the right angle) is equal to the sum of the areas
     * of the squares whose sides are the two legs (the two sides that meet at a right angle).
     */
    public boolean isRightAngled() {
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

    /**
     * Returns true when the cos of the 'C' angle opposite max side is less than zero
     * (cos <C = (a²+b²-c²)/2ab) < 0
     */
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

    /**
     * Returns true when the triangle is not obtuse or right-angled
     */
    public boolean isAcute() {
        boolean result = !isObtuse() && !isRightAngled();
        if (result) {
            LOGGER.info("Trianle is accute");
        } else {
            LOGGER.info("Triangle is not accute");
        }
        return result;
    }

    /**
     * Returns true when at least two sides of the triangle are equal
     */
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

    /**
     * Returns double value of the triangle area counted by Geron's formula
     */
    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1)
                * (semiPerimeter - side2) * (semiPerimeter - side3));
        LOGGER.info(String.format("Triangle area is %f", triangleArea));
        return triangleArea;
    }

    /**
     * Returns sum of all triangle sides
     */
    @Override
    public double getPerimeter() {
        double result = side1 + side2 + side3;
        LOGGER.info(String.format("Triangle perimeter is %f", result));
        return result;
    }

    /**
     * Checks if three points can be a triagnle
     */
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

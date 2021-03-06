package com.epam.shapes.services;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TriangleAnalyzerTest {
    private TriangleAnalyzer triangleAnalyzer;

    @BeforeClass
    public void initAnalyzer() {
        Triangle triangle = new Triangle(0.0, 0.0, 0.0);
        triangleAnalyzer = new TriangleAnalyzer(triangle);
    }

    @Test
    public void testIsEquilateralWhenAllSidesAreEqualThenTrue() {
        triangleAnalyzer.setTriangle(new Triangle(3.3, 3.3, 3.3));
        boolean actual = triangleAnalyzer.isEquilateral();
        assertTrue(actual);

    }

    @Test
    public void testIsEquilateralWhenSidesNotEqualThenFalse() {
        triangleAnalyzer.setTriangle(new Triangle(5.3, 3.3, 3.3));
        boolean actual = triangleAnalyzer.isEquilateral();
        assertFalse(actual);

    }

    @Test
    public void testIsRightAngledWhenSquareOfHypotenuseIsEqualToSumSquaresOfLegsThenTrue() {
        triangleAnalyzer.setTriangle(new Triangle(3.0, 4.0, 5.0));
        boolean actual = triangleAnalyzer.isRightAngled();
        assertTrue(actual);
    }
    @Test
    public void testIsRightAngledWhenSquareOfHypotenuseIsNotEqualToSumSquaresOfLegsThenFalse() {
        triangleAnalyzer.setTriangle(new Triangle(6.0, 4.0, 5.0));
        boolean actual = triangleAnalyzer.isRightAngled();
        assertFalse(actual);
    }

    @Test
    public void isObtuse() {
        triangleAnalyzer.setTriangle(new Triangle(11.0, 4.0, 9.0));
        boolean actual = triangleAnalyzer.isObtuse();
        assertTrue(actual);
    }

    @Test
    public void isAcute() {
        triangleAnalyzer.setTriangle(new Triangle(5.0, 4.0, 4.0));
        boolean actual = triangleAnalyzer.isAcute();
        assertTrue(actual);
    }

    @Test
    public void isIsosceles() {
        triangleAnalyzer.setTriangle(new Triangle(5.0, 4.0, 4.0));
        boolean actual = triangleAnalyzer.isIsosceles();
        assertTrue(actual);
    }

    @Test
    public void getArea() {
        triangleAnalyzer.setTriangle(new Triangle(13.0, 14.0, 15.0));
        double expected = 84.0;
        double actual = triangleAnalyzer.getArea();
        assertEquals(actual, expected);

    }

    @Test
    public void getPerimeter() {
        triangleAnalyzer.setTriangle(new Triangle(13.0, 14.0, 15.0));
        double expected = 42.0;
        double actual = triangleAnalyzer.getPerimeter();
        assertEquals(actual, expected);
    }

    @Test
    public void isTriangle() {
        List<Point> testPoints = new ArrayList();
        testPoints.add(new Point(5.0, 5.0));
        testPoints.add(new Point(5.0, 10.0));
        testPoints.add(new Point(10.0, 10.0));

        boolean actual = triangleAnalyzer.isTriangle(testPoints);
        assertTrue(actual);
    }
}
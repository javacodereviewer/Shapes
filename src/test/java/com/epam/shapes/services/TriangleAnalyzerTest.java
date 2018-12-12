package com.epam.shapes.services;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleAnalyzerTest {
    TriangleAnalyzer triangleAnalyzer;
    private static final double DELTA = 1e-15;


    @Test
    public void isEquilateral() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(3.3, 3.3, 3.3));
        Assert.assertTrue(triangleAnalyzer.isEquilateral());

    }

    @Test
    public void isRightAngle() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(3.0, 4.0, 5.0));
        Assert.assertTrue(triangleAnalyzer.isRightAngle());
    }

    @Test
    public void isObtuse() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(11.0, 4.0, 9.0));
        Assert.assertTrue(triangleAnalyzer.isObtuse());
    }

    @Test
    public void isAcute() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(5.0, 4.0, 4.0));
        Assert.assertTrue(triangleAnalyzer.isAcute());
    }

    @Test
    public void isIsosceles() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(5.0, 4.0, 4.0));
        Assert.assertTrue(triangleAnalyzer.isIsosceles());
    }

    @Test
    public void getArea() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(13.0, 14.0, 15.0));
        Assert.assertEquals(84.0, triangleAnalyzer.getArea(), DELTA);

    }

    @Test
    public void getPerimeter() {
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(13.0, 14.0, 15.0));
        Assert.assertEquals(42.0, triangleAnalyzer.getPerimeter(), DELTA);
    }

    @Test
    public void isTriangle() {
        List<Point> testPoints = new ArrayList();
        testPoints.add(new Point(5.0, 5.0));
        testPoints.add(new Point(5.0, 10.0));
        testPoints.add(new Point(10.0, 10.0));
        triangleAnalyzer = new TriangleAnalyzer(new Triangle(13.0, 14.0, 15.0));
        Assert.assertTrue(triangleAnalyzer.isTriangle(testPoints));
    }
}
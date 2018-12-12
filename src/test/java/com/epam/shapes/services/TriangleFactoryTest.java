package com.epam.shapes.services;

import com.epam.shapes.entity.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleFactoryTest {

    @Test
    public void testCreateTriangle() {
        TriangleFactory factory = new TriangleFactory();
        Triangle expected = new Triangle(1.0, 1.0, 1.0);
        String params = "1.0 1.0 1.0";
        Triangle actual = factory.createTriangle(params);
        assertEquals(actual, expected);

    }
}
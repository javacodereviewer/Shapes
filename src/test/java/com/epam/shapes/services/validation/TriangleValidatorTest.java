package com.epam.shapes.services.validation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleValidatorTest {
    private TriangleValidator validator;

    @BeforeClass
    public void initializeValidator() {
        validator = new TriangleValidator();
    }

    @Test
    public void testValidateWhenGivenValidDataThenTrue() {
        String normalData = "3.0 4.0 5.0";
        boolean expected = true;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateWhenGivenNotEnoughDataThenFals() {
        String normalData = "3.0 4.0";
        boolean expected = false;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateWhenGivenSideSizeLessThanZeroThenFalse() {
        String normalData = "-3.0 4.0 5.0";
        boolean expected = false;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateWhenGivenNotDigitSymbolThenFalse() {
        String normalData = "3.0 4.0s 5.0";
        boolean expected = false;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateWhenGivenSideSizeBiggerThanOthersSidesSumThenFalse() {
        String normalData = "8.0 4.0 3.0";
        boolean expected = false;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateWhenGivenSideSizeEqualToOthersSidesSumThenFalse() {
        String normalData = "8.0 4.0 4.0";
        boolean expected = false;
        boolean actual = validator.validate(normalData);
        assertEquals(actual, expected);
    }
}
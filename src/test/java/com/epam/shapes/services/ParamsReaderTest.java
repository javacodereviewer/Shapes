package com.epam.shapes.services;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ParamsReaderTest {

    @Test
    public void getParamsFromFile() {
        ParamsReader reader = new ParamsReader();
        String paramsFileName = "src\\test\\java\\com\\epam\\shapes\\services\\shapeParams.txt";
        List<String> expected = new ArrayList<>();
        expected.add("3.0 4.0 5.0");
        expected.add("14.0 15.0 16.0");
        expected.add("5.0 5.0 5.0");

        List<String> actual = reader.getParamsFromFile(paramsFileName);

        assertEquals(actual, expected);
    }
}
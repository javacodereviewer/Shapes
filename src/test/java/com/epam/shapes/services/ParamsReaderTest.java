package com.epam.shapes.services;

import org.testng.annotations.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ParamsReaderTest {

    @Test
    public void getParamsFromFile() throws URISyntaxException {
        ParamsReader reader = new ParamsReader();
        URL resource = ParamsReaderTest.class.getClassLoader().getResource("shapeParams.txt");
        File f = new File(resource.toURI());
        String paramsFileName = f.getAbsolutePath();
        List<String> expected = new ArrayList<>();
        expected.add("3.0 4.0 5.0");
        expected.add("14.0 15.0 16.0");
        expected.add("5.0 5.0 5.0");

        List<String> actual = reader.getParamsFromFile(paramsFileName);

        assertEquals(actual, expected);
    }
}
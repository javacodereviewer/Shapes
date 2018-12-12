package com.epam.shapes.services;

import com.epam.shapes.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    private final static ParamsReader PARAMS_READER = new ParamsReader();
    public static final String SPLIT_REGEX = " ";

    @Override
    public List<Triangle> getShapes() throws NoValidDataExcepiton{
        List<Triangle> triangles = new ArrayList<>();
        LOGGER.info("Loading triangles params");
        List<String> data = PARAMS_READER.getParamsFromFile();

        if (data.size() == 0) {
            LOGGER.error("Empty params list, can't create a Triangle");
            throw new NoValidDataExcepiton("Haven't found any valid params to create a Triangle");
        }
        for (String s : data) {
            Triangle triangle = createTriangle(s);
            triangles.add(triangle);
        }
        LOGGER.info(String.format("Created %d Triangles", triangles.size()));
        return triangles;
    }

    public Triangle createTriangle(String s) {
        String[] sides = s.split(SPLIT_REGEX);
        double side1 = Double.valueOf(sides[0]);
        double side2 = Double.valueOf(sides[1]);
        double side3 = Double.valueOf(sides[2]);
        LOGGER.info(String.format("New Triangle created, side1=%f, side2=%f, side3=%f", side1, side2, side3));
        return new Triangle(side1, side2, side3);
    }
}

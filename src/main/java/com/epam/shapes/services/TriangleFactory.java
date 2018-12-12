package com.epam.shapes.services;

import com.epam.shapes.entity.Shape;
import com.epam.shapes.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    private final static ParamsReader PARAMS_READER = new ParamsReader();

//    public static void main(String[] args) throws NoValidDataExcepiton {
//        ShapeFactory factory = new TriangleFactory();
//
//
//        List<? extends Shape> triangles = factory.getShapes();
//        int i = 1;
//        for (Shape s : triangles) {
//            TriangleAnalyzer analyzer = new TriangleAnalyzer((Triangle)s);
//            System.out.println("Tringle #" + i);
//            analyzer.getArea();
//            analyzer.getPerimeter();
//            analyzer.isAcute();
//            analyzer.isEquilateral();
//            analyzer.isIsosceles();
//            analyzer.isObtuse();
//            analyzer.isRightAngle();
//            i++;
//        }
//
//    }

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

    private Triangle createTriangle(String s) {
        String[] sides = s.split(" ");
        double side1 = Double.valueOf(sides[0]);
        double side2 = Double.valueOf(sides[1]);
        double side3 = Double.valueOf(sides[2]);
        LOGGER.info(String.format("New Triandle created, side1=%f, side2=%f, side3=%f", side1, side2, side3));
        return new Triangle(side1, side2, side3);
    }
}

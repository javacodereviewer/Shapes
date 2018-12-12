package com.epam.shapes.services.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidator implements Validator {
    private static final Logger LOGGER = LogManager.getLogger(TriangleValidator.class);
    @Override
    public boolean validate(String paramsLine) {
        LOGGER.info(String.format("Validating stringdata : %s", paramsLine));

        String[] triangleSides = paramsLine.split(" ");
        if (triangleSides.length != 3) {
            LOGGER.warn("Number of params is not 3, not valid data");
            return false;
        }
        try {
            double side1 = Double.valueOf(triangleSides[0]);
            double side2 = Double.valueOf(triangleSides[1]);
            double side3 = Double.valueOf(triangleSides[2]);

            if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                LOGGER.warn("Side length <=0, not valid data");
                return false;
            }

            if (((side1 < side2 + side3) && (side2 < side1 + side3) && (side3 < side1 + side2))){
                LOGGER.info("Got valid data line");

                return true;
            }else{
                LOGGER.warn("Each side length must be less than the others sides sum, not valid data");
            }
        } catch (NumberFormatException nfe) {
            LOGGER.warn("Illegal symbols or not right number format, not valid data");
        }

        return false;
    }
}

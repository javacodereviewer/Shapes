package com.epam.shapes.services;

import com.epam.shapes.services.validation.TriangleValidator;
import com.epam.shapes.services.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParamsReader {
    private static final Logger LOGGER = LogManager.getLogger(ParamsReader.class);
    private static final String PARAMS_FILE;
    private static final Validator TRIANGLE_VALIDATOR = new TriangleValidator();

    static {
        URL resource = ParamsReader.class.getClassLoader().getResource("shapeParams.txt");
        File f = null;
        try {
            f = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        PARAMS_FILE = f.getAbsolutePath();
    }

    public List<String> getParamsFromFile() {
        LOGGER.info(String.format("Loading shape params from default file: %s", PARAMS_FILE));
        return getParamsFromFile(PARAMS_FILE);
    }

    public List<String> getParamsFromFile(String paramsFileName) {
        List<String> shapeParamsLine = new ArrayList<>();
        try {
            final List<String> lines = Files.readAllLines(Paths.get(paramsFileName));
            LOGGER.info(String.format("Read %d lines from shape params file", lines.size()));
            for (String s : lines) {
                if (TRIANGLE_VALIDATOR.validate(s)) {
                    shapeParamsLine.add(s);
                }
            }

        } catch (IOException ioe) {
            LOGGER.error(String.format("IOException caught: %s", ioe.getMessage()), ioe);
        }
        return shapeParamsLine;
    }

}

package com.epam.shapes.services;

public class NoValidDataExcepiton extends Exception {

    public NoValidDataExcepiton() {
    }

    public NoValidDataExcepiton(String message) {
        super(message);
    }
}

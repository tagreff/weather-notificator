package com.weather.exception;

public class NumberFormatException extends RuntimeException {
    public NumberFormatException() {}
    public NumberFormatException(String message) {
        super(message);
    }
}

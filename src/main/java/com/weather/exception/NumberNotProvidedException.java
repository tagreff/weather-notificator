package com.weather.exception;

public class NumberNotProvidedException extends RuntimeException {
    public NumberNotProvidedException() {}
    public NumberNotProvidedException(String message) {
        super(message);
    }
}

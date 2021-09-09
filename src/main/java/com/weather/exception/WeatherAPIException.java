package com.weather.exception;

public class WeatherAPIException extends RuntimeException {

    public WeatherAPIException(String message) {
        super(message);
    }
}
package com.weather.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.web.client.RestTemplate;

class GetWeatherServiceTest {

    @Spy
    GetWeatherService getWeatherService;

    @Test
    void getCurrentTemperatureReturnNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            getWeatherService.getCurrentTemperature();
        });
    }
}
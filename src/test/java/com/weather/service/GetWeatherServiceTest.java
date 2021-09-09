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
        String NaberezhnyeСhelny = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";
        Assertions.assertThrows(NullPointerException.class, () -> {
            getWeatherService.getCurrentTemperature(NaberezhnyeСhelny);
        });
    }

    @Test
    void getCurrentTemperatureReturnIllegalArgumentException() {
        getWeatherService = new GetWeatherService();
        String emptyUrl = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            getWeatherService.getCurrentTemperature(emptyUrl);
        });
    }
}
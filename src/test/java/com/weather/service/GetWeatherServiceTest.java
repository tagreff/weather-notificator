package com.weather.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class GetWeatherServiceTest {
    RestTemplate restTemplate;

    @BeforeEach
    void init(){
        restTemplate = Mockito.spy(RestTemplate.class);

    }

    @Test
    void getCurrentTemperature() {

    }
}
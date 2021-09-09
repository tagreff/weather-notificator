package com.weather.service;

import com.weather.dto.CurrentWeather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Component("GetWeatherService")
public class GetWeatherService {

    public Double getCurrentTemperature(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> result = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<CurrentWeather>() {
        });
        CurrentWeather currentWeather = result.getBody();
        return currentWeather.getMain().getTemp_min() - 273.15 ; // конвертация в градусы цельсия
    }
}
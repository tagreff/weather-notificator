package com.weather.service;

import com.weather.dto.CurrentWeather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Component("GetWeatherService")
public class GetWeatherService {

    public Double getCurrentTemperature() {
        final String url = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> result = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<CurrentWeather>() {
        });
        CurrentWeather currentWeather = result.getBody();
        return currentWeather.getMain().getTemp_min() - 273.15 ; // конвертация в градусы цельсия
    }
}
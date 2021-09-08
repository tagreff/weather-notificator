package com.weather.service;

import com.weather.dto.currentWeather.CurrentWeather;
import com.weather.exception.WeatherAPIException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;

@Component("GetWeatherService")
public class GetWeatherService {
    public CurrentWeather getCurrentTemperature() {
        final String url = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> result = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<CurrentWeather>() {
        });
        CurrentWeather currentWeather = result.getBody();
        return currentWeather;
//        return parsingTemperature(result);
    }

    private double parsingTemperature(String json) {
        if (json != null) {
            String[] strTemp1 = json.split("\"temp_min\":");
            String[] strTemp2 = strTemp1[1].split(",");
            try {
                return Double.parseDouble(strTemp2[0]);
            } catch (NumberFormatException e) {
                //что-нибудь кинуть в логи
            }
            return 0.0;
        } else {
            throw new WeatherAPIException("API error");
        }
    }
}
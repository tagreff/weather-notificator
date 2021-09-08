package com.weather.service;

import com.weather.exception.WeatherAPIException;
import org.springframework.web.client.RestTemplate;

public class GetWeatherService {
    public double getCurrentTemperature() {
        final String url = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return parsingTemperature(result);
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
package com.weather.service;

import com.weather.dto.currentWeather.CurrentWeather;
//import com.weather.exception.WeatherAPIException;
import com.weather.exception.WeatherAPIException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;

@Component("GetWeatherService")
public class GetWeatherService {
    public Double getCurrentTemperature() {
        final String url = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> result = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<CurrentWeather>() {
        });
        CurrentWeather currentWeather = result.getBody();

        Optional<Double> temp = Optional.ofNullable(currentWeather.getMain().getTemp_min());
        if(temp.isPresent()){
            return temp.get() - 273.15;
        }
        throw new WeatherAPIException("Все плохо в сервисе погоды");


//        return parsingTemperature(result);
    }

//    private double parsingTemperature(String json) {
//        if (json != null) {
//            String[] strTemp1 = json.split("\"temp_min\":");
//            String[] strTemp2 = strTemp1[1].split(",");
//            try {
//                return Double.parseDouble(strTemp2[0]);
//            } catch (NumberFormatException e) {
//                //что-нибудь кинуть в логи
//            }
//            return 0.0;
//        } else {
//            throw new WeatherAPIException("API error");
//        }
//    }
}
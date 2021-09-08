package com.weather.dto.currentWeather;

import lombok.Data;

@Data
public class WeatherO {
    private Integer id;
    private String main;
    private String description;
    private String icon;
}

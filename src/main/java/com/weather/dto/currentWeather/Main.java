package com.weather.dto.currentWeather;

import lombok.Data;

@Data
public class Main {
    private Double temp;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    private Integer seaLevel;
    private Integer grndLevel;


}

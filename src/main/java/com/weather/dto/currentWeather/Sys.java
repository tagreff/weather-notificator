package com.weather.dto.currentWeather;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Sys {
    private Integer type;
    private Integer id;
    private String country;
    private Long sunrise;
    private Long sunset;
}

package com.weather.dto.currentWeather;

import lombok.Data;

@Data
public class CurrentWeather {
    private Coord coord;
    private Weather weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
    private Integer visibility;
}

package com.weather.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weather {
    private Integer id;
    private String main;
    private String description;
    private String icon;

}
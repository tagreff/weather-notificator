package com.weather.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sys {
    private Integer type;
    private Integer id;
    private String country;
    private Long sunrise;
    private Long sunset;

}
package com.weather.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wind {
    private Double speed;
    private Integer deg;
    private Double gust;

}
package com.weather.service;

import com.weather.dto.currentWeather.CurrentWeather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GetWeatherServiceTest {
    GetWeatherService getWeatherService = new GetWeatherService();

    CurrentWeather currentWeather;

    @BeforeEach
    void init(){

        currentWeather = Mockito.spy(CurrentWeather.class);


    }

    @Test
    void getCurrentTemperatureReturnIllegalStatement() {
        Assertions.assertThat(getWeatherService.getCurrentTemperature()).isGreaterThan(-70.0);
        Assertions.assertThat(getWeatherService.getCurrentTemperature()).isLessThan(60.0);
    }

//    @Test
//    void getCurrentTemperatureReturnNullPointerException(){
//        Mockito.doReturn(null).when(currentWeather.getMain().getTemp_min());
//        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> getWeatherService.getCurrentTemperature());
//    }
}
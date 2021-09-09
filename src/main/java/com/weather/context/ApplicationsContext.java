package com.weather.context;

import com.weather.service.GetWeatherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationsContext {
    public static void main(String[] args) {

        final String NaberezhnyeСhelny = "https://api.openweathermap.org/data/2.5/weather?id=523750&appid=740bff51e977096cbba34ebfa8bf3644";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        GetWeatherService getWeatherService = context.getBean("GetWeatherService", GetWeatherService.class);

        System.out.printf("%.2f%n", getWeatherService.getCurrentTemperature(NaberezhnyeСhelny));
    }
}
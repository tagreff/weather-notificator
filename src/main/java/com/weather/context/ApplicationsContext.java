package com.weather.context;

import com.weather.service.GetWeatherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationsContext {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        GetWeatherService getWeatherService = context.getBean("GetWeatherService", GetWeatherService.class);

        System.out.printf("%.2f%n", getWeatherService.getCurrentTemperature());
    }
}
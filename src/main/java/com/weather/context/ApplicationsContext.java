package com.weather.context;

import com.weather.service.GetWeatherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationsContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml");

        GetWeatherService getWeatherService = context.getBean("GetWeatherService", GetWeatherService.class);

        System.out.println(getWeatherService.getCurrentTemperature());

    }
}

package com.weather.controller;

import com.weather.dto.iqsms.SendStatus;
import com.weather.service.GetWeatherService;
import com.weather.service.SendMessageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    SendMessageService sendMessage;

    @Autowired
    GetWeatherService weatherService;

    // example http://localhost:8080/weather/9191234567
    @GetMapping(value = "/{phone}")
    public SendStatus requestMessage(@PathVariable String phone) {
        String msg = weatherService.getCurrentTemperature()<=10?
                "low temperature"
                :"high temperature";
        return sendMessage.sendMessage(phone, msg);
    }
}

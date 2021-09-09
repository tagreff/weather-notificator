package com.weather.controller;

import com.weather.service.SendMessageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController // Этот код использует @RestController аннотацию, помечая класс как контроллер, где каждый метод возвращает объект вместо представления(view). Это сокращение для @Controller и @ResponseBody, вместе взятых.
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    SendMessageService sendMessage;

    // example http://localhost:8080/weather?num=9191234567
    @GetMapping("/{num}")
    public String requestMessage(@PathVariable String num) {
        return sendMessage.sendMessage(num, "testMsg"); // методу sendMessage по идее добавить параметр number, чтобы он знал,
        // на какой номер отправлять сообщение и передать ему number
        // sendMessage() должен ли принимать String message?
       /**
        * хотя в ТЗ не указано, можно вернуть из этого метода объект Java, который будет отправляться в качестве
         * сообщения в методе sendMessage() (сделать его возвращающим данный объект)
         * Данные возвращаемого объекта из контроллера будут записаны напрямую в HTTP-ответ как JSON.
        * */
    }

    // version 2
/*    @GetMapping("/{num}")
    public void requestMessage(@PathVariable String number) {
        sendMessage.sendMessage();
    }*/
}

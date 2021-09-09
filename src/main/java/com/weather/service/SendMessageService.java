package com.weather.service;

import org.springframework.stereotype.Service;

@Service
public class SendMessageService {

    public String sendMessage (String number, String message) {
        return number +" "+ message;
    }
}

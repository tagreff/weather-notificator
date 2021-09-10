package com.weather.controller;

import com.weather.controller.WeatherController;
import com.weather.exception.SendMessageException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest{

//    @Spy
//    @InjectMocks
//    WeatherController weatherController;
//
//    @Test //expecting phone validation to fail, thus method will throw an exception
//    public void whenPhoneNumberIsInvalid_SendMessageExceptionThrown(){
//        Exception exception = assertThrows(SendMessageException.class,
//                () -> weatherController.requestMessage("5324543"));
//        //checking exception message
//        final String expectedMessage = "Invalid or null arguments in SendMessageService";
//        String actualMessage = exception.getMessage();
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
}


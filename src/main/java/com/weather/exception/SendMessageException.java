package com.weather.exception;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
public class SendMessageException extends RuntimeException {

    public SendMessageException(String message) {
        super(message);
    }
}

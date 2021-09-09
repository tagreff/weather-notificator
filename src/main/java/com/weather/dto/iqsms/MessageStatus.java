package com.weather.dto.iqsms;

import lombok.Data;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Data
public class MessageStatus {
    private String status;
    private int smscId;
    private int clientId;
}

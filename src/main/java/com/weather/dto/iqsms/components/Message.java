package com.weather.dto.iqsms.components;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Data
@Accessors(chain = true)
@Component
@PropertySource(value= {"classpath:application.properties"})
public class Message {
    private String phone;
//    @Value("${smsAPI.sender}")
//    private String sender;
    private int clientId;
    private String text;
}

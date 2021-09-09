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
public class BalanceAccount {
    @Value("${smsAPI.login}")
    private String login;
    @Value("${smsAPI.password}")
    private String password;
}

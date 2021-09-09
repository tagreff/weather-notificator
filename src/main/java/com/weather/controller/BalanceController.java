package com.weather.controller;

import com.weather.dto.iqsms.BalanceList;
import com.weather.service.GetBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@RestController
@RequestMapping("/balance")
@PropertySource(value= {"classpath:application.properties"})
public class BalanceController {
    @Autowired
    GetBalanceService getBalance;

    // example http://localhost:8080/balance/
    @GetMapping("/")
    public BalanceList getBalance() {
        return getBalance.getBalance();
    }
}

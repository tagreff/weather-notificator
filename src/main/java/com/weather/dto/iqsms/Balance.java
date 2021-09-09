package com.weather.dto.iqsms;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Data
public class Balance {
    private BigDecimal credit;
    private BigDecimal balance;
    private String type;
}

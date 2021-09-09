package com.weather.dto.iqsms;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Data
@Accessors(chain = true)
public class BalanceList {
    private String status;
    private List<Balance> balance;
}

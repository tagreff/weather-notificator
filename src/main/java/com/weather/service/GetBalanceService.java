package com.weather.service;

import com.weather.dto.iqsms.BalanceList;
import com.weather.dto.iqsms.components.BalanceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Service
public class GetBalanceService {
    final String url = "https://api.iqsms.ru/messages/v2/balance.json";
    @Autowired
    BalanceAccount account;

    public BalanceList getBalance() {
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BalanceAccount> entity = new HttpEntity<>(account, headers);

        // send request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BalanceList> response = restTemplate.exchange(url, POST, entity, BalanceList.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            if(response.getBody() != null) {
                return response.getBody();
            }
        }
        return new BalanceList().setStatus("failed");
    }
}

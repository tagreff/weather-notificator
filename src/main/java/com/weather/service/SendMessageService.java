package com.weather.service;

import com.weather.dto.iqsms.SendStatus;
import com.weather.dto.iqsms.components.Message;
import com.weather.dto.iqsms.components.SendMessage;
import com.weather.exception.SendMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

/**
 * @author Oleksandr Storozhuk
 * @version 0.0.1
 * created on 09.09.2021
 */
@Service
public class SendMessageService {
    private final String url = "https://api.iqsms.ru/messages/v2/send.json";
    @Autowired
    private Message message;
    @Autowired
    private SendMessage sendMessage;
    private int messageId;

    public SendStatus sendMessage (String number, String text) {
        if(number == null || text == null) {
            throw new SendMessageException("Null arguments in SendMessageService");
        }

        // encode UTF-8
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        String utf8text = new String(bytes, StandardCharsets.UTF_8);

        // TODO: check phone number

        sendMessage.setMessages(List.of(message
                .setPhone(number)
                .setClientId(++messageId)
                .setText(utf8text)));

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMessage> entity = new HttpEntity<>(sendMessage, headers);

        // send request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SendStatus> response = restTemplate.exchange(url, POST, entity, SendStatus.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            if(response.getBody() != null) {
                return response.getBody();
            }
        }
        return new SendStatus().setStatus("failed");
    }
}

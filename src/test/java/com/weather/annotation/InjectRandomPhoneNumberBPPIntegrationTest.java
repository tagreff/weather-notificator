package com.weather.annotation;

import com.weather.configuration.AppConfig;
import com.weather.dto.phoneNumber.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class InjectRandomPhoneNumberBPPIntegrationTest {
    @InjectRandomNumber
    PhoneNumber phoneNumber;
    @InjectRandomNumber
    PhoneNumber phoneNumber1;

    @Test
    public void shouldInjectAndNotBeNull() {
        assertNotNull(phoneNumber);
    }

    @Test
    public void shouldNotBeSame() {
        assertNotEquals(phoneNumber, phoneNumber1);
    }
}

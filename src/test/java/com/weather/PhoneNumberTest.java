package com.weather;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "*")
@RecordApplicationEvents
public class PhoneNumberTest {
    @InjectRandomNumber
    PhoneNumber phoneNumber;
    @InjectRandomNumber
    PhoneNumber phoneNumber1;

    @Test
    public void generatedNumberTest() {
        Assert.assertNotNull(phoneNumber);
        Assert.assertNotSame(phoneNumber,phoneNumber1);
    }

}

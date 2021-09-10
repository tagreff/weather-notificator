package com.weather.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberValidatorTest {
    final String validNumber = "9111471546";
    @Test
    public void validateValidNumber_returnsTrue(){
        assertTrue(PhoneNumberValidator.isValid(validNumber));
    }
}

package com.weather.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberValidatorTest {
    final String validNumber = "9111471546";
    final String invalidNumber = "5555";
    @Test
    public void validateValidNumber_returnsTrue(){
        assertTrue(PhoneNumberValidator.isValid(validNumber));
    }
    @Test
    public void validateInvalidNumber_returnsFalse(){
        assertFalse(PhoneNumberValidator.isValid(invalidNumber));
    }
}

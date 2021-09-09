package com.weather;

import com.weather.impl.InjectRandomNumber;
import com.weather.impl.InjectRandomNumberAnnotationBPP;
import com.weather.model.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class InjectRandomNumberBPP {

    private final InjectRandomNumberAnnotationBPP injectRandomNumberAnnotationBeanPostProcessor = new InjectRandomNumberAnnotationBPP();

    @Test
    public void should_inject_phone_number_and_all_fields_must_be_not_null(){
        TestClassWithFieldAnnotatedWithInjectRandomNumber objectWithFieldToInject = new TestClassWithFieldAnnotatedWithInjectRandomNumber();

        injectRandomNumberAnnotationBeanPostProcessor.postProcessBeforeInitialization(objectWithFieldToInject, "TestClass");

        PhoneNumber phoneNumber = objectWithFieldToInject.getPhoneNumber();
        Assertions.assertNotNull(phoneNumber);
        Assertions.assertNotNull(phoneNumber.getNumber());
        Assertions.assertNotNull(phoneNumber.getCountryCode());
    }

    @Test
    public void should_inject_each_time_different_phone_number(){
        TestClassWithFieldAnnotatedWithInjectRandomNumber objectWithFieldToInject = new TestClassWithFieldAnnotatedWithInjectRandomNumber();
        injectRandomNumberAnnotationBeanPostProcessor.postProcessBeforeInitialization(objectWithFieldToInject, "TestClass");
        PhoneNumber phoneNumber1 = objectWithFieldToInject.getPhoneNumber();
        injectRandomNumberAnnotationBeanPostProcessor.postProcessBeforeInitialization(objectWithFieldToInject, "TestClass");
        PhoneNumber phoneNumber2 = objectWithFieldToInject.getPhoneNumber();
        Assertions.assertNotEquals(phoneNumber2, phoneNumber1);
    }

        class TestClassWithFieldAnnotatedWithInjectRandomNumber {
        @InjectRandomNumber
        public PhoneNumber phoneNumber;

        public PhoneNumber getPhoneNumber() {
            return phoneNumber;
        }
    }

}

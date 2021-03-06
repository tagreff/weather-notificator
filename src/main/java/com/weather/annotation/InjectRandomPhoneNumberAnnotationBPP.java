package com.weather.annotation;

import com.weather.dto.phoneNumber.CountryCode;
import com.weather.dto.phoneNumber.PhoneNumber;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;

@Component
public class InjectRandomPhoneNumberAnnotationBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectRandomNumber annotation = field.getAnnotation(InjectRandomNumber.class);
            if (annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, createRandomPhoneNumber());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private static CountryCode generateRandomCountryCode(){
        CountryCode[] countryCodesArray = CountryCode.values();
        int randomIndex = (int) ((Math.random() * (countryCodesArray.length - 1)));
        return countryCodesArray[randomIndex];
    }

    private static String generateRandomNumber() {
        StringBuilder randomGeneratedNumber = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            randomGeneratedNumber.append((int) (Math.random() * 10));
        }
        return randomGeneratedNumber.toString();
    }

    private static PhoneNumber createRandomPhoneNumber() {
        CountryCode countryCode = generateRandomCountryCode();
        String randomNumber = generateRandomNumber();
        int digitsCountOfCountryCode = String.valueOf(countryCode.getCode()).length();                  // ???????????????? ???????????????????? ???????????????? ???????? ????????????
        String substring = randomNumber.substring(0, randomNumber.length() - digitsCountOfCountryCode); // ???????????????? ???????????? ??????????, ?????????? ?? ?????????? ?? ?????????? ???????????? ???????????????????? ???? ?????????? 15 ???????? (???????????????? E.164)

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode(countryCode);
        phoneNumber.setNumber(substring);

        return phoneNumber;
    }
}

package com.weather.impl;

import com.weather.model.CountryCode;
import com.weather.model.PhoneNumber;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;

public class InjectRandomNumberAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field :
                declaredFields) {
            InjectRandomNumber annotation = field.getAnnotation(InjectRandomNumber.class);
            if (annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, createPojoRandomNumber());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    /**
     * @return
     */

    private static String generateRandomNumber() {
        StringBuilder randomGeneratedNumber = new StringBuilder();
        for (int i = 0; i < (int) (Math.random() * ((12 - 11) + 1)) + 11; i++) {
            randomGeneratedNumber.append((int) (Math.random() * 10));
        }
        return randomGeneratedNumber.toString();
    }

    private static PhoneNumber createPojoRandomNumber() {
        PhoneNumber number = new PhoneNumber();
        String s = generateRandomNumber();
        if (s.substring(0, 1).equals(String.valueOf(CountryCode.RU.getCode()))) {
            number.setCountry(CountryCode.RU.getCountry());
            number.setCode(String.valueOf(CountryCode.RU.getCode()));
            number.setNumber(s);
        } else if (s.substring(0, 2).equals(String.valueOf(CountryCode.UA.getCode()))) {
            number.setCountry(CountryCode.UA.getCountry());
            number.setCode(String.valueOf(CountryCode.UA.getCode()));
            number.setNumber(s);
        } else if (s.substring(0, 2).equals(String.valueOf(CountryCode.BZ.getCode()))) {
            number.setCountry(CountryCode.BZ.getCountry());
            number.setCode(String.valueOf(CountryCode.BZ.getCode()));
            number.setNumber(s);
        } else {
            number.setCountry(CountryCode.UNKNOWN.getCountry());
            number.setCode(String.valueOf(CountryCode.UNKNOWN.getCode()));
            number.setNumber(s);
        }
        return number;
    }
}

package com.weather.annotation;

import com.weather.exception.NumberNotProvidedException;
import com.weather.dto.phoneNumber.CountryCode;
import com.weather.dto.phoneNumber.PhoneNumber;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.regex.Pattern;


public class PhoneNumberArgumentResolver implements HandlerMethodArgumentResolver {

    private final static Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^[0-9]{10,12}$");

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(com.weather.annotation.PhoneNumber.class) != null &&
                methodParameter.getParameterType() == PhoneNumber.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws RuntimeException {
        String countryCodeHeader = nativeWebRequest.getHeader("CountryCode");
        countryCodeHeader = countryCodeHeader != null ? countryCodeHeader : "";
        String phoneNumberParameter = nativeWebRequest.getParameter("num");
        if (phoneNumberParameter == null) {
            throw new NumberNotProvidedException();
        } else if (!PHONE_NUMBER_PATTERN.matcher(phoneNumberParameter).matches()) {
            throw new NumberFormatException("number doesn't satisfies regex format: " + PHONE_NUMBER_PATTERN.pattern());
        }

        CountryCode countryCode;
        try {
            countryCode = CountryCode.valueOf(countryCodeHeader.toUpperCase());
        } catch (IllegalArgumentException exception) {
            countryCode = CountryCode.UNKNOWN;
        }

        return new PhoneNumber(countryCode, phoneNumberParameter);
    }
}

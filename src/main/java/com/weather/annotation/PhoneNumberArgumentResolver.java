package com.weather.annotation;

import com.weather.exception.NumberNotProvidedException;
import com.weather.model.CountryCode;
import com.weather.model.PhoneNumber;
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
        return methodParameter.getParameter().getType() == PhoneNumber.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String countryCodeHeader = nativeWebRequest.getHeader("CountryCode");
        countryCodeHeader = countryCodeHeader != null ? countryCodeHeader : "";
        String phoneNumberParameter = nativeWebRequest.getParameter("num");
        if (phoneNumberParameter == null) {
            throw new NumberNotProvidedException();
        } else if (!PHONE_NUMBER_PATTERN.matcher(phoneNumberParameter).matches()) {
            throw new NumberFormatException("number doesn't satisfies regex format: " + PHONE_NUMBER_PATTERN.pattern());
        }

        CountryCode countryCode;
        // case agnostic comparison
        if (countryCodeHeader.equals("")) {
            countryCode = CountryCode.UNKNOWN;
        } else if (countryCodeHeader.equalsIgnoreCase("RU")) {
            countryCode = CountryCode.RU;
        } else if (countryCodeHeader.equalsIgnoreCase("BY")) {
            countryCode = CountryCode.BZ;
        } else if (countryCodeHeader.equalsIgnoreCase("UA")) {
            countryCode = CountryCode.UA;
        } else {
            countryCode = CountryCode.UNKNOWN;
        }
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(phoneNumberParameter);
        phoneNumber.setCode(countryCode.getCountry());
        phoneNumber.setCode(String.valueOf(countryCode.getCode()));

        return phoneNumber;
    }
}

package com.weather.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.weather.exception.NumberNotProvidedException;
import com.weather.model.CountryCode;
import com.weather.model.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

@ExtendWith(MockitoExtension.class)
class PhoneNumberArgumentResolverTest {

    @Mock
    private MethodParameter methodParameter;

    @Mock
    private ModelAndViewContainer modelAndViewContainer;

    @Mock
    private NativeWebRequest nativeWebRequest;

    @Mock
    private WebDataBinderFactory webDataBinderFactory;

    private final PhoneNumberArgumentResolver phoneNumberArgumentResolver = new PhoneNumberArgumentResolver();

    private final static String OK_PHONE_NUMBER = "0121234567";
    private final static String TOO_LONG_PHONE_NUMBER = "0121234567890";
    private final static String UNEXPECTED_SYMBOLS_PHONE_NUMBER = "012-123-45";
    private final static String OK_COUNTRY_CODE = "RU";
    private final static String UNKNOWN_COUNTRY_CODE = "BAD_COUNTRY_CODE";

    @Test
    void resolveArgument_OkHeaderAndOkParam_OkPhoneNumber() {
        final PhoneNumber EXPECTED_PHONE_NUMBER = new PhoneNumber(CountryCode.RU, "0121234567");

        Mockito.when(nativeWebRequest.getHeader(Mockito.eq("CountryCode"))).thenReturn(OK_COUNTRY_CODE);
        Mockito.when(nativeWebRequest.getParameter(Mockito.eq("num"))).thenReturn(OK_PHONE_NUMBER);
        PhoneNumber actualPhoneNumber = (PhoneNumber) phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);

        assertEquals(EXPECTED_PHONE_NUMBER, actualPhoneNumber);
    }

    @Test
    void resolveArgument_NoHeaderAndOkParam_PhoneNumberWithUNKOWNCountryCode() {
        final PhoneNumber EXPECTED_PHONE_NUMBER = new PhoneNumber(CountryCode.UNKNOWN, "0121234567");

        Mockito.when(nativeWebRequest.getParameter(Mockito.eq("num"))).thenReturn(OK_PHONE_NUMBER);
        PhoneNumber actualPhoneNumber = (PhoneNumber) phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);

        assertEquals(EXPECTED_PHONE_NUMBER, actualPhoneNumber);
    }

    @Test
    void resolveArgument_HeaderWithUnknownValueAndOkParam_PhoneNumberWithUNKOWNCountryCode() {
        final PhoneNumber EXPECTED_PHONE_NUMBER = new PhoneNumber(CountryCode.UNKNOWN, "0121234567");

        Mockito.when(nativeWebRequest.getHeader(Mockito.eq("CountryCode"))).thenReturn(UNKNOWN_COUNTRY_CODE);
        Mockito.when(nativeWebRequest.getParameter(Mockito.eq("num"))).thenReturn(OK_PHONE_NUMBER);
        PhoneNumber actualPhoneNumber = (PhoneNumber) phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);

        assertEquals(EXPECTED_PHONE_NUMBER, actualPhoneNumber);
    }

    @Test
    void resolveArgument_NoParam_ThrowsNumberNotProvidedException() {
        assertThrows(NumberNotProvidedException.class, () -> {
            phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        });
    }

    @Test
    void resolveArgument_ParamWithWrongNumberFormat_ThrowsNumberFormatException() {
        Mockito.when(nativeWebRequest.getParameter(Mockito.eq("num"))).thenReturn(TOO_LONG_PHONE_NUMBER);
        assertThrows(NumberFormatException.class, () -> {
            phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        });

        Mockito.when(nativeWebRequest.getParameter(Mockito.eq("num"))).thenReturn(UNEXPECTED_SYMBOLS_PHONE_NUMBER);
        assertThrows(NumberFormatException.class, () -> {
            phoneNumberArgumentResolver.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        });
    }
}
package com.weather.configuration;

import com.weather.annotation.PhoneNumberArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class PhoneNumberArgumentResolverConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(
      List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PhoneNumberArgumentResolver());
    }
}

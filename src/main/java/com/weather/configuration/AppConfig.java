package com.weather.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.weather")
@Import(PhoneNumberArgumentResolverConfiguration.class)
public class AppConfig {
}


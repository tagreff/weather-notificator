package com.weather.dto.phoneNumber;

public enum CountryCode {
    RU(7, "Россия"),
    BY(375, "Беларусь"),
    UA(380, "Украина"),
    UNKNOWN();

    int code;
    String country;

    CountryCode(int code, String country) {
        this.code = code;
        this.country = country;
    }

    CountryCode() {
    }

    public int getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }
}

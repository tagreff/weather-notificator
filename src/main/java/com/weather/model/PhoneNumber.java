package com.weather.model;

public class PhoneNumber {
    private String country;
    private String code;
    private String number;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "country='" + country + '\'' +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

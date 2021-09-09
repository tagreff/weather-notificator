package com.weather.model;

public class PhoneNumber {
    private CountryCode countryCode;
    private String number;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber)obj;
        if (!this.number.equals(phoneNumber.getNumber()))
            return false;
        return this.countryCode == phoneNumber.getCountryCode();
    }
}

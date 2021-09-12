package com.weather.dto.phoneNumber;

import lombok.*;

@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
    @NonNull
    private CountryCode countryCode;
    @NonNull
    private String number;
}

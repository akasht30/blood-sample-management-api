package com.example.bms.requestdto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {


    private String addressLine;
    private String landMark;
    private String area;
    private String city;
    private String state;
    private String country;
    private int pinCode;
}

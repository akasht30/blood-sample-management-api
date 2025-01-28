package com.example.bms.resposedto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private int addressId;
    private String addressLine;
    private String landMark;
    private String area;
    private String city;
    private String state;
    private String country;
    private int pinCode;

}

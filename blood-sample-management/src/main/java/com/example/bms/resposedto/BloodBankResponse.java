package com.example.bms.resposedto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankResponse {

    private int bankId;
    private String bankName;
    private int emergencyUnits;
}

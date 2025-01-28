package com.example.bms.requestdto;


import com.example.bms.entity.enums.BloodGroup;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private BloodGroup bloodGroup;
    private boolean availability;
    private int availableUnits;
    private int emergencyUnits;
    private int quantity;

}

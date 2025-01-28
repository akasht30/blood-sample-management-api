package com.example.bms.resposedto;

import com.example.bms.entity.enums.BloodGroup;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleResponse {

    private int sampleId;
    private BloodGroup bloodGroup;
    private boolean availability;
    private int availableUnits;
    private int emergencyUnits;
    private int quantity;

}

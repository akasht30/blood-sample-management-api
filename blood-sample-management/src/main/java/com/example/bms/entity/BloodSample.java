package com.example.bms.entity;

import com.example.bms.entity.enums.BloodGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BloodSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;
    private BloodGroup bloodGroup;
    private int quantity;
    private boolean availability;
    private int emergencyUnits;
    private int availableUnits;







}

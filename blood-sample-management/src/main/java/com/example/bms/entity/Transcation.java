package com.example.bms.entity;

import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.TransactionType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transcation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private LocalDate date;
    private BloodGroup bloodGroup;
    private TransactionType transactionType;
    private int noOfUnits;


}

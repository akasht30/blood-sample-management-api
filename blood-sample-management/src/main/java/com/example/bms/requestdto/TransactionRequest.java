package com.example.bms.requestdto;

import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.TransactionType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private LocalDate date;
    private BloodGroup bloodGroup;
    private TransactionType transactionType;
    private int noOfUnits;
}

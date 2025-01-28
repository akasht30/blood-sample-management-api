package com.example.bms.requestdto;

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
    private int noOfUnits;
}

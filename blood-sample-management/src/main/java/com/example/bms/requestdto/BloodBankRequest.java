package com.example.bms.requestdto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankRequest {

    @NotNull
    @NotBlank
    @Pattern( regexp = "^[A-Za-z\\s]+$"
            ,
            message = "Invalid blood bank name! Only alphabetic letters (A-Z, a-z) are allowed.")
    private String bankName;
    private int emergencyUnits;

}

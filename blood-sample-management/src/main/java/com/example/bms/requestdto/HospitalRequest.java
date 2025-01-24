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
public class HospitalRequest {

    @NotNull
    @NotBlank
    @Pattern( regexp = "^[A-Za-z\\s]{3,100}$\n"
            ,
            message = "Invalid Hospital name! Only alphabetic letters (A-Z, a-z) are allowed.")
    private String hospitalName;
}

package com.example.bms.requestdto;

import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.Gender;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotNull( message="User Name be not null")
    @NotBlank( message = "User name be not blank")
    @Pattern( regexp = "^[A-Za-z]+$",
            message = "Invalid username! Only alphabetic letters (A-Z, a-z) are allowed.")
    private String userName;
    @NotNull
    @NotBlank
    @Email( message = "Enter valid email id")

    private String email;
    @NotNull
    @NotBlank
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Invalid mobile number! It must contain exactly 10 digits."
    )

    private String phoneNumber;
    @Min(18)
    @Max(70)
    private int age;
    @NotNull( message="Paasword be not null")
    @NotBlank( message = "Paasword be not blank")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$%&*!])[A-Za-z0-9@$%&*!]{8,}$",
            message = "Password must be at least 8 characters long, contain one uppercase letter, one number, and one special character (@, $, %, &, *, !)."
    )

    private String password;
    @Enumerated
    private BloodGroup bloodGroup;
    @Enumerated
    private Gender gender;
    @NotBlank
    @NotNull
    @Pattern( regexp = "^[A-Za-z]+$",
            message = "Invalid city name! Only alphabetic letters (A-Z, a-z) are allowed.")
    private String availableCity;
    private LocalDate lastDonatedAt;


}

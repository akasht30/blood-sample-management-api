package com.example.bms.resposedto;

import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.Gender;
import com.example.bms.entity.enums.UserRole;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int userId;
    private String userName;
    private int age;
    private LocalDate lastDonatedAt;
    private String availableCity;
    private boolean verfied;
    @Enumerated
    private BloodGroup bloodGroup;
    @Enumerated
    private Gender gender;
    @Enumerated
    private UserRole role;


}

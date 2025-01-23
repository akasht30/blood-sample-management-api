package com.example.bms.requestdto;

import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.Gender;
import com.example.bms.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    @Enumerated
    private BloodGroup bloodGroup;
    @Enumerated
    private Gender gender;
    @Enumerated
    private Role role;
    private String availableCity;


}

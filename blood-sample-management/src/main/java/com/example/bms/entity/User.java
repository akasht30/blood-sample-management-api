
package com.example.bms.entity;


import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.Gender;
import com.example.bms.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private int age;
    private LocalDate lastDonatedAt;
    private String availableCity;
    private boolean verfied;
    private LocalDate registeredDate;
    private LocalDateTime lastUpdatedTime;
    @Enumerated
    private BloodGroup bloodGroup;
    @Enumerated
    private Gender gender;
    @Enumerated
    private UserRole role;


    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private Admin admin;

    @OneToOne
    private Address address;




}




package com.example.bms.entity;


import com.example.bms.entity.enums.BloodGroup;
import com.example.bms.entity.enums.Gender;
import com.example.bms.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Role role;




    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getLastDonatedAt() {
        return lastDonatedAt;
    }

    public void setLastDonatedAt(LocalDate lastDonatedAt) {
        this.lastDonatedAt = lastDonatedAt;
    }

    public String getAvailableCity() {
        return availableCity;
    }

    public void setAvailableCity(String availableCity) {
        this.availableCity = availableCity;
    }

    public boolean isVerfied() {
        return verfied;
    }

    public void setVerfied(boolean verfied) {
        this.verfied = verfied;
    }
}



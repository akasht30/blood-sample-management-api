package com.example.bms.service;


import com.example.bms.requestdto.AddressRequest;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.AddressResponse;
import com.example.bms.resposedto.AdminResponse;

import com.example.bms.resposedto.UserResponse;

import java.time.LocalDate;


public interface UserService {


    public UserResponse addUser(UserRequest userRequest);
    public UserResponse findUserById();
    public UserResponse updateUserById(UserRequest user);
    public UserResponse promoteUser( int userId);

    public AdminResponse addAdmin(UserRequest userRequest);

    public UserResponse verifyUser(int userId, boolean isVerifed);

    public UserResponse updateLastDonated(int userId, LocalDate lastDonatedAt);


}

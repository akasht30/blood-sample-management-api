package com.example.bms.service;


import com.example.bms.entity.User;
import com.example.bms.repository.UserRepository;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.UserResponse;


public interface UserService {

    public UserResponse addUser(UserRequest userRequest);
    public UserResponse findUserById(int userId);
    public UserResponse updateUserById(UserRequest user, int userId);
}

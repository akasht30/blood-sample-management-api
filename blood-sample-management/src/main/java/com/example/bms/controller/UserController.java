package com.example.bms.controller;

import com.example.bms.entity.User;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.UserResponse;
import com.example.bms.service.UserService;
import com.example.bms.utility.ResponseStructure;
import com.example.bms.utility.RestResponseBuilder;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest){
        UserResponse user = userService.addUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "user created", user);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId) {
        UserResponse user = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "user found", user);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>>  updateUser(@RequestBody UserRequest user, @PathVariable int userId) {
        UserResponse user1 = userService.updateUserById(user,userId);
        return responseBuilder.success(HttpStatus.OK, "Updated successfully", user1);

    }


}

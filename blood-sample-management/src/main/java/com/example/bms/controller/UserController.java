package com.example.bms.controller;

import com.example.bms.entity.User;
import com.example.bms.requestdto.AddressRequest;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.AddressResponse;
import com.example.bms.resposedto.AdminResponse;

import com.example.bms.resposedto.UserResponse;
import com.example.bms.service.UserService;
import com.example.bms.utility.ResponseStructure;
import com.example.bms.utility.RestResponseBuilder;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse user = userService.addUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "user created", user);
    }

    @GetMapping("/account")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById() {
        UserResponse user = userService.findUserById();
        return responseBuilder.success(HttpStatus.FOUND, "user found", user);
    }

    @PutMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>>  updateUser(@RequestBody UserRequest user) {
        UserResponse user1 = userService.updateUserById(user);
        return responseBuilder.success(HttpStatus.OK, "Updated successfully", user1);

    }

    @PreAuthorize("hasAuthority('OWNER_ADMIN')")
    @PutMapping("/promote/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>>  promoteUser(@PathVariable int userId) {
        UserResponse user1 = userService.promoteUser(userId);
        return responseBuilder.success(HttpStatus.OK, "Updated successfully", user1);

    }




    @PostMapping("/register-admin")
    public ResponseEntity<ResponseStructure<AdminResponse>>  addUserAdmin(@RequestBody UserRequest userRequest) {
        AdminResponse admin = userService.addAdmin(userRequest);
        return responseBuilder.success(HttpStatus.OK, "Added admin  successfully", admin);

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/verify/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>>  verifyUser(@PathVariable int userId,@RequestParam boolean isVerifed) {

        UserResponse user=userService.verifyUser(userId,isVerifed);

        return responseBuilder.success(HttpStatus.OK, "Verified  by admin  successfully",user );

    }

    @PatchMapping("/update-lastDonated/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>>  updateLastDonated(@PathVariable int userId,@RequestParam LocalDate lastDonatedAt) {

        UserResponse user=userService.updateLastDonated(userId,lastDonatedAt);

        return responseBuilder.success(HttpStatus.OK, "Last donated date is updated",user );

    }



}

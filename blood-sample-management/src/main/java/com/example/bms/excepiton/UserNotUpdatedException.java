package com.example.bms.excepiton;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotUpdatedException extends RuntimeException {
    private final String message;

}

package com.example.bms.excepiton;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UserNotFoundByidException extends RuntimeException {

private final String message;


}

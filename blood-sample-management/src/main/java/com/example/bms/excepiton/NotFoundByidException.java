package com.example.bms.excepiton;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class NotFoundByidException extends RuntimeException {

private final String message;


}

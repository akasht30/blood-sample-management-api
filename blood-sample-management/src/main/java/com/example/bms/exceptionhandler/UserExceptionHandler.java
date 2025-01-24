package com.example.bms.exceptionhandler;


import com.example.bms.excepiton.UserNotFoundByidException;
import com.example.bms.excepiton.UserNotUpdatedException;
import com.example.bms.utility.ErrorStructure;
import com.example.bms.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {

    private final RestResponseBuilder restResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByidException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(), "user not found by id");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotUpdated(UserNotUpdatedException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"user not updated");
    }
}

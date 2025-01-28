package com.example.bms.exceptionhandler;


import com.example.bms.excepiton.NotFoundByidException;
import com.example.bms.excepiton.NotFoundException;
import com.example.bms.excepiton.NotUpdatedException;
import com.example.bms.utility.ErrorStructure;
import com.example.bms.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class EntityExceptionHandler {

    private final RestResponseBuilder restResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(NotFoundByidException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(), "data not found by id");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotUpdated(NotUpdatedException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"data not updated");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotUpdated(NotFoundException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"Data is not Found");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUsernameNotUpdated(UsernameNotFoundException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"Failed to authenticate user");
    }


}

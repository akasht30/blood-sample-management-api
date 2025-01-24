package com.example.bms.exceptionhandler;

import com.example.bms.utility.ErrorStructure;
import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ObjectError> ObjectErrors = ex.getAllErrors();
        List<FieldErrorStructure> errors = new ArrayList<>();

        for (Object objectError : ObjectErrors) {

            FieldError error = (FieldError) objectError;
            errors.add(FieldErrorStructure.builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .rejectedValue(error.getRejectedValue())
                    .build());


        }
       ErrorStructure<List<FieldErrorStructure>> error=new ErrorStructure<>();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Invalid data input");
        error.setRootCause(errors);

        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FieldErrorStructure {
        private String field;
        private Object rejectedValue;
        private String message;
    }




}

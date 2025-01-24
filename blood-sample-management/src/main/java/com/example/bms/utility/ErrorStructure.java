package com.example.bms.utility;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorStructure<T> {

    private int status;
    private String message;
    private T rootCause;

}

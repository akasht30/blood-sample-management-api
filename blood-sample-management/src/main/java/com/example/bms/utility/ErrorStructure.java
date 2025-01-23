package com.example.bms.utility;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorStructure {

    private int status;
    private String message;
    private String rootCause;

}

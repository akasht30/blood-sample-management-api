package com.example.bms.utility;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {

    private int status;
    private String message;
    private T data;


}

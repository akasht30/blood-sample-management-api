package com.example.bms.resposedto;

import com.example.bms.entity.User;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {

    private int adminId;
    private User user;
}

package com.example.bms.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminID;


    @OneToOne
   private User user;





}

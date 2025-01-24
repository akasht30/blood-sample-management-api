package com.example.bms.repository;

import com.example.bms.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository  extends JpaRepository<BloodBank,Integer> {

}

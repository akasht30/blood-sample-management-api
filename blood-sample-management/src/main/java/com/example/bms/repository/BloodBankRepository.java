package com.example.bms.repository;


import com.example.bms.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodBankRepository  extends JpaRepository<BloodBank,Integer> {

    public List<BloodBank> findByAddress_CityIn(List<String> cities);


}

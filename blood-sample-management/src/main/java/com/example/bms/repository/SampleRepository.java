package com.example.bms.repository;

import com.example.bms.entity.BloodSample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<BloodSample,Integer> {


}

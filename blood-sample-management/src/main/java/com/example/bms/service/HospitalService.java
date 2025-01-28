package com.example.bms.service;

import com.example.bms.requestdto.HospitalRequest;
import com.example.bms.resposedto.HospitalResponse;

import java.util.List;

public interface HospitalService {

    public HospitalResponse addHospital(HospitalRequest hospitalRequest);
    public HospitalResponse getById(int hospitalId);
    public HospitalResponse updatedById(HospitalRequest hospitalRequest,int hospitalId);
    public List<HospitalResponse> findAllHospitals();


}

package com.example.bms.serviceimplementation;

import com.example.bms.entity.Hospital;
import com.example.bms.excepiton.UserNotUpdatedException;
import com.example.bms.repository.HospitalRepository;
import com.example.bms.requestdto.HospitalRequest;

import com.example.bms.resposedto.HospitalResponse;
import com.example.bms.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalServiceImplementation implements HospitalService {

    private final HospitalRepository hospitalRepository;
/// /--------------------=======================


    private Hospital mapToHospital(HospitalRequest hospitalRequest, Hospital hospital) {
        hospital.setHospitalName(hospitalRequest.getHospitalName());

        return hospital;
    }

    private HospitalResponse mapToHospitalResponse(Hospital hospital) {
        return HospitalResponse.builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }

///---------================--------------
    @Override
    public HospitalResponse addHospital(HospitalRequest hospitalRequest) {

        Hospital hospital=this.mapToHospital(hospitalRequest,new Hospital());

       hospital = hospitalRepository.save(hospital);

        return mapToHospitalResponse(hospital);
    }

    @Override
    public HospitalResponse getById(int hospitalId) {

        Optional<Hospital> optional=hospitalRepository.findById(hospitalId);

        if(optional.isEmpty())
            throw new UserNotUpdatedException("Hospital is not found!") ;

        Hospital hospital=optional.get();


        return mapToHospitalResponse(hospital);
    }

    @Override
    public HospitalResponse updatedById(HospitalRequest hospitalRequest,int hospitalId) {

        Optional<Hospital> optional=hospitalRepository.findById(hospitalId);

        if(optional.isEmpty())
            throw new UserNotUpdatedException("Failed to update");

        Hospital hospital=mapToHospital(hospitalRequest,optional.get());
        hospitalRepository.save(hospital);
        return mapToHospitalResponse(hospital);


    }

    @Override
    public List<HospitalResponse> findAllHospitals() {
        return  hospitalRepository.findAll()
                .stream()
                .map(this::mapToHospitalResponse)
                .collect(Collectors.toList());
    }
}

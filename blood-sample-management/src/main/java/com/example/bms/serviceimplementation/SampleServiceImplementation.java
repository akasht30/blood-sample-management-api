package com.example.bms.serviceimplementation;


import com.example.bms.entity.BloodSample;
import com.example.bms.excepiton.NotFoundByidException;
import com.example.bms.repository.SampleRepository;

import com.example.bms.requestdto.SampleRequest;
import com.example.bms.resposedto.SampleResponse;
import com.example.bms.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SampleServiceImplementation implements SampleService {


    private  final SampleRepository sampleRepository;

    /// /--------------------=======================


    private  BloodSample mapToBloodSample(SampleRequest sampleRequest, BloodSample bloodSample) {
        bloodSample.setBloodGroup(sampleRequest.getBloodGroup());
        bloodSample.setEmergencyUnits(sampleRequest.getEmergencyUnits());
        bloodSample.setAvailableUnits(sampleRequest.getAvailableUnits());
        bloodSample.setQuantity(sampleRequest.getQuantity());

        return bloodSample;
    }

    private SampleResponse mapToSampleResponse(BloodSample bloodSample) {
        return SampleResponse.builder()
                .sampleId(bloodSample.getSampleId())
                .bloodGroup(bloodSample.getBloodGroup())
                .availableUnits(bloodSample.getAvailableUnits())
                .emergencyUnits(bloodSample.getEmergencyUnits())
                .build();
    }

    ///---------================--------------
    @Override
    public SampleResponse addSample(SampleRequest sampleRequest) {


        BloodSample bloodSample=mapToBloodSample(sampleRequest,new BloodSample());

        bloodSample=sampleRepository.save(bloodSample);

        return mapToSampleResponse(bloodSample);
    }

    @Override
    public SampleResponse getSample(int sampleId) {

        Optional<BloodSample> optional=sampleRepository.findById(sampleId);

        if(optional.isEmpty())
                throw new NotFoundByidException("Sample is not found");
        BloodSample bloodSample=optional.get();


        return mapToSampleResponse(bloodSample);
    }

    @Override
    public SampleResponse updateById(SampleRequest sampleRequest, int sampleId) {

        Optional<BloodSample> optional=sampleRepository.findById(sampleId);

        if(optional.isEmpty())
            throw new NotFoundByidException("Sample is not found");

        BloodSample bloodSample=mapToBloodSample(sampleRequest, optional.get());

        return mapToSampleResponse(bloodSample);
    }



}

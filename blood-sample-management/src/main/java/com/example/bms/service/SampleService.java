package com.example.bms.service;

import com.example.bms.requestdto.SampleRequest;
import com.example.bms.resposedto.SampleResponse;
import jakarta.validation.Valid;

public interface SampleService {
    public SampleResponse addSample(@Valid SampleRequest sampleRequest);

    public SampleResponse getSample(int sampleId);

    public SampleResponse updateById(SampleRequest sampleRequest, int sampleId);
}

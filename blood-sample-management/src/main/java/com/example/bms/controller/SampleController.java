package com.example.bms.controller;


import com.example.bms.requestdto.SampleRequest;
import com.example.bms.resposedto.SampleResponse;
import com.example.bms.service.SampleService;
import com.example.bms.utility.ResponseStructure;
import com.example.bms.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/add-Sample")
    public ResponseEntity<ResponseStructure<SampleResponse>> addSample(@RequestBody @Valid SampleRequest sampleRequest){
        SampleResponse sample = sampleService.addSample(sampleRequest);
        return responseBuilder.success(HttpStatus.CREATED, "BloodSample is created", sample);
    }
    @GetMapping("/sample")
    public ResponseEntity<ResponseStructure<SampleResponse>> getSample(@PathVariable int sampleId){
        SampleResponse sample = sampleService.getSample(sampleId);
        return responseBuilder.success(HttpStatus.FOUND, "BloodSample is found", sample);
    }

    public ResponseEntity<ResponseStructure<SampleResponse>> updateById(@RequestBody SampleRequest sampleRequest,@PathVariable int sampleId){
        SampleResponse sample = sampleService.updateById(sampleRequest,sampleId);
        return responseBuilder.success(HttpStatus.OK, "BloodSample is Updated", sample);
    }

}

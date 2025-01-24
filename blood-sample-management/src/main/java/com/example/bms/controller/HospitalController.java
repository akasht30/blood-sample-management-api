package com.example.bms.controller;

import com.example.bms.entity.Hospital;
import com.example.bms.requestdto.HospitalRequest;
import com.example.bms.resposedto.HospitalResponse;
import com.example.bms.service.HospitalService;
import com.example.bms.utility.ResponseStructure;
import com.example.bms.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/add-hospital")
    public ResponseEntity<ResponseStructure<HospitalResponse>> addUser(@RequestBody @Valid HospitalRequest hospitalRequest){
        HospitalResponse hospitalResponse = hospitalService.addHospital(hospitalRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "hospital is added to database", hospitalResponse);
    }

    @GetMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>>  getHospitalById(@PathVariable int hospitalId) {
        HospitalResponse hospitalResponse=hospitalService.getById(hospitalId);

        return restResponseBuilder.success(HttpStatus.FOUND, " Hospital found",hospitalResponse);

    }

    @GetMapping("/hospitals")
    public  ResponseStructure<List<HospitalResponse>> findAllHospitals(){
        List<HospitalResponse> hospitals= hospitalService.findAllHospitals();

        return new ResponseStructure<>( HttpStatus.OK.value(), "Hospitals found", hospitals);
    }


    @PutMapping("/update-hospital/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> updateHospitalById(@RequestBody HospitalRequest hospitalRequest,@PathVariable int hospitalId) {
        HospitalResponse hospitalResponse=hospitalService.updatedById(hospitalRequest,hospitalId);

        return restResponseBuilder.success(HttpStatus.OK,"Hospital is updated successfully",hospitalResponse);
    }

}


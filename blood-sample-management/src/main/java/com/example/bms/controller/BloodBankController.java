package com.example.bms.controller;

import com.example.bms.requestdto.BloodBankRequest;
import com.example.bms.requestdto.HospitalRequest;
import com.example.bms.resposedto.BloodBankResponse;
import com.example.bms.resposedto.HospitalResponse;
import com.example.bms.service.BloodBankService;
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
public class BloodBankController {

    private final BloodBankService bloodBankService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/add-bank")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> addUser(@RequestBody @Valid BloodBankRequest bloodBankRequest){
        BloodBankResponse bloodBankResponse = bloodBankService.addBank(bloodBankRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Blood bank is added to database",bloodBankResponse);
    }

    @GetMapping("/bank/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>>  getBankByID(@PathVariable int bankId) {
        BloodBankResponse bloodBankResponse =bloodBankService.getById(bankId);

        return restResponseBuilder.success(HttpStatus.FOUND, " bank found",bloodBankResponse);

    }

    @GetMapping("/banks")
    public  ResponseStructure<List<BloodBankResponse>> findAllABanks(){
        List<BloodBankResponse> bloodBanks= bloodBankService.findAllBanks();

        return new ResponseStructure<>( HttpStatus.OK.value(), "Banks found", bloodBanks);
    }

    @PutMapping("/update-bank/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateHospitalById(@RequestBody BloodBankRequest bloodBankRequest,@PathVariable int bankId) {
        BloodBankResponse bloodBankResponse=bloodBankService.updatedById(bloodBankRequest,bankId);

        return restResponseBuilder.success(HttpStatus.OK,"Bank is updated successfully",bloodBankResponse);
    }

}

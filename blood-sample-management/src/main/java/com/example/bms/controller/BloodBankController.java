package com.example.bms.controller;

import com.example.bms.requestdto.AddressRequest;
import com.example.bms.requestdto.BloodBankRequest;
import com.example.bms.requestdto.HospitalRequest;
import com.example.bms.resposedto.AddressResponse;
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
    public ResponseEntity<ResponseStructure<BloodBankResponse>> addBank(@RequestBody @Valid BloodBankRequest bloodBankRequest){
        BloodBankResponse bloodBankResponse = bloodBankService.addBank(bloodBankRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "Blood bank is added to database",bloodBankResponse);
    }

    @GetMapping("/bank/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>>  getBankByID(@PathVariable int bankId) {
        BloodBankResponse bloodBankResponse =bloodBankService.getById(bankId);

        return restResponseBuilder.success(HttpStatus.FOUND, " bank found",bloodBankResponse);

    }



    @PutMapping("/update-bank/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateBankById(@RequestBody BloodBankRequest bloodBankRequest,@PathVariable int bankId) {
        BloodBankResponse bloodBankResponse=bloodBankService.updatedById(bloodBankRequest,bankId);

        return restResponseBuilder.success(HttpStatus.OK,"Bank is updated successfully",bloodBankResponse);
    }


    @GetMapping("/blood-banks")
    public  ResponseStructure<List<BloodBankResponse>> findByAllByAddreess_CityIn(@RequestParam List<String> cities){
        List<BloodBankResponse> bloodBanks= bloodBankService.findByAddress_CityIn(cities);

        return new ResponseStructure<>( HttpStatus.OK.value(), "Banks found", bloodBanks);
    }

}

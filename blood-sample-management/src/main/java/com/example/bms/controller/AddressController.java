package com.example.bms.controller;

import com.example.bms.requestdto.AddressRequest;
import com.example.bms.resposedto.AddressResponse;
import com.example.bms.service.AddressService;
import com.example.bms.utility.ResponseStructure;
import com.example.bms.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/add-address-user/{userId}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddressToUser(@RequestBody AddressRequest addressRequest, @PathVariable int userId) {

        AddressResponse addressResponse=addressService.addAddressToUser(addressRequest,userId);

        return restResponseBuilder.success(HttpStatus.CREATED, "Address is added to User ",addressResponse );

    }

    @PostMapping("/add-address-bank/{bankId}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddressBankById(@RequestBody AddressRequest addressRequest, @PathVariable int bankId) {
        AddressResponse addressResponse=addressService.addAddressToBank(addressRequest,bankId);

        return restResponseBuilder.success(HttpStatus.CREATED,"Address added to bank",addressResponse);
    }

    @PostMapping("/add-address-hospital/{hospitalId}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddressHospitalById(@RequestBody AddressRequest addressRequest,@PathVariable int hospitalId) {

        AddressResponse addressResponse=addressService.addAddressToHospital(addressRequest,hospitalId);

        return restResponseBuilder.success(HttpStatus.CREATED,"Address added to hospital",addressResponse);

    }

}

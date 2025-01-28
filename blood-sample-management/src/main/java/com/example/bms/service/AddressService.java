package com.example.bms.service;

import com.example.bms.requestdto.AddressRequest;
import com.example.bms.resposedto.AddressResponse;

public interface AddressService {
    public  AddressResponse addAddressToUser(AddressRequest addressRequest, int userId);

    public  AddressResponse addAddressToBank(AddressRequest addressRequest, int bankId);

    public  AddressResponse addAddressToHospital(AddressRequest addressRequest, int hospitalId);
}

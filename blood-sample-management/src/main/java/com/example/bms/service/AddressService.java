package com.example.bms.service;

import com.example.bms.requestdto.AddressRequest;
import com.example.bms.resposedto.AddressResponse;

public interface AddressService {
    public  AddressResponse addAddressToUser(AddressRequest addressRequest, int userId);

    public  AddressResponse addAddressToBank(AddressRequest addressRequest, int bankId);

    public  AddressResponse addAddressToHospital(AddressRequest addressRequest, int hospitalId);

     public  AddressResponse getAddressbByUser(int userId);

    public AddressResponse getBankAddress(int bankId);

    public  AddressResponse getHospitalAddress(int hospitalId);

    public  AddressResponse updateUserById(AddressRequest addressRequest, int userId);

    public AddressResponse updateHospitalAddress(AddressRequest addressRequest, int hospitalId);

    public AddressResponse updateBankAddress(AddressRequest addressRequest, int bankId);
}

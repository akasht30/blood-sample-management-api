package com.example.bms.serviceimplementation;

import com.example.bms.entity.Address;
import com.example.bms.entity.BloodBank;
import com.example.bms.entity.BloodSample;
import com.example.bms.excepiton.NotFoundByidException;
import com.example.bms.excepiton.NotUpdatedException;
import com.example.bms.repository.AddressRepository;
import com.example.bms.repository.BloodBankRepository;
import com.example.bms.requestdto.BloodBankRequest;

import com.example.bms.resposedto.BloodBankResponse;

import com.example.bms.service.BloodBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BloodBankServiceImplementation implements BloodBankService {

    private final BloodBankRepository bloodBankRepository;
    private final AddressRepository addressRepository;

    //=------------------================-------------------
    private BloodBank mapToBank(BloodBankRequest bloodBankRequest, BloodBank bloodBank) {
        bloodBank.setBankName(bloodBankRequest.getBankName());
        bloodBank.setEmergencyUnits(bloodBankRequest.getEmergencyUnits());


        return bloodBank;
    }
    private BloodBankResponse mapToBankResponse(BloodBank bloodBank) {
        return BloodBankResponse.builder()
                .bankId(bloodBank.getBankId())
                .bankName(bloodBank.getBankName())
                .emergencyUnits(bloodBank.getEmergencyUnits())
                .build();
    }
    //===========---------------============================

    @Override
    public BloodBankResponse addBank(BloodBankRequest bloodBankRequest) {

        BloodBank bloodBank=this.mapToBank(bloodBankRequest,new BloodBank());

        bloodBank=bloodBankRepository.save(bloodBank);

        return mapToBankResponse(bloodBank);
    }

    @Override
    public BloodBankResponse getById(int bankId) {

        Optional<BloodBank> optional=bloodBankRepository.findById(bankId);

        if(optional.isEmpty())
            throw new NotFoundByidException("Bank is not found");

        BloodBank bloodBank=optional.get();

        return mapToBankResponse(bloodBank);
    }

    @Override
    public BloodBankResponse updatedById(BloodBankRequest bloodBankRequest, int bankId) {
        Optional<BloodBank> optional=bloodBankRepository.findById(bankId);

        if(optional.isEmpty())
            throw new NotUpdatedException("Failed to update");

        BloodBank bloodBank=mapToBank(bloodBankRequest,optional.get());

        bloodBankRepository.save(bloodBank);

        return mapToBankResponse(bloodBank);


    }




    @Override
    public List<BloodBankResponse> findByAddress_CityIn(List<String> cities) {

        List<BloodBank> bloodBanks=bloodBankRepository.findByAddress_CityIn(cities);

        if(bloodBanks.isEmpty())
            return List.of();

        return bloodBanks.stream()
                .map(this::mapToBankResponse)
                .collect(Collectors.toList());
    }


}

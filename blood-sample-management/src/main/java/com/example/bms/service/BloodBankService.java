package com.example.bms.service;

import com.example.bms.requestdto.BloodBankRequest;
import com.example.bms.resposedto.BloodBankResponse;
import com.example.bms.resposedto.HospitalResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface BloodBankService {


  public BloodBankResponse addBank( @Valid BloodBankRequest bloodBankRequest);

 public BloodBankResponse getById(int bankId);

  public   BloodBankResponse updatedById(BloodBankRequest bloodBankRequest, int bankId);

   public List<BloodBankResponse> findAllBanks();
}

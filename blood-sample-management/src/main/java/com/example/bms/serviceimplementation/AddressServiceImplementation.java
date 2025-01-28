package com.example.bms.serviceimplementation;

import com.example.bms.entity.Address;
import com.example.bms.entity.BloodBank;
import com.example.bms.entity.Hospital;
import com.example.bms.entity.User;
import com.example.bms.excepiton.NotFoundByidException;
import com.example.bms.repository.AddressRepository;
import com.example.bms.repository.BloodBankRepository;
import com.example.bms.repository.HospitalRepository;
import com.example.bms.repository.UserRepository;
import com.example.bms.requestdto.AddressRequest;
import com.example.bms.resposedto.AddressResponse;
import com.example.bms.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImplementation implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final BloodBankRepository bloodBankRepository;
    private final HospitalRepository hospitalRepository;


    //=====----------------------------------------------------------

    private AddressResponse mapToAddressReponse(Address address) {
        return AddressResponse.builder()
                .addressId(address.getAddressId())
                .addressLine(address.getAddressLine())
                .landMark(address.getLandMark())
                .area(address.getArea())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pinCode(address.getPinCode())
                .build();
    }

    private final Address mapToAddress(AddressRequest addressRequest,  Address address) {
         address.setAddressLine(addressRequest.getAddressLine());
        address.setLandMark(addressRequest.getLandMark());
        address.setArea(addressRequest.getArea());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setCountry(addressRequest.getCountry());
        address.setPinCode(addressRequest.getPinCode());

        return address;

    }

    //=-------------------===========------------============-------------

    @Override
    public AddressResponse addAddressToUser(AddressRequest addressRequest, int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundByidException("User is not found");
        }

        User user = optionalUser.get();

        // Create a new Address from the provided request DTO
        Address address = mapToAddress(addressRequest,new Address());

        // Save the Address in the database
        addressRepository.save(address);

        // Associate the new Address with the User
        user.setAddress(address);

        // Save the updated User with the Address
        userRepository.save(user);

        // Return the AddressResponse DTO
        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse addAddressToBank(AddressRequest addressRequest, int bankId) {
        Optional<BloodBank> optional=bloodBankRepository.findById(bankId);

        if(optional.isEmpty())
            throw  new NotFoundByidException("Failed to add address");

        BloodBank bloodBank=optional.get();

        Address address = mapToAddress(addressRequest,new Address());

        addressRepository.save(address);

        bloodBank.setAddress(address);

        bloodBankRepository.save(bloodBank);


        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse addAddressToHospital(AddressRequest addressRequest, int hospitalId) {
        Optional<Hospital> optional=hospitalRepository.findById(hospitalId);

        Hospital hospital=optional.get();

        Address address=mapToAddress(addressRequest,new Address());

        addressRepository.save(address);

        hospital.setAddress(address);

        hospitalRepository.save(hospital);


        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse getAddressbByUser(int userId) {

        Optional<User>  optional=userRepository.findById(userId);

        if(optional.isEmpty())
            throw new NotFoundByidException("User is not found");

        User user=optional.get();



        Optional<Address> optional1=addressRepository.findById(user.getAddress().getAddressId());

        if(optional1.isEmpty())
            throw new NotFoundByidException("Address id not found");

        Address address=optional1.get();


        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse getBankAddress(int bankId) {

        Optional<BloodBank> optional=bloodBankRepository.findById(bankId);

        if(optional.isEmpty())
            throw new NotFoundByidException("Blood bank is not found");

        BloodBank bloodBank=optional.get();

        Optional<Address> optional1=addressRepository.findById(bloodBank.getAddress().getAddressId());

        if(optional1.isEmpty())
            throw new NotFoundByidException("Address not found");

        Address address=optional1.get();

        return mapToAddressReponse(address);

    }

    @Override
    public AddressResponse getHospitalAddress(int hospitalId) {

        Optional<Hospital> optional=hospitalRepository.findById(hospitalId);

        if(optional.isEmpty())
            throw new NotFoundByidException("User is not found");

        Hospital hospital=optional.get();

        Optional<Address> optional1=addressRepository.findById(hospital.getAddress().getAddressId());

        if(optional1.isEmpty())
            throw new NotFoundByidException("Address is not found");

        Address address=optional1.get();

        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse updateUserById(AddressRequest addressRequest, int userId) {

        Optional<User> optional=userRepository.findById(userId);
        if(optional.isEmpty())
            throw new NotFoundByidException("User is not found");

        User user=optional.get();

        Optional<Address> optional1=addressRepository.findById(user.getAddress().getAddressId());
        if(optional1.isEmpty())
            throw new NotFoundByidException("Address is not founnd");

        Address address=mapToAddress(addressRequest,optional1.get());

        addressRepository.save(address);

        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse updateHospitalAddress(AddressRequest addressRequest, int hospitalId) {

        Optional<Hospital> optional=hospitalRepository.findById(hospitalId);
        if (optional.isEmpty())
            throw new NotFoundByidException("Hospital is not found");

        Hospital hospital=optional.get();

        Optional<Address> optional1=addressRepository.findById(hospital.getAddress().getAddressId());
        if(optional1.isEmpty())
            throw new NotFoundByidException("Address is not  found");

        Address address=mapToAddress(addressRequest,optional1.get());
        addressRepository.save(address);

        return mapToAddressReponse(address);
    }

    @Override
    public AddressResponse updateBankAddress(AddressRequest addressRequest, int bankId) {

        Optional<BloodBank> optional=bloodBankRepository.findById(bankId);
        if(optional.isEmpty()) {
            throw new NotFoundByidException("Bank is not there!");
        }
         BloodBank bloodBank=optional.get();

        Optional<Address> optional1=addressRepository.findById(bloodBank.getAddress().getAddressId());

        Address address=mapToAddress(addressRequest,optional1.get());
        addressRepository.save(address);

        return mapToAddressReponse(address);
    }
}



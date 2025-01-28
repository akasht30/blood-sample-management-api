package com.example.bms.serviceimplementation;

import com.example.bms.entity.Address;
import com.example.bms.entity.Admin;
import com.example.bms.entity.User;
import com.example.bms.entity.enums.UserRole;
import com.example.bms.excepiton.NotFoundByidException;
import com.example.bms.excepiton.NotUpdatedException;
import com.example.bms.repository.AddressRepository;
import com.example.bms.repository.AdminRepository;
import com.example.bms.repository.UserRepository;
import com.example.bms.requestdto.AddressRequest;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.AddressResponse;
import com.example.bms.resposedto.AdminResponse;
import com.example.bms.resposedto.UserResponse;
import com.example.bms.security.AuothUtil;
import com.example.bms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {


    private final AuothUtil auothUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final AddressRepository addressRepository;


/// /---============----------------------------====================
    private  UserResponse mapToUserResponse(User exUser) {
        return UserResponse.builder()
                .userId(exUser.getUserId())
                .userName(exUser.getUserName())
                .age(exUser.getAge())
                .lastDonatedAt(exUser.getLastDonatedAt())
                .availableCity(exUser.getAvailableCity())
                .verfied(exUser.isVerfied())
                .bloodGroup(exUser.getBloodGroup())
                .gender(exUser.getGender())
                .role(exUser.getRole())
                .build();
    }



    private  User mapToUser(UserRequest userRequest,User exUser) {
        exUser.setAge(userRequest.getAge());
        exUser.setEmail(userRequest.getEmail());
        exUser.setGender(userRequest.getGender());
        exUser.setUserName(userRequest.getUserName());
        exUser.setPhoneNumber(userRequest.getPhoneNumber());
        exUser.setAvailableCity(userRequest.getAvailableCity());
        exUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        exUser.setBloodGroup(userRequest.getBloodGroup());
        exUser.setLastDonatedAt(userRequest.getLastDonatedAt());

        return exUser;
    }

    //==============---------------------------------------------==


    @Override
    public UserResponse addUser(UserRequest userRequest) {


        User user = this.mapToUser(userRequest,new User());

        user.setRole(UserRole.USER);


        user = userRepository.save(user);


        return mapToUserResponse(user);


    }




    @Override
    public UserResponse findUserById() {

        User exUser=auothUtil.getCurrentUser();


        return mapToUserResponse(exUser);
    }


    @Override
    public UserResponse updateUserById(UserRequest userRequest) {
        User exUser=auothUtil.getCurrentUser();
        this.mapToUser(userRequest,exUser);

        exUser=userRepository.save(exUser);

        return mapToUserResponse(exUser);

    }

    @Override
    public UserResponse promoteUser(int userId) {

        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty())
            throw new NotUpdatedException("Failed to update");

        User user=optional.get();

        user.setRole(UserRole.GUEST_ADMIN);

        userRepository.save(user);

        Admin  admin=Admin.builder().user(user)
                        .build();

        adminRepository.save(admin);

        return mapToUserResponse(user);
    }

    @Override
    public AdminResponse addAdmin(UserRequest userRequest) {

        User user=this.mapToUser(userRequest,new User());

        user.setRole(UserRole.GUEST_ADMIN);

        userRepository.save(user);

        Admin  admin=Admin.builder().user(user)
                .build();




        adminRepository.save(admin);


        return AdminResponse.builder()
                .adminId(admin.getAdminID())
                        .user(user).build();

    }


    @Override
    public UserResponse verifyUser(int userId, boolean isVerified) {

        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty())
            throw  new NotFoundByidException("user is not found");

        User user=optional.get();

        user.setVerfied(isVerified);

        user=userRepository.save(user);

        return mapToUserResponse(user);


    }

    @Override
    public UserResponse updateLastDonated(int userId, LocalDate lastDonatedAt) {

        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty())
            throw  new NotFoundByidException("user is not found");

        User user=optional.get();

        user.setLastDonatedAt(lastDonatedAt);

        user=userRepository.save(user);


        return mapToUserResponse(user);
    }


}



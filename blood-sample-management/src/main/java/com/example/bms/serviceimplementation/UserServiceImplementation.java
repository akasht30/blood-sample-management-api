package com.example.bms.serviceimplementation;

import com.example.bms.entity.User;
import com.example.bms.excepiton.UserNotUpdatedException;
import com.example.bms.repository.UserRepository;
import com.example.bms.requestdto.UserRequest;
import com.example.bms.resposedto.UserResponse;
import com.example.bms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {


    private final UserRepository userRepository;
/// /---============----------------------------====================
    private  UserResponse mapToUserResponse(User exUser) {
        return UserResponse.builder()
                .userId(exUser.getUserId())
                .userName(exUser.getUserName())
                .age(exUser.getAge())
                .lastDonatedAt(exUser.getLastDonatedAt())
                .availableCity(exUser.getAvailableCity())
                .verfied(exUser.isVerfied())
                .registeredDate(exUser.getRegisteredDate())
                .lastUpdatedTime(exUser.getLastUpdatedTime())
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
        exUser.setPassword(userRequest.getPassword());
        exUser.setBloodGroup(userRequest.getBloodGroup());

        return exUser;
    }

    //==============---------------------------------------------==


    @Override
    public UserResponse addUser(UserRequest userRequest) {


        User user = this.mapToUser(userRequest,new User());

        user = userRepository.save(user);

        return mapToUserResponse(user);


    }




    @Override
    public UserResponse findUserById(int userId) {
        Optional<User> optional = userRepository.findById(userId);

        if (optional.isEmpty())
            throw new UserNotUpdatedException("Failed to find user");


        User user = optional.get();

        return mapToUserResponse(user);
    }


    @Override
    public UserResponse updateUserById(UserRequest userRequest, int userId) {
        Optional<User> optional = userRepository.findById(userId);


        if (optional.isEmpty())
            throw new UserNotUpdatedException("Failed To Update");


        User user=this.mapToUser(userRequest,optional.get());

        userRepository.save(user);

//        User exUser = optional.get();
//
//        exUser.setAge(userRequest.getAge());
//        exUser.setEmail(userRequest.getEmail());
//        exUser.setGender(userRequest.getGender());
//        exUser.setUserName(userRequest.getUserName());
//        exUser.setPhoneNumber(userRequest.getPhoneNumber());
//        exUser.setAvailableCity(userRequest.getAvailableCity());
//        exUser.setPassword(userRequest.getPassword());
//        exUser.setBloodGroup(userRequest.getBloodGroup());



        return mapToUserResponse(user);

    }


}



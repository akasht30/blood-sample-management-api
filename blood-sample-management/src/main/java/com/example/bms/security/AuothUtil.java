package com.example.bms.security;

import com.example.bms.entity.User;
import com.example.bms.repository.UserRepository;
import lombok.Builder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Builder
public class AuothUtil {

    private final UserRepository userRepository;

    public String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getCurrentUser() {
        Optional<User> optional= userRepository.findByEmail(this.getCurrentUserName());

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("Failed to authenticate");
        }

        User user=optional.get();

        return user;

        // return userRepository.findByEmail(this.getCurrentUserName())
        //          .orElserThrow(()-> new UsernameNotFoundException("Failed to authenticate"));
        //    using lambda function
    }

}

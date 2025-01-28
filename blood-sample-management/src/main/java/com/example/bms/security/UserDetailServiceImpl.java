package com.example.bms.security;

import com.example.bms.entity.User;
import com.example.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optional=userRepository.findByEmail(username);

        if(optional.isEmpty())
            throw new UsernameNotFoundException("Failed to authenticate user");

        User user=optional.get();


        String role=user.getRole().name();

        return  org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail()).password(user.getPassword()).
                authorities(role).build();


    }
}

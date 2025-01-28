package com.example.bms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{

       return   httpSecurity.csrf(csrf -> csrf.disable())
                 .authorizeHttpRequests(authorize ->
                         authorize.requestMatchers("/register","/register-admin","/get-bankaddress/{bankId}").
                                 permitAll().
                                 requestMatchers("/promote/{userId}").//authorizing..
                                 hasAuthority("OWNER_ADMIN").  //Change authority to owner. for actual code owner to have authority
                                 anyRequest().
                                 authenticated()) .
               formLogin(Customizer.withDefaults()).build();
    }

}

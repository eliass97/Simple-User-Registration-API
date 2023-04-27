package com.example.surapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.surapi.service.SystemUserService;

@Configuration
public class AuthenticationProviderConfig {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    protected DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(systemUserService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}

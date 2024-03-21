package com.fatimetou.patient.services;

import com.fatimetou.patient.dtos.LoginRequest;
import com.fatimetou.patient.repositories.UserRepository;
import com.fatimetou.patient.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest authRequestDto) {
        String jwt = "bad request";
        // Authenticate the user using Spring Security's authentication manager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));

        // If authentication is successful, generate and set the JWT token
        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            jwt = jwtService.generateToken(userDetails);
        }
        return jwt;
    }
}

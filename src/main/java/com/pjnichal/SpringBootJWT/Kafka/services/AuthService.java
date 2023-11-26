package com.pjnichal.SpringBootJWT.Kafka.services;

import com.pjnichal.SpringBootJWT.Kafka.entity.AppRole;
import com.pjnichal.SpringBootJWT.Kafka.entity.AppUser;
import com.pjnichal.SpringBootJWT.Kafka.repositories.AppUserRepo;
import com.pjnichal.SpringBootJWT.Kafka.requestresponse.request.LoginRequest;
import com.pjnichal.SpringBootJWT.Kafka.requestresponse.request.RegisterRequest;
import com.pjnichal.SpringBootJWT.Kafka.requestresponse.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();
        appUser.setName(registerRequest.getName());
        appUser.setEmail(registerRequest.getEmail());
        appUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        appUser.setRole(AppRole.USER);
        appUserRepo.save(appUser);
        String token = jwtService.GenerateToken(appUser.getEmail());
        return AuthResponse.builder().accessToken(token).build();
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
    AppUser appUser = appUserRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
    String token = jwtService.GenerateToken(appUser.getEmail());
    return  AuthResponse.builder().accessToken(token).build();
    }
}


package com.pjnichal.SpringBootJWT.Kafka.services;

import com.pjnichal.SpringBootJWT.Kafka.entity.AppRole;
import com.pjnichal.SpringBootJWT.Kafka.entity.AppUser;
import com.pjnichal.SpringBootJWT.Kafka.exceptions.UserAlreadyExists;
import com.pjnichal.SpringBootJWT.Kafka.exceptions.UserNotFound;
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
        if(appUserRepo.findByEmail(registerRequest.getEmail()).isPresent()){
            System.out.println("EXCEPTION THROWN");
            throw new UserAlreadyExists("USER ALREADY EXISTS");
        }
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
        AppUser appUser = appUserRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()->new UserNotFound("USER NOT FOUND"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

    String token = jwtService.GenerateToken(appUser.getEmail());
    return  AuthResponse.builder().accessToken(token).build();
    }
}


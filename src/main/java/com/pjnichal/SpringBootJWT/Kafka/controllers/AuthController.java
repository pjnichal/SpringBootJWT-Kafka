package com.pjnichal.SpringBootJWT.Kafka.controllers;

import com.pjnichal.SpringBootJWT.Kafka.requestresponse.request.RegisterRequest;
import com.pjnichal.SpringBootJWT.Kafka.requestresponse.response.AuthResponse;
import com.pjnichal.SpringBootJWT.Kafka.requestresponse.request.LoginRequest;
import com.pjnichal.SpringBootJWT.Kafka.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
return ResponseEntity.ok().body(authService.register(registerRequest));
    }
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> register(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }
}

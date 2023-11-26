package com.pjnichal.SpringBootJWT.Kafka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){

    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){

    }
}

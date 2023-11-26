package com.pjnichal.SpringBootJWT.Kafka.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {
    @GetMapping("/hello")
    public String pingController(){
        return "HelloOpenUser";
    }
    @GetMapping("protected/hello")
    public String pingControllerAuth(){
        return "HelloProtectedUsers";
    }
    @GetMapping("protected/admin/hello")
    public String adminControllerAuth(){
        return  "HelloProtectedAdmin";
    }
}

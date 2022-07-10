package com.example.tracker.controllers;

import com.example.tracker.beans.LoginRequest;

import com.example.tracker.services.EmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class EmpLoginController {

    @Autowired
    private EmpLoginService empLoginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception{
        System.out.println(loginRequest);
        return ResponseEntity.ok(empLoginService.SignIn_Service(loginRequest));
    }


//    @GetMapping("/signin")
//    public ResponseEntity<?> SignIn(@RequestBody LoginRequest loginRequest) throws Exception{
//        return ResponseEntity.ok(loginService.SignIn_Service(loginRequest));
//    }

//    @GetMapping("/login")
//    public String login(){
//        return "hello";
//    }
//    public LoginRequest login(@RequestBody LoginRequest loginRequest) throws Exception{
//        return empLoginService.SignIn_Service(loginRequest);
//    }


}

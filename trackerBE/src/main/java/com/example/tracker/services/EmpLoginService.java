package com.example.tracker.services;

import com.example.tracker.beans.LoginRequest;
import com.example.tracker.beans.employeeDetails;
import com.example.tracker.repositories.employeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmpLoginService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private employeeDetailsRepository edR;

    public LoginRequest SignIn_Service(LoginRequest loginRequest){
        employeeDetails ed = edR.findByEmail(loginRequest.getEmail());
        System.out.println(ed);
        if(passwordEncoder.matches(loginRequest.getPassword(), ed.getPassword()) && ed.getRole().equals(loginRequest.getRole()) && ed.isActive()){
            return loginRequest;
        }
        return loginRequest;
    }
}

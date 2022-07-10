package com.example.tracker.controllers;

import com.example.tracker.beans.EmailDetails;
import com.example.tracker.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    //api for sending email
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailDetails emailDetails){
        System.out.println(emailDetails);
        boolean result = this.emailService.sendEmail_Service(emailDetails.getSubject(),emailDetails.getMessage(),emailDetails.getTo());
        if(result)
            return ResponseEntity.ok("Email Sent Successfully...");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent..");
    }

}

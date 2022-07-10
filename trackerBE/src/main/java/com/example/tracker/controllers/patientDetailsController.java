package com.example.tracker.controllers;

import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import com.example.tracker.services.patientDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")

public class patientDetailsController {
    @Autowired
    private patientDetailsService pdS;

        @GetMapping("/getPatient_sampleID/{sample_id}")
    public patientDetails getPatient_sampleID(@PathVariable String sample_id){
        return pdS.getPatient_sampleIDRest(sample_id);
    }


    @GetMapping("/getAll")
    public List<patientDetails> getPatientDetails(){
        return pdS.getPatientDetailsRest();
    }


    @GetMapping("/getOne/{id}")
    public patientDetails getPatientDetails(@PathVariable String id) {
        return pdS.getPatientDetailsRest(id);
    }

    @GetMapping("/getRequests")
    public List<patientDetails> getRequests(){
        return pdS.getRequestsRest();
    }
    @GetMapping("/getAcceptedRequests")
    public List<patientDetails> getAcceptedRequests(){
        return pdS.getAcceptedRequestsRest();
    }


    @PostMapping("/addPatient")
    public patientDetails addPatientDetails(@Valid @RequestBody patientDetails pd) {
        return pdS.addPatientDetailsRest(pd);
    }

    @PutMapping("/update")
    public patientDetails updatePatientDetails(@RequestBody patientDetails pd){
        return pdS.updatePatientDetailsRest(pd);
    }

    @PutMapping("/updateAccept")
    public patientDetails updateAccept(@RequestBody patientDetails pd){
        return pdS.updateAcceptRest(pd);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePatientDetails(@PathVariable String id){
        try{
            this.pdS.deletePatientDetailsRest(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPendingPatients/{stationNo}")
    public List<patientDetails> getPendingPatients(@PathVariable int stationNo){
            return pdS.getPndngPtnt_Service(stationNo);
    }

    @GetMapping("/date/{startDate}/{endDate}")
    public List<patientDetails> searchByDate(@PathVariable String startDate, @PathVariable String endDate) throws ParseException, ParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate dateTime1 = LocalDate.parse(startDate, formatter);
//        LocalDate dateTime2 = LocalDate.parse(endDate, formatter);
        Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

        System.out.println(d1);
        return pdS.getByDate(d1,d2);
        //return null;
    }
//    @GetMapping("/getPatientDetailByUHID")
//    public String getPatientDetailByUHID(@RequestParam String uhid)throws JsonProcessingException {
//        return pdS.getPatientDetailByUHIDRest(uhid);
//    }
}

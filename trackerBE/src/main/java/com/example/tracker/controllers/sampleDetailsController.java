package com.example.tracker.controllers;
import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import com.example.tracker.services.patientDetailsService;
import com.example.tracker.services.sampleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class sampleDetailsController
{
    @Autowired
    private sampleDetailsService sdS;



    @GetMapping("/getAllSamples")
    public List<sampleDetails> getSampleDetails() {
        return sdS.getSampleDetailsRest();
    }


    @GetMapping("/getOneSample/{sample_id}")
    public sampleDetails getSampleDetails(@PathVariable String sample_id) {
        return sdS.getSampleDetailsRest(sample_id);
    }

    //get SampleDetails of grossingStation
    @GetMapping("/getPendingSamples/{stationNo}")
    public List<sampleDetails> getPendingSamples(@PathVariable int stationNo){

        return sdS.getPendingSamplesRest(stationNo);
    }
//    @GetMapping("/getRequests")
//    public List<sampleDetails> getRequests(){
//        return sdS.getRequestsRest();
//    }

    @GetMapping("/getSampleExist/{sample_id}")
    public boolean getSampleExist(@PathVariable String sample_id) {
        if(sdS.getSampleExistRest(sample_id)){
            return true;
        }
        return false;

    }

    @GetMapping("/getSampleDetailsOfPatient/{patient_id}")
    public List<sampleDetails> getSampleDetailsOfPatient(@PathVariable String patient_id){
        return sdS.getSampleDetailsOfPatient_Service(patient_id);
    }



    @PostMapping("/insertSample")
    public sampleDetails addSampleDetails(@Valid @RequestBody sampleDetails sd) {
        System.out.println(sd);
        return sdS.addSampleDetailsRest(sd);
    }

    @PostMapping("/insert_NSamples")
    public List<sampleDetails> add_N_SampleDetails(@RequestBody List<sampleDetails> l_sd){

        return sdS.add_N_SampleDetailsRest(l_sd);
    }
    @PutMapping("/updateSample")
    public sampleDetails updateSampleDetails(@RequestBody sampleDetails sd){
        return sdS.updateSampleDetailsRest(sd);
    }

    @PutMapping("/setLastUpdated")
    public sampleDetails setLastUpdated(@RequestBody sampleDetails sd){
        return sdS.setLastUpdatedRest(sd);
    }

    @DeleteMapping("/deleteSample/{sample_id}")
    public ResponseEntity<HttpStatus> deleteSampleDetails(@PathVariable String sample_id){
        try{
            this.sdS.deleteSampleDetailsRest(sample_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

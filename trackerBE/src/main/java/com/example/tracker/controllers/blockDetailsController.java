package com.example.tracker.controllers;

import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import com.example.tracker.services.blockDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/block")
public class blockDetailsController {
    @Autowired
    private blockDetailsService bdS;

    @GetMapping("/getPendingBlocks/{stationNo}")
    public List<blockDetails> getPendingBlocks(@PathVariable int stationNo){

        return bdS.getPendingBlocksRest(stationNo);
    }

    @GetMapping("/getOneBlock/{block_id}")
    public blockDetails getBlockDetailsByID(@PathVariable String block_id) {
        return bdS.getBlockDetailsByIDRest(block_id);
    }

    @GetMapping("/getAllBlocks")
    public List<blockDetails> getBlockDetails() {
        return bdS.getBlockDetailsRest();
    }

    @PostMapping("/insertBlock")
    public blockDetails addBlockDetails(@Valid @RequestBody blockDetails bd) {
        return bdS.addBlockDetailsRest(bd);
    }

    @PostMapping("/insertAllBlocks")
    public List<blockDetails> addAllBlockDetails(@Valid @RequestBody List<blockDetails> bd){
        return bdS.addAllBlockDetailsRest(bd);
    }
    @PutMapping("/updateRemarks")
    public blockDetails updateRemarks(@RequestBody blockDetails bd){
        return bdS.updateRemarksRest(bd);
    }

    @GetMapping("/getBlkDetailsOfPatient/{patient_id}")
    public List<blockDetails> getBlkDetailsOfPatient(@PathVariable String patient_id){
        return bdS.getBlkDetailsOfPatient_Service(patient_id);
    }
    @GetMapping("/getBlkDetailsOfSample/{sample_id}")
    public List<blockDetails> getBlkDetailsOfSample(@PathVariable String sample_id){
        return bdS.getBlkDetailsOfSample_Service(sample_id);
    }
    @PutMapping("/updateBlock")
    public blockDetails updateBlockDetails(@RequestBody blockDetails bd){
        return bdS.updateBlockDetailsRest(bd);
    }

}

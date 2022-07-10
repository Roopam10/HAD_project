package com.example.tracker.services;

import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import com.example.tracker.repositories.blockDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class blockDetailsService {
    @Autowired
    private blockDetailsRepository bdR;

    public List<blockDetails> getPendingBlocksRest(int stationNo){
        return bdR.getPendingBlocksRepo(stationNo);
    }

    public blockDetails getBlockDetailsByIDRest(String block_id){
        return bdR.getBlkByID(block_id);
    }

    public List<blockDetails> getBlockDetailsRest(){
        return bdR.findAll();
    }

    public blockDetails updateRemarksRest(blockDetails bd){
        bdR.save(bd);
        return bd;
    }

    public blockDetails addBlockDetailsRest(blockDetails bd){
        return bdR.save(bd);
    }

    public List<blockDetails> addAllBlockDetailsRest(List<blockDetails> bd){
        return bdR.saveAll(bd);
    }

    public List<blockDetails> getBlkDetailsOfPatient_Service(String patient_id){
        patient_id+=":";
        return bdR.getBlkDetailsPatient_Repo(patient_id);
    }

    public List<blockDetails> getBlkDetailsOfSample_Service(String sample_id){
        sample_id+=":";
        return bdR.getBlkDetailsSample_Repo(sample_id);
    }

    public blockDetails updateBlockDetailsRest(blockDetails bd){

        bdR.save(bd);
        return bd;
    }
}

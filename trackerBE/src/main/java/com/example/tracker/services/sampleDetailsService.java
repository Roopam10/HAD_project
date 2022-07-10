package com.example.tracker.services;

import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import com.example.tracker.repositories.patientDetailsRepository;
import com.example.tracker.repositories.sampleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class sampleDetailsService {
    @Autowired
    private sampleDetailsRepository sdR;
    //List<patientDetails> list;
    public sampleDetailsService() {

    }

//    public List<sampleDetails> getRequestsRest(){
//        return sdR.getRequestsJPA();
//    }

    public List<sampleDetails> getSampleDetailsRest(){
        return sdR.findAll();
    }

    public sampleDetails getSampleDetailsRest(String sample_id) {
        return sdR.getById2(sample_id);
    }

    public boolean getSampleExistRest(String sample_id){
        if(sdR.getById2(sample_id)==null){
            return false;
        }
        return true;
    }

    public List<sampleDetails> getPendingSamplesRest(int stationNo){
        return sdR.getPendingSamplesRepo(stationNo);
    }



    public sampleDetails addSampleDetailsRest(sampleDetails sd)
    {

        sampleDetails recordSd = sdR.getById2(sd.getSample_id());
        System.out.println(
                recordSd
        );
        if(recordSd == null){
            return sdR.save(sd);
        }
        return null;
//        return sdR.save(sd);
    }

    public List<sampleDetails> add_N_SampleDetailsRest(List<sampleDetails> l_sd){
        sampleDetails recordSd = sdR.getById2(l_sd.get(0).getSample_id());
        System.out.println(
                recordSd
        );
        if(recordSd == null){
            return sdR.saveAll(l_sd);

        }
        return null;
      //  return sdR.saveAll(l_sd);
    }

    public List<sampleDetails> getSampleDetailsOfPatient_Service(String patient_id){
        patient_id+=":";
        return sdR.getSampleDetailsPatient_Repo(patient_id);
    }

    public sampleDetails updateSampleDetailsRest(sampleDetails sd){

        sdR.save(sd);
        return sd;
    }
    public sampleDetails setLastUpdatedRest(sampleDetails sd){
        sdR.save(sd);
        return sd;
    }

    public void deleteSampleDetailsRest(String sample_id){
        //list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
        sampleDetails ent=sdR.getById2(sample_id);
        sdR.delete(ent);
    }
}

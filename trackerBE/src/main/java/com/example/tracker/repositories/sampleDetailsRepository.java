package com.example.tracker.repositories;

import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sampleDetailsRepository extends JpaRepository<sampleDetails,Integer> {
    @Query(
            value = "SELECT * FROM sample_details u WHERE u.sample_id = ?1",
            nativeQuery = true)
    sampleDetails getById2(String sample_id);


    @Query(
            value="SELECT * FROM sample_details s WHERE s.last_updated_station=?1",
            nativeQuery = true
    )
    List<sampleDetails> getPendingSamplesRepo(int stationNo);

//    @Query(
//            value = "select * from sample_details u where u.sample_id"
//    )
//    boolean existsSample(String sample_id);

//    @Query(
//            value = "SELECT * FROM sample_details u WHERE u.last_updated_station=0",
//            nativeQuery= true
//    )
//    List<sampleDetails> getRequestsJPA();
    @Query(
            value="SELECT * FROM sample_details b WHERE b.sample_id LIKE ?1%",
            nativeQuery = true
    )
    public List<sampleDetails> getSampleDetailsPatient_Repo(String id);

}
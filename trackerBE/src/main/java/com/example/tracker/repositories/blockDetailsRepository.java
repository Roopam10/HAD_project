package com.example.tracker.repositories;

import com.example.tracker.beans.blockDetails;
import com.example.tracker.beans.patientDetails;
import com.example.tracker.beans.sampleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface blockDetailsRepository extends JpaRepository<blockDetails,Integer> {

    @Query(
            value="SELECT * FROM block_details b WHERE b.block_id LIKE ?1%",
            nativeQuery = true
    )
    public List<blockDetails> getBlkDetailsPatient_Repo(String id);

    @Query(
            value="SELECT * FROM block_details b WHERE b.block_id LIKE ?1%",
            nativeQuery = true
    )
    public List<blockDetails> getBlkDetailsSample_Repo(String id);

    @Query(
            value="SELECT * FROM block_details s WHERE s.last_updated_station=?1",
            nativeQuery = true
    )
    List<blockDetails> getPendingBlocksRepo(int stationNo);

    @Query(
            value="SELECT * FROM block_details s WHERE s.block_id=?1",
            nativeQuery = true
    )
    blockDetails getBlkByID(String block_id);

}


package com.example.tracker.repositories;

import com.example.tracker.beans.employeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface employeeDetailsRepository extends JpaRepository<employeeDetails,Integer> {

    @Query(
            value="SELECT * FROM employee_details e WHERE e.email=?1",
            nativeQuery = true
    )
    public employeeDetails findByEmail(String email);

    @Query(
            value="SELECT * FROM employee_details e WHERE e.name=?1",
            nativeQuery = true
    )
    public employeeDetails findByName(String name);

    @Query(
            value ="SELECT * FROM employee_details e WHERE e.role=?1",
            nativeQuery = true
    )
   public employeeDetails findByRole(String role);
    @Query(
            value = "SELECT * FROM employee_details e WHERE e.active=true",
            nativeQuery = true
    )
    public List<employeeDetails> findAllActive();
}

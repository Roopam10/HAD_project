package com.example.tracker.controllers;


import com.example.tracker.beans.LoginRequest;
import com.example.tracker.beans.employeeDetails;
import com.example.tracker.services.EmpLoginService;
import com.example.tracker.services.employeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/emp")
public class employeeDetailsController {
    @Autowired
    private employeeDetailsService edS;

    @PostMapping("/addEmployee")
    public employeeDetails addEmployee(@RequestBody employeeDetails ed){
        return edS.addEmployee(ed);
    }
    //Add more than 1 employee
    @PostMapping("/addEmployees")
    public List<employeeDetails> addAllEmployees(@RequestBody List<employeeDetails> ed){
        return edS.addAllEmployees(ed);
    }
    //Get Employee by Id
    @GetMapping("/getEmployeeByID/{id}")
    public employeeDetails getEmployeeById(@PathVariable int id){
        return edS.getEmployeeByID(id);
    }
    // Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public  employeeDetails getEmployeeByName(@PathVariable String name) {
        return  edS.getEmployeeByName(name);
    }
    // Get employee by role
    @GetMapping("/getEmployeeByRole/{role}")
    public  employeeDetails getEmployeeByRole(@PathVariable String role) {
        return  edS.getEmployeeByRole(role);
    }
    // Update employee
    @PutMapping("/updateEmployee")
    public employeeDetails updateEmployee(@RequestBody employeeDetails ed) {
        return edS.updateEmployee(ed);
    }
    // Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeByID(@PathVariable int id) {
        return edS.deleteEmployeeByID(id);
    }
    // Get all employee
    @GetMapping("/getAll")
    public List<employeeDetails> getAllEmployee() {
        return edS.getAllEmployees();
    }

}

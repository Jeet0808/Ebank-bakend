package com.example.akhri.controller;


import com.example.akhri.model.Employee;
import com.example.akhri.model.Users;
import com.example.akhri.services.Employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/employee")
public class Employeecontroler {

    @Autowired
    Employeeservice employeeservice;

    @PostMapping
    public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
        Employee employee1 = employeeservice.addemp(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllBanks() {
        List<Employee> employees = employeeservice.getAllemployee().getBody();
        if (employees != null && !employees.isEmpty()) {
            return ResponseEntity.ok(employees);  // Return the list of banks
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No banks found
        }
    }

    @GetMapping("/get/{mobileno}")
    public ResponseEntity<Employee> getUser(@PathVariable String mobileno) {
        Employee employee = employeeservice.getemp(mobileno);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/mobile/{mobileno}")
//    public ResponseEntity<Employee> getUserbumobileno(@PathVariable String mobileno) {
//        Employee user = employeeservice.getempbymobile(mobileno);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeservice.updateemployee(employee);
    }



    @DeleteMapping("/delete/{employeeid}")
    public void deleteEmployee(@PathVariable String employeeid) {
        employeeservice.deleteemployee(employeeid);
    }

}

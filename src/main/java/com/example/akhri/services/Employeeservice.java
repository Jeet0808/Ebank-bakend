package com.example.akhri.services;

import com.example.akhri.model.Employee;
import com.example.akhri.model.Users;
import com.example.akhri.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employeeservice {

    @Autowired
    Employeerepo employeerepo;

    public Employee addemp(Employee employee) {


        String employeeid = createempid(employee.getName());
        employee.setEmployeeid(employeeid);

        return employeerepo.save(employee);
    }

    public String createempid(String name){
        int no = (int) Math.floor(Math.random()*1000);
        return "@"+ name + no ;
    }

    public Employee getemp(String mobileno) {
        for (Employee emp : employeerepo.findAll()){
            if(emp.getMobileno().equals(mobileno)){
                return emp;
            }
        }
        return null;
    }

    // Fetch all banks
    public ResponseEntity<List<Employee>> getAllemployee() {
        List<Employee> employees = employeerepo.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }

    public void updateemployee(Employee employee) {
      Employee employee1 =  employeerepo.findByemployeeid(employee.getEmployeeid());
      employeerepo.save(employee1);
    }

    public void deleteemployee(String employeeid) {
        Employee employee1 =  employeerepo.findByemployeeid(employeeid);
        employeerepo.delete(employee1);
    }


}

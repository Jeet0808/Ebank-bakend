package com.example.akhri.repository;

import com.example.akhri.model.Employee;
import com.example.akhri.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo  extends JpaRepository<Employee, Long> {


    Employee findByemployeeid(String employeeid);

    Employee findBymobileno(String mobileno);
}

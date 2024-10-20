package com.example.akhri.repository;



import com.example.akhri.model.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Regrepo extends JpaRepository<Register, Long> {
    // You can define custom query methods here if needed
    // In your Regrepo interface

        // Method to find Reistrer by mobile number
        Optional<Register> findByMobileno(String mobileno); // Assuming mobile number is a String
        boolean existsByMobileno(String mobileno);

}

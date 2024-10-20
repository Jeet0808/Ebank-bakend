package com.example.akhri.repository;



import com.example.akhri.model.Profile; // Replace with your actual entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Prorepo extends JpaRepository<Profile, Long> {
    // You can define custom query methods here if needed
    Optional<Profile> findByMobileno(String mobileno); // Assuming mobile number is a String
    boolean existsByMobileno(String mobileno); // Custom method to check existence
}

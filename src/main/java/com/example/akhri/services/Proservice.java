package com.example.akhri.services;

import com.example.akhri.model.Profile;
import com.example.akhri.repository.Prorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Proservice {

    @Autowired
    private Prorepo proRepo; // Inject your repository

    // Method to add a new profile
    public Profile save(Profile profile) {
        return proRepo.save(profile); // Save the profile
    }

    // Method to get all profiles
    public List<Profile> findAll() {
        return proRepo.findAll(); // Retrieve all profiles
    }

    // Method to get a profile by ID
    public Optional<Profile> findById(Long id) {
        return proRepo.findById(id); // Retrieve profile by ID
    }

    // Method to check if a profile exists by ID
    public boolean existsById(Long id) {
        return proRepo.existsById(id); // Check if profile exists
    }

    // Method to delete a profile by ID
    public void deleteById(Long id) {
        proRepo.deleteById(id); // Delete the profile
    }

    // Method to find a profile by mobile number
    public Optional<Profile> findBymobileno(String mobileno) {
        // Use the repository method instead of manual iteration
        return proRepo.findByMobileno(mobileno);
    }
}

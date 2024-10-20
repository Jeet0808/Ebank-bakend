package com.example.akhri.controller;

import com.example.akhri.model.Profile;
import com.example.akhri.services.Proservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/profiles") // Base URL for this controller
public class Procontroler {

    @Autowired
    private Proservice proService; // Inject your service


    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile savedProfile = proService.save(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = proService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return proService.findById(id)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/mobile/{mobileno}")
    public ResponseEntity<Profile> getProfileByMobileNo(@PathVariable String mobileno) {
        return proService.findBymobileno(mobileno)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // Method to delete a profile by ID
    @DeleteMapping("/{id}") // Handle DELETE requests to /api/profiles/{id}
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        if (proService.existsById(id)) {
            proService.deleteById(id); // Delete the profile if exists
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 status
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
    }

    // Add other methods as necessary (e.g., update profile)
}

package com.example.akhri.services;



import com.example.akhri.model.Register; // Import your model class
import com.example.akhri.repository.Regrepo; // Import your repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Regservice {

    @Autowired
    private Regrepo regrepo; // Inject your repository

    public void save(Register register) {

        System.out.println(register.toString());
        regrepo.save(register); // Save the profile

    }



    // Method to find all registrations
    public List<Register> findAll() {
        return regrepo.findAll();
    }

    // Method to find a registration by ID
    public Optional<Register> findById(Long mobileno) {
        return regrepo.findById(mobileno);
    }


        // Method to find a registration by mobile number
        public Optional<Register> save(String mobileno) {
            return regrepo.findByMobileno(mobileno); // Use the custom method
        }




    public boolean existsById(Long id) {
        return regrepo.existsById(id);
    }

    // Method to delete a registration by ID
    public void deleteById(Long id) {
        regrepo.deleteById(id);
    }

    // Service method to check if the mobile number is already registered
    public String userreg(String mobile) {
        for (Register register : regrepo.findAll()) {
            if (Objects.equals(register.getMobileno(), mobile)) {
                return null; // Mobile number is already registered
            }
        }
        return "Mobile number is available for registration";
    }


    // Service method to check if the mobile number already exists
    public Optional<Register> findByMobile(String mobile) {
        return regrepo.findByMobileno(mobile); // Assuming you have a method in the repository
    }

    // Add other business logic methods as necessary (e.g., update registration)
}

package com.example.akhri.controller;

import com.example.akhri.model.Register; // Import your model class
import com.example.akhri.services.EmailService;
import com.example.akhri.services.Regservice; // Import your service class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/registrations")
public class Regcontroler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private Regservice regservice;

    private String savedVerificationCode;
    // Check if the mobile number is already registered

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Register request) {
        String email = request.getEmail();
        String mobile = request.getMobileno();

        // Check if the mobile number is already registered

        Optional<Register>  existingUser = regservice.findByMobile(mobile);

        if (existingUser.isPresent()) {
            // Return HTTP 409 Conflict if the mobile number is already registered
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Mobile number already registered"));
        } else {
            // Call your service or logic to save new user and send verification code
             savedVerificationCode = emailService.sendVerificationEmail(email, mobile);

            // Save the user registration details here if needed


            // Return HTTP 201 Created if the registration was successful
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "Registration successful. Verification code sent.", "verificationCode", savedVerificationCode));
        }
    }






    @PostMapping("/registerbank")
        public ResponseEntity<?> bankregister(@RequestParam("email") String email,
                                              @RequestParam("name") String name,  // changed to match the JS variable "username"
                                              @RequestParam("bankName") String bankName) {
            // Call your service logic for bank verification
             savedVerificationCode = emailService.bankvarificaioncode(email, name, bankName);

            // If the mobile number or other criteria fail, return conflict
            if ("Mobile number already exists. You can log in with that number.".equals(savedVerificationCode)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", savedVerificationCode));
            } else {
                // Otherwise, return success message
                return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", savedVerificationCode));
            }
        }



    @PostMapping("/verify")
    public ResponseEntity<Void> verifyCode(@RequestParam("code") String code) {
        if (savedVerificationCode != null && savedVerificationCode.equals(code)) {
            savedVerificationCode = null; // Reset after successful verification

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/save")
    public void addRegistrationDetails(@RequestBody Register register) {
        regservice.save(register);
    }

    @GetMapping
    public ResponseEntity<List<Register>> getAllRegistrations() {
        List<Register> registrations = regservice.findAll();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/mobile/{mobileno}")
    public ResponseEntity<Register> getProfileByMobileNo(@PathVariable String mobileno) {
        return regservice.findByMobile(mobileno)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(new Register(), HttpStatus.OK));
    }
}

package com.example.akhri.controller;

import com.example.akhri.model.Bank;
import com.example.akhri.services.Bankservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow cross-origin requests from local frontend
@RestController
@RequestMapping("/api/bank")

public class Bankcontroler {

    @Autowired
    private Bankservice bankservice;

    // Create a new bank
    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankservice.createBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);  // Return the created bank details
    }



    // Get bank by bank ID
    @GetMapping("/bankid/{bankId}")
    public ResponseEntity<?> getBankByBankId(@PathVariable String bankId) {
        Bank bank = bankservice.getbankbybankId(bankId);
        if (bank != null) {
            return ResponseEntity.ok(bank);  // Return the bank details
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Bank with ID " + bankId + " not found.");
        }
    }


    @DeleteMapping("/id")
    public void deletebank(@RequestParam String bankId) {

        bankservice.deletebank(bankId);

    }



    @GetMapping("/all/{mobileno}")
    public ResponseEntity<List<Bank>> getAllBanks(@PathVariable String mobileno) {
        // Assuming getAllBanks returns a ResponseEntity, don't call getBody() here.
        ResponseEntity<List<Bank>> responseEntity = bankservice.getAllBanks(mobileno);

        List<Bank> banks = responseEntity.getBody();
        if (banks != null && !banks.isEmpty()) {
            return ResponseEntity.ok(banks);  // Return the list of banks as JSON
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No banks found, return 204
        }
    }


    // Get all banks
    @GetMapping("/all")
    public ResponseEntity<List<Bank>> getAllBank() {
        List<Bank> banks = bankservice.getAllBank().getBody();
        if (banks != null && !banks.isEmpty()) {
            return ResponseEntity.ok(banks);  // Return the list of banks
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No banks found
        }
    }


    //inside operations




}

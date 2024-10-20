package com.example.akhri.services;

import com.example.akhri.model.Bank;
import com.example.akhri.repository.Bankrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;

@Service
public class Bankservice {

    @Autowired
    private Bankrepo bankrepo;

    public Bank createBank(Bank bank) {
        // Generate a unique bank ID
        String bankId = createBankId();
        bank.setBankId(bankId); // Set the generated ID


        return bankrepo.save(bank);
    }

    public String createBankId() {
        int id = (int) Math.floor(Math.random() * 1000000);
        return id + ".JLSS"; // Example bank ID format
    }


    // Fetch all banks
    public ResponseEntity<List<Bank>> getAllBanks(String mobileno) {
        List<Bank> banks = bankrepo.findAllBymobileno(mobileno);
        return new ResponseEntity<>(banks, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }


    public Bank getbankbybankId(String bankId) {

        for (Bank bank : bankrepo.findAll()) {
            if (bank.getBankId().equals(bankId)) {
                return bank;
            }
        }

        return null;

    }

    public void deletebank(String bankId) {
        for (Bank bank : bankrepo.findAll()) {
            if (bank.getBankId().equals(bankId)) {
                bankrepo.delete(bank);
            }
        }
    }


    // Fetch all banks
    public ResponseEntity<List<Bank>> getAllBank() {
        List<Bank> banks = bankrepo.findAll();
        return new ResponseEntity<>(banks, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }
}

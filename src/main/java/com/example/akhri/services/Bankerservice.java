package com.example.akhri.services;

import com.example.akhri.model.Banker;
import com.example.akhri.repository.Bankerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bankerservice {

    @Autowired
    private Bankerrepo bankerrepo;
    @Autowired
    EmailService emailService;


    public Banker addbanker(Banker banker) {
        emailService.sendBankerWelcomeEmail(banker.getEmail(),banker.getName());
        return bankerrepo.save(banker);
    }

    public Banker findbankerbymobileno(String mobileno) {
      for (Banker banker : bankerrepo.findAll()) {
          if (banker.getMobileno().equals(mobileno)) {

              return banker;
          }
      }
      return null;
    }


    // Fetch all banks
    public ResponseEntity<List<Banker>> getbanker() {
        List<Banker> bankers = bankerrepo.findAll();
        return new ResponseEntity<>(bankers, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }


}

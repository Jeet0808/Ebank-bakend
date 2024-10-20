package com.example.akhri.controller;


import com.example.akhri.model.Banker;
import com.example.akhri.model.Users;
import com.example.akhri.services.Bankerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/banker")
public class Bankercontroler {

    @Autowired
    Bankerservice bankerservice;


    @PostMapping
    public ResponseEntity<Banker> addbanker(@RequestBody Banker banker) {
        Banker banker1 = bankerservice.addbanker(banker);
        return new ResponseEntity<>(banker1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Banker>> getbankers() {
        return bankerservice.getbanker();  // Directly return the ResponseEntity from service
    }


    @GetMapping("/mobile/{mobileno}")
    public  Banker getbanker(@PathVariable String mobileno) {
        return bankerservice.findbankerbymobileno(mobileno);
    }


}


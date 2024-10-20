package com.example.akhri.controller;

import com.example.akhri.model.Manager;
import com.example.akhri.services.Managerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/manager")
public class Managercontroller {

    @Autowired
    private Managerservice managerservice;

    // Endpoint to add a new manager
    @PostMapping
    public Manager addmanager(@RequestBody Manager manager) {
       return managerservice.addmanager(manager);
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        ResponseEntity<List<Manager>> managers = managerservice.getman();
        return ResponseEntity.ok(managers.getBody());
    }

    @PutMapping
    public ResponseEntity<Manager> updatemanager(@RequestBody Manager manager) {
        try {
            Manager updatedManager = managerservice.updatemanager(manager);
            return ResponseEntity.ok(updatedManager);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/id")
    public void deletemanager(@RequestParam String managerid) {

            managerservice.deletemanager(managerid);

    }
}

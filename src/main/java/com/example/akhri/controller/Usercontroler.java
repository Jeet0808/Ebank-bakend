package com.example.akhri.controller;

import com.example.akhri.model.Bank;
import com.example.akhri.model.Users;
import com.example.akhri.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/users")
public class Usercontroler {

    @Autowired
    private Userservice userservice;

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users createdUser = userservice.addusers(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all banks
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllBanks() {
        List<Users> users = userservice.getAllusers().getBody();
        if (users != null && !users.isEmpty()) {
            return ResponseEntity.ok(users);  // Return the list of banks
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No banks found
        }
    }
    @GetMapping("/get/{mobileno}")
    public ResponseEntity<Users> getUser(@PathVariable String mobileno) {
        Users user = userservice.getuser(mobileno);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/get/{usernamae}/password/{password}")
    public ResponseEntity<Users> getUserbyusername(@PathVariable String usernamae , @PathVariable String password) {
        Users user = userservice.getuserbyusername(usernamae,password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/mobile/{mobileno}")
    public ResponseEntity<Users> getUserbymobileno(@PathVariable String mobileno) {
        Users user = userservice.getuserbymobile(mobileno);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put")
    public ResponseEntity<Void> updateUser(@RequestBody Users user) {
        try {
            userservice.updateuser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // Log the error (you can use a logging framework)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            userservice.deleteuser(username,password);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.akhri.services;

import com.example.akhri.model.Bank;
import com.example.akhri.model.Users;
import com.example.akhri.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.CacheRequest;
import java.util.List;

@Service
public class Userservice {

    @Autowired
    private Userrepo userrepo;

    @Autowired
    EmailService emailService;


    public Users addusers(Users user) {
        String username = createUsername(user.getName());
        user.setUsername(username);
        emailService.sendCreatingNewAccEmail(user.getEmail(), user.getName());
        return userrepo.save(user);
    }

    public String createUsername(String name) {
        int id = (int) Math.floor(Math.random() * 1000);
        return "@" + name + id; // Example username format
    }

    public Users getuser(String mobileno) {
        for (Users users : userrepo.findAll()){
            if(users.getMobileno().equals(mobileno)){
                return users;
            }
        }
     return null;
    }

    public Users updateuser(Users user) {
      for (Users users : userrepo.findAll()){
          if(users.getMobileno().equals(user.getMobileno())){
              users.setMobileno(user.getMobileno());
              users.setAccountPassword(user.getAccountPassword());
              return userrepo.save(user);
          }
      }
      return null;

    }

    public void deleteuser(String username,String password) {
        Users user = getusertodel(username,password);
        if (user != null) {
            emailService.senddeletionEmail(user.getEmail(),user.getEmail());
            userrepo.delete(user);
        }

        // Optionally handle the case where the user was not found
    }

    private Users getusertodel(String username, String password) {
        for (Users users : userrepo.findAll()){
            if(users.getUsername().equals(username)&&users.getAccountPassword().equals(password)){
                return users;
            }
        }
        return null;
    }

    // Fetch all banks
    public ResponseEntity<List<Users>> getAllusers() {
        List<Users> users = userrepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }

    public Users getuserbymobile(String mobileno) {
        return userrepo.findBymobileno(mobileno); // Assuming you have a method to find by username
    }

    public Users getuserbyusername(String usernamae , String password) {

            for (Users users : userrepo.findAll()){
                if(users.getUsername().equals(usernamae)&&users.getAccountPassword().equals(password)){
                    return users;
                }
            }
            return null;

    }


}

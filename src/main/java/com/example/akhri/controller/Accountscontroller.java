package com.example.akhri.controller;

import com.example.akhri.model.Accounts;
import com.example.akhri.services.Accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/account")
public class Accountscontroller {


  @Autowired
  private Accountservice accountservice;


  @PostMapping("/save")
  public ResponseEntity<?> addAccount(@RequestBody Accounts account) {
    try {
      Accounts accounts = accountservice.addaccount(account);
      return ResponseEntity.ok(accounts);
    } catch (IllegalArgumentException e) {
      // Return error message as JSON
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("error", e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    } catch (Exception e) {
      // Return generic error message as JSON
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("error", "An error occurred while creating the account.");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

  // Get all banks
  @GetMapping("/all/{mobileno}")
  public ResponseEntity<List<Accounts>> getAllBanks(@PathVariable String mobileno) {
    List<Accounts> accounts = accountservice.getAllBanks(mobileno).getBody();
    if (accounts != null && !accounts.isEmpty()) {
      return ResponseEntity.ok(accounts);  // Return the list of banks
    } else {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No banks found
    }
  }


    @GetMapping("/all")
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        List<Accounts> accounts = accountservice.getallaccounts();
        return ResponseEntity.ok(accounts);

    }


    @GetMapping("get/{accountno}")
    public ResponseEntity<Accounts> getaccountbyaccounno(@PathVariable long accountno) {
      Accounts accounts =  accountservice.getaccountbyaccountno(accountno);
        return ResponseEntity.ok(accounts);

    }


    @DeleteMapping("delete/{accountno}")
    public void deleteaccount(@PathVariable long accountno) {
      accountservice.deleteacc(accountno);

    }

  @PutMapping("/put")
  public ResponseEntity<String> updateAccountmoney(
          @RequestParam("type") String type,
          @RequestParam("amount") double amount,
          @RequestParam("accountno") long accountno,
          @RequestParam("password") String password) {

    String data = accountservice.updateaccountmoney(type, amount, accountno, password);
    if (data != null && !data.isEmpty()) {
      return ResponseEntity.ok(data);  // Return the updated balance or confirmation message
    } else {
      // Return a more descriptive message for failure
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operation failed or no valid data received.");
    }
  }



}

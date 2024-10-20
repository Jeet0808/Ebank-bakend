package com.example.akhri.services;

import com.example.akhri.model.Accounts;
import com.example.akhri.model.Bank;
import com.example.akhri.repository.Accountrepo;
import com.example.akhri.repository.Bankrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Accountservice {

    @Autowired
    Accountrepo accountrepo;

    @Autowired
    private Bankrepo bankrepo;

    @Autowired
    EmailService emailService;
    public Accounts addaccount(Accounts account) {
        // Generate a new account number
        long accountno = createaccno();
        account.setAccountno(accountno); // Set the generated account number

        // Iterate through all banks and check if the bank ID matches the account's bank ID
        for (Bank bank : bankrepo.findAll()) {
            if (Objects.equals(bank.getBankId(), account.getBankId())) {
                // Set the bank ID and bank name for the account
                account.setBankId(bank.getBankId()); // Set the correct bank ID
                account.setBankName(bank.getBankName()); // Set the correct bank name

                // Increment the total number of users for this bank
                long totalusers = bank.getTotalusers();
                totalusers++;
                bank.setTotalusers(totalusers); // Update the total users for the bank

                // Save the updated bank information
                bankrepo.save(bank);

                // Send a confirmation email after the bank details are set
                emailService.sendBankAccCreatingEmail(
                        account.getEmail(),    // Account email
                        account.getBankName(), // Bank name
                        account.getName()      // User name
                );

                // Save the account with all the correct details
                return accountrepo.save(account);
            }
        }

        // If the bank ID was not found, return null or throw an exception (optional)
        throw new IllegalArgumentException("Bank with ID " + account.getBankId() + " not found.");
    }


    // Fetch all banks
    public ResponseEntity<List<Accounts>> getAllBanks(String mobileno) {
        List<Accounts> accounts = accountrepo.findAllBymobileno(mobileno);
        return new ResponseEntity<>(accounts, HttpStatus.OK); // Return the list of banks wrapped in ResponseEntity
    }


    private long createaccno() {
        long accountno = (long) Math.floor(Math.random() * 1000000);
        return accountno;
    }

    public List<Accounts> getallaccounts() {
        return accountrepo.findAll();
    }

    public Accounts getaccountbyaccountno(long accountno) {
        return accountrepo.findAccountsByAccountno(accountno);
    }

    public void deleteacc(long accountno) {
        Accounts accounts = getaccountbyaccountno(accountno);

        for (Bank bank : bankrepo.findAll()) {
            if (Objects.equals(bank.getBankId(), accounts.getBankId())) {
                long totalusers = bank.getTotalusers();
                totalusers--;
                bank.setTotalusers(totalusers);
                bankrepo.save(bank);
            }
        }

        accountrepo.delete(accounts);
    }

    public String updateaccountmoney(String type, double amount, long accountno, String password) {
        Accounts accounts = findacc(password,accountno);

        // Ensure account is found and amount is valid
        if (accounts != null && amount > 0) {
            double balance = accounts.getBalance(); // Get the current balance

            if (type.equals("credit")) { // Use .equals for string comparison
                balance += amount; // Add amount to balance
                accounts.setBalance(balance); // Update the balance in the Accounts object
                accountrepo.save(accounts); // Save the updated account
                return String.valueOf(amount); // Return the new balance
            } else if (type.equals("debit")) {
                if (balance >= amount) { // Check if balance is sufficient
                    balance -= amount; // Subtract amount from balance
                    accounts.setBalance(balance); // Update the balance in the Accounts object
                    accountrepo.save(accounts); // Save the updated account
                    return String.valueOf(amount); // Return the new balance
                } else {
                    return "Insufficient balance"; // Handle insufficient balance case
                }
            }
        }
        return null; // Return null if account not found or amount is invalid
    }

    private Accounts findacc(String password,long accountno) {
        for (Accounts accounts : accountrepo.findAll()) {
            if (Objects.equals(accounts.getPassword(), password) && Objects.equals(accounts.getAccountno(),accountno)) {
                return accounts; // Return the account if the password matches
            }
        }
        return null; // Return null if no matching account is found
    }

}

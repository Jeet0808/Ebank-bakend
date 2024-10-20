package com.example.akhri.services;

import com.example.akhri.model.Bank;
import com.example.akhri.model.Manager;
import com.example.akhri.repository.Bankrepo;
import com.example.akhri.repository.Managerrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Managerservice {

    @Autowired
    private Managerrepo managerrepo;

    @Autowired
    private Bankrepo bankrepo;

    // Method to add a manager if the bank exists
    @Transactional
    public Manager addmanager(Manager manager) {
        // Check if the bank ID is not null or empty
        for (Bank bank : bankrepo.findAll()) {
            if (Objects.equals(bank.getBankId(), manager.getBankid())) {
                String managerid = creaatemanagerid();
                 manager.setManagerid(managerid);
                   bank.setManagerid(manager.getManagerid());
                bank.setManagername(manager.getManagername());
                manager.setBankid(bank.getBankId());
                bankrepo.save(bank);
            }
        }


        return managerrepo.save(manager); // Return null if no matching bank is found
    }

    public String creaatemanagerid() {
        int id = (int) Math.floor(Math.random() * 100000);

        return id + ".je";


    }


    // Fetch all managers
    public ResponseEntity<List<Manager>> getman() {
        List<Manager> managers = managerrepo.findAll();
        return new ResponseEntity<>(managers, HttpStatus.OK); // Return the list of managers wrapped in ResponseEntity
    }

    // Delete manager by ID
    public void deletemanager(String managerid) {
           removeManagerFromBank(managerid);


           for (Manager manager : managerrepo.findAll()) {
               if (Objects.equals(manager.getManagerid(), managerid)) {
                   managerrepo.delete(manager);

               }
           }


    }

    // Update manager details
    public Manager updatemanager(Manager manager) {
        Bank bank = bankrepo.findById(Long.valueOf(manager.getBankid())).orElse(null);
        if (bank != null) {
            bank.setManagerid(manager.getManagerid());
            bankrepo.save(bank);
        }
        return managerrepo.save(manager);
    }

    // Remove manager from the bank
    public void removeManagerFromBank(String managerid) {
        List<Bank> banks = bankrepo.findAll();
        for (Bank bank : banks) {
            if (managerid.equals(bank.getManagerid())) {
                bank.setManagerid(null);
                bank.setManagername(null);
                bankrepo.save(bank);
            }
        }
    }


}

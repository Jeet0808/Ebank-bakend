package com.example.akhri.repository;

import com.example.akhri.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Accountrepo extends JpaRepository<Accounts, Long> {

    Accounts findAccountsByAccountno(long accountno);

    List<Accounts> findAllBymobileno(String mobileno);


}

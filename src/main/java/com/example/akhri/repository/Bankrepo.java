package com.example.akhri.repository;

import com.example.akhri.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bankrepo extends JpaRepository<Bank, Long> {


    List<Bank> findAllBymobileno(String mobileno);
}

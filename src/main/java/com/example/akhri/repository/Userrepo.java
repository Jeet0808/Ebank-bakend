package com.example.akhri.repository;

import com.example.akhri.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<Users, Long > {
    Users findByUsername(String username);

    Users findBymobileno(String mobileno);
}

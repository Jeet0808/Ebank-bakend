package com.example.akhri.repository;

import com.example.akhri.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Managerrepo extends JpaRepository<Manager,Long> {


}

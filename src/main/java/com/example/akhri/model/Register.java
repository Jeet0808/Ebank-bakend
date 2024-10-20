package com.example.akhri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; // Primary key


    String mobileno;
    String charType;
    String email;
    String username;


    public Register(String mobileno, Long id, String charType, String email,String username) {
        this.mobileno = mobileno;
        this.id = id;
        this.charType = charType;
        this.email = email;
        this.username = username;
    }

    public Register() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Reistrer{" +
                "id=" + id +
                ", mobileno='" + mobileno + '\'' +
                ", charType='" + charType + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

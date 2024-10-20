package com.example.akhri.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Banker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;
    private String accountPassword;
    private String links;
    private long balance;
    String mobileno;
    String email;
    public Banker() {}

    public Banker(String name, int age, String accountPassword, String links, long balance,String mobileno ,String email) {
        this.name = name;

        this.age = age;
        this.accountPassword = accountPassword;
        this.links = links;
        this.balance = balance;
        this.mobileno = mobileno;
        this.email = email;

    }

    // Getters and setters...

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Banker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", accountPassword='" + accountPassword + '\'' +
                ", links='" + links + '\'' +
                ", balance=" + balance + '\'' +
                ", email=" + email + '\'' +
                ", mobileno='" + mobileno +
                '}';
    }
}

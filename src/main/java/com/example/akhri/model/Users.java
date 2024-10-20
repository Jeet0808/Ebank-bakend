package com.example.akhri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private int age;
    private String accountPassword;
    private String links;
    private long balance;
    String mobileno;
    String email;

    public Users(long id, String name, String username, int age, String accountPassword, String links, long balance, String mobileno, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.age = age;
        this.accountPassword = accountPassword;
        this.links = links;
        this.balance = balance;
        this.mobileno = mobileno;
        this.email = email;
    }

    public Users(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", accountPassword='" + accountPassword + '\'' +
                ", links='" + links + '\'' +
                ", balance=" + balance +
                ", mobileno='" + mobileno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

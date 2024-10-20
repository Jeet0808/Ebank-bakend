package com.example.akhri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String accounttype;
    private String  mobileno;
    private String password;
    private int age;
    private long accountno;
    private String bankName;
    private String bankId;
    double balance = 0;
    String email;



    public Accounts() {

    }

    public Accounts(long id, String username, String name, String mobileno, String password, int age, long accountno, String bankName, String bankId, double balance , String email ,String accounttype) {
        this.id = id;
        this.username = username;
        this.mobileno = mobileno;
        this.password = password;
        this.age = age;
        this.accountno = accountno;
        this.bankName = bankName;
        this.bankId = bankId;
        this.balance = balance;
        this.email = email;
        this.accounttype = accounttype;
        this.name = name;
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

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accountno=" + accountno +
                ", bankName='" + bankName + '\'' +
                ", bankId='" + bankId + '\'' +
                ", accounttype='" + accounttype + '\'' +
                ", balance=" + balance +
                '}';
    }
}

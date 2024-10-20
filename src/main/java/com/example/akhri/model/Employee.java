package com.example.akhri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobileno;
    private int age;
    private String links;
    private long balance;
    String Description;
    private String employeeid;
    String email;


    public Employee(Long id, String name, String mobileno, int age, String links, long balance, String description, String employeeid , String email) {
        this.id = id;
        this.name = name;
        this.mobileno = mobileno;
        this.age = age;
        this.links = links;
        this.balance = balance;
        this.Description = description;
        this.employeeid = employeeid;
        this.email = email;

    }

    public Employee() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
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

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", age=" + age +
                ", links='" + links + '\'' +
                ", balance=" + balance +
                ", Description='" + Description + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

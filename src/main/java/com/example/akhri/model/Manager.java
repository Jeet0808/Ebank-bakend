package com.example.akhri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Change "Id" to "id" for consistency
    private String managername;
    private String managerid;
    private String bankid;
    private int salary;
    String Description;
    String email;

    // Constructors
    public Manager(String managername, String managerid, String bankid, int salary,String Description ,String email) {
        this.managername = managername;
        this.managerid = managerid;
        this.bankid = bankid;
        this.salary = salary;
        this.Description = Description;
        this.email = email;
    }

    public Manager() {}

    // Getters and Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", managername='" + managername + '\'' +
                ", managerid='" + managerid + '\'' +
                ", bankid='" + bankid + '\'' +
                ", Description='" + Description + '\'' +
                ", salary=" + salary + '\'' +
                ", email='" + email +
                '}';
    }
}

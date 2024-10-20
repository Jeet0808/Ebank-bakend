package com.example.akhri.model;

import jakarta.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String currencyOfBank;
    private String bankId;
    private long funds;

    private String mobileno;
    private String managername;
    private String managerid;
    long Totalusers;
    long Totalemp;



    public Bank() {}

    public Bank(String bankName, String currencyOfBank, String bankId, long funds, String mobileno, String managername,String managerid, long Totalusers,long Totalemp) {
        this.bankName = bankName;
        this.currencyOfBank = currencyOfBank;
        this.bankId = bankId;
        this.funds = funds;
        this.mobileno = mobileno;
        this.managername = managername;
        this.managerid = managerid;
        this.Totalusers = Totalusers;
        this.Totalemp = Totalemp;
    }

    // Getters and setters...

    public String createbankid(){
        int id  = (int) Math.floor(Math.random()*1000);
        String bankId = id + ".JLSS";
        return bankId;
    }

    public long getTotalemp() {
        return Totalemp;
    }

    public void setTotalemp(long totalemp) {
        Totalemp = totalemp;
    }

    public long getTotalusers() {
        return Totalusers;
    }

    public void setTotalusers(long totalusers) {
        Totalusers = totalusers;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrencyOfBank() {
        return currencyOfBank;
    }

    public void setCurrencyOfBank(String currencyOfBank) {
        this.currencyOfBank = currencyOfBank;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }


    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", currencyOfBank='" + currencyOfBank + '\'' +
                ", bankId='" + bankId + '\'' +
                ", funds=" + funds +
                ", mobileno='" + mobileno + '\'' +
                ", managername='" + managername + '\'' +
                ", managerid='" + managerid + '\'' +
                ", Totalusers='" + Totalusers + '\'' +
                ", Totalemp='" + Totalemp + '\'' +
                '}';
    }
}

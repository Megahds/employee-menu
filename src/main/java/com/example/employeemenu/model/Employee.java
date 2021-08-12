package com.example.employeemenu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//import java.time.LocalDate;

public class Employee {

    private int id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tglMasuk;

    private String noHP;

    private String limitReimb;

//    private String createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

    public Employee() {
    }

    public Employee(int id, String name, Date tglMasuk, String noHP, String limitReimb) {
        this.id = id;
        this.name = name;
        this.tglMasuk = tglMasuk;
        this.noHP = noHP;
        this.limitReimb = limitReimb;
    }

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate createdDate;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getLimitReimb() {
        return limitReimb;
    }

    public void setLimitReimb(String limitReimb) {
        this.limitReimb = limitReimb;
    }

//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDate getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(LocalDate updatedDate) {
//        this.updatedDate = updatedDate;
//    }

    @Override
    public String toString() {
        return "Id = "
                + id
                + " name = "
                + name
                + " tglMasuk = "
                + tglMasuk
                + " noHP = "
                + noHP
                + " limitReimb = "
                + limitReimb
                + " updatedDate = "
                + updatedDate;
    }
}

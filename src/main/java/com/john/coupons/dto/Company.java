package com.john.coupons.dto;

import com.john.coupons.entities.CompanyEntity;
import com.john.coupons.enums.Category;

public class Company {
    private int id;
    private String companyName;
    private String phoneNumber;
    private String address;
    private Category category;

    public Company(int id, String companyName, String phoneNumber, String address, Category category) {
        this.id = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.category = category;
    }

    public Company(String companyName, String phoneNumber, String address, Category category) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.category = category;
    }

    public Company(){
    }

    public Company(int id){
        this.id = id;
    }

    public Company(CompanyEntity companyEntity) {
        this.companyName = companyEntity.getCompanyName();
        this.phoneNumber = companyEntity.getPhoneNumber();
        this.address = companyEntity.getAddress();
        this.category = companyEntity.getCategory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return null;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                '}';
    }
}

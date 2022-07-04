package com.john.coupons.entities;


import com.john.coupons.dto.Company;
import com.john.coupons.enums.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CouponEntity> couponEntity;

    public CompanyEntity() {
    }

    public CompanyEntity(int id, String companyName, String phoneNumber, String address, Category category, List<CouponEntity> couponEntity) {
        this.id = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.category = category;
        this.couponEntity = couponEntity;
    }

    public CompanyEntity(String companyName, String phoneNumber, String address, Category category, List<CouponEntity> couponEntity) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.category = category;
        this.couponEntity = couponEntity;
    }

    public CompanyEntity(Company company) {
        this.companyName = company.getCompanyName();
        this.phoneNumber = company.getPhoneNumber();
        this.address = company.getAddress();
        this.category = company.getCategory();
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

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public List<CouponEntity> getCouponEntity() {
        return couponEntity;
    }

    public void setCouponEntity(List<CouponEntity> couponEntity) {
        this.couponEntity = couponEntity;
    }
}

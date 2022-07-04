package com.john.coupons.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.john.coupons.dto.Customer;
import com.john.coupons.logic.CustomersLogic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "amount_of_children")
    private int amountOfChildren;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchaseEntities;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId
    private UserEntity user;

    public CustomerEntity() {
    }

    public CustomerEntity(int id, String address, int amountOfChildren, int age, String phoneNumber, List<PurchaseEntity> purchaseEntities, UserEntity user) {
        this.id = id;
        this.address = address;
        this.amountOfChildren = amountOfChildren;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.purchaseEntities = purchaseEntities;
        this.user = user;
    }

    public CustomerEntity(String address, int amountOfChildren, int age, String phoneNumber, List<PurchaseEntity> purchaseEntities, UserEntity user) {
        this.address = address;
        this.amountOfChildren = amountOfChildren;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.purchaseEntities = purchaseEntities;
        this.user = user;
    }

    public CustomerEntity(Customer customer) {
        this.id = customer.getId();
        this.address = customer.getAddress();
        this.amountOfChildren = customer.getAmountOfChildren();
        this.age = customer.getAge();
        this.phoneNumber = customer.getPhoneNumber();
        this.user = null;
    }

    public CustomerEntity(CustomersLogic customersLogic) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PurchaseEntity> getPurchaseEntities() {
        return purchaseEntities;
    }

    public void setPurchaseEntities(List<PurchaseEntity> purchaseEntities) {
        this.purchaseEntities = purchaseEntities;
    }

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity user) {
        this.user = user;
    }
}


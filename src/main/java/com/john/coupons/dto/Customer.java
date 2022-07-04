package com.john.coupons.dto;

import com.john.coupons.entities.CustomerEntity;

public class Customer {
    private int id;
    private String address;
    private int amountOfChildren;
    private int age;
    private String phoneNumber;
    private Integer userId;

    public Customer(){
    }

    public Customer(int id, String address, int amountOfChildren, int age, String phoneNumber, Integer userId) {
        this.id = id;
        this.address = address;
        this.amountOfChildren = amountOfChildren;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public Customer(String address, int amountOfChildren, int age, String phoneNumber, Integer userId) {
        this.address = address;
        this.amountOfChildren = amountOfChildren;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public Customer(CustomerEntity customerEntity) {
        this.address = customerEntity.getAddress();
        this.amountOfChildren = customerEntity.getAmountOfChildren();
        this.age = customerEntity.getAge();
        this.phoneNumber = customerEntity.getPhoneNumber();
        this.userId = customerEntity.getUserEntity().getId();
    }

    public Customer(int id){
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", amountOfChildren=" + amountOfChildren +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userId=" + userId +
                '}';
    }
}



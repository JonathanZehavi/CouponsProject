package com.john.coupons.dto;

import com.john.coupons.entities.UserEntity;
import com.john.coupons.enums.UserType;

public class User {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer companyId;
    private UserType userType;


    public User(){
    }

    public User(int id, String username, String password, String firstName, String lastName, Integer companyId, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userType = userType;
    }

    public User(String username, String password, String firstName, String lastName, Integer companyId, UserType userType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userType = userType;
    }

    public User(UserEntity userEntity){
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.firstName = userEntity.getPassword();
        this.lastName = userEntity.getLastName();
        this.companyId = getCompanyId();
        this.userType = userEntity.getUserType();
    }

    public User(String username){
        this.username = username;
    }

    public User(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyId=" + companyId +
                ", userType=" + userType +
                '}';
    }
}

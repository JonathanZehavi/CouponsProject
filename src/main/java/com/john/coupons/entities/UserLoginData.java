package com.john.coupons.entities;

import com.john.coupons.enums.UserType;

public class UserLoginData {
    private int id;
    private UserType userType;

    public UserLoginData(int id, UserType userType) {
        this.id = id;
        this.userType = userType;
    }

    public UserLoginData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

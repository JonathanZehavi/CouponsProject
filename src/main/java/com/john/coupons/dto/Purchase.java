package com.john.coupons.dto;

import com.john.coupons.entities.CustomerEntity;
import com.john.coupons.entities.PurchaseEntity;

import java.sql.Timestamp;

public class Purchase {
    private int id;
    private Integer customerId;
    private Integer couponId;
    private int amount;
    private Timestamp timeStamp;

    public Purchase(int id, Integer customerId, Integer couponId, int amount, Timestamp timeStamp) {
        this.id = id;
        this.customerId = customerId;
        this.couponId = couponId;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public Purchase(Integer customerId, Integer couponId, int amount, Timestamp timeStamp) {
        this.customerId = customerId;
        this.couponId = couponId;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }
    public Purchase(){

    }

    public Purchase(int id){
        this.id = id;
    }


    public Purchase(PurchaseEntity purchaseEntity){
        this.id = purchaseEntity.getId();
        this.amount = purchaseEntity.getAmount();
        this.timeStamp = purchaseEntity.getTimeStamp();
        this.customerId = getCustomerId();
        this.couponId = getCouponId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", couponId=" + couponId +
                ", amount=" + amount +
                ", timeStamp=" + timeStamp +
                '}';
    }
}

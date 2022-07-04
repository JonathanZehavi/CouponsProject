package com.john.coupons.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.john.coupons.controllers.PurchasesController;
import com.john.coupons.dto.Purchase;
import com.john.coupons.logic.PurchasesLogic;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "time_stamp", nullable = false)
    @CreationTimestamp
    private Timestamp timeStamp;

    @ManyToOne(fetch = FetchType.EAGER)
    private CouponEntity coupon;

    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerEntity customer;

    public PurchaseEntity() {
    }

    public PurchaseEntity(int id, int amount, Timestamp timeStamp, CouponEntity coupon, CustomerEntity customer) {
        this.id = id;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.coupon = coupon;
        this.customer = customer;
    }

    public PurchaseEntity(int amount, Timestamp timeStamp, CouponEntity coupon, CustomerEntity customer) {
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.coupon = coupon;
        this.customer = customer;
    }

    public PurchaseEntity(Purchase purchase) {
        this.amount = purchase.getAmount();
        this.timeStamp = purchase.getTimeStamp();
        this.coupon = null;
        this.customer = null;
    }

    public PurchaseEntity(PurchasesLogic purchasesLogic) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CouponEntity getCouponEntity() {
        return coupon;
    }

    public void setCouponEntity(CouponEntity coupon) {
        this.coupon = coupon;
    }

    public CustomerEntity getCustomerEntity() {
        return customer;
    }

    public void setCustomerEntity(CustomerEntity customer) {
        this.customer = customer;
    }
}

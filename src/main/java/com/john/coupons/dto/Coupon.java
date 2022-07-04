package com.john.coupons.dto;

import com.john.coupons.entities.CouponEntity;
import com.john.coupons.enums.Category;

import java.util.Date;


public class Coupon {
    private int id;
    private Integer companyId;
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private float price;


    public Coupon(Integer companyId, Category category, String title, String description, Date startDate, Date endDate, int amount, float price) {
        this.companyId = companyId;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
    }

    public Coupon(int id, Integer companyId, Category category, String title, String description, Date startDate, Date endDate, int amount, float price) {
        this.id = id;
        this.companyId = companyId;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
    }

    public Coupon() {

    }

    public Coupon(int id) {
        this.id = id;
    }

    public Coupon(Category category) {
        this.category = category;
    }

    public Coupon(CouponEntity couponEntity) {
        this.companyId = couponEntity.getCompanyEntity().getId();
        this.category = couponEntity.getCategory();
        this.title = couponEntity.getTitle();
        this.description = couponEntity.getDescription();
        this.startDate = couponEntity.getStartDate();
        this.endDate = couponEntity.getEndDate();
        this.amount = couponEntity.getAmount();
        this.price = couponEntity.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}

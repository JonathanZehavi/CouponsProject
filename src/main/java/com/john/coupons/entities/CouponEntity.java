package com.john.coupons.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.john.coupons.dto.Coupon;
import com.john.coupons.enums.Category;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy.MM.dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy.MM.dd")
    private Date endDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "price", nullable = false)
    private float price;

    @ManyToOne
    private CompanyEntity company;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PurchaseEntity> purchaseEntities;

    public CouponEntity() {

    }

    public CouponEntity(int id, Category category, String title, String description, Date startDate, Date endDate, Integer amount, float price, CompanyEntity company, List<PurchaseEntity> purchaseEntities) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.company = company;
        this.purchaseEntities = purchaseEntities;
    }

    public CouponEntity(Category category, String title, String description, Date startDate, Date endDate, Integer amount, float price, CompanyEntity company, List<PurchaseEntity> purchaseEntities) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.company = company;
        this.purchaseEntities = purchaseEntities;
    }

    public CouponEntity(Coupon coupon) {
        this.category = coupon.getCategory();
        this.title = coupon.getTitle();
        this.description = coupon.getDescription();
        this.startDate = coupon.getStartDate();
        this.endDate = coupon.getEndDate();
        this.amount = coupon.getAmount();
        this.price = coupon.getPrice();
        this.company = null;
    }

    public CouponEntity(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CompanyEntity getCompanyEntity() {
        return company;
    }

    public void setCompanyEntity(CompanyEntity company) {
        this.company = company;
    }

    public List<PurchaseEntity> getPurchaseEntities() {
        return purchaseEntities;
    }

    public void setPurchaseEntities(List<PurchaseEntity> purchaseEntities) {
        this.purchaseEntities = purchaseEntities;
    }
}



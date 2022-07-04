package com.john.coupons.logic;

import com.john.coupons.dto.Company;
import com.john.coupons.dto.Coupon;
import com.john.coupons.entities.CompanyEntity;
import com.john.coupons.entities.CouponEntity;
import com.john.coupons.enums.Category;
import com.john.coupons.repositories.ICouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CouponsLogic {

    @Autowired
    private final ICouponsRepository couponsRepository;
    private final CompaniesLogic companiesLogic;

    public CouponsLogic(ICouponsRepository couponsRepository, CompaniesLogic companiesLogic) {
        this.couponsRepository = couponsRepository;
        this.companiesLogic = companiesLogic;
    }

    public Coupon createCoupon(Coupon coupon) {
        CouponEntity couponEntity = new CouponEntity(coupon);
        CompanyEntity companyEntity = null;
        if (coupon.getCompanyId() != null) {
            companyEntity = companiesLogic.getCompany(coupon.getCompanyId());
        }
        couponEntity.setCompanyEntity(companyEntity);
        couponEntity = couponsRepository.save(couponEntity);
        return new Coupon(couponEntity);
    }

    public Coupon updateCoupon(Coupon coupon) {
        CouponEntity couponEntity = new CouponEntity(coupon);
        couponEntity = couponsRepository.save(couponEntity);
        return new Coupon(couponEntity);
    }

    public CouponEntity getCouponById(int id) {
        CouponEntity couponEntity = couponsRepository.findById(id);
        return couponEntity;
    }

    public void deleteCoupon(int id) {
        couponsRepository.deleteById(id);
    }

    public List<Coupon> findByCategory(Category category) {
        return couponsRepository.findByCategory(category);
    }

    public List<Coupon> getAllCoupons() {
        List<Coupon> couponList = couponsRepository.getAllCoupons();
        return couponList;
    }

    public List<Coupon> getCouponByCompanyId(Integer companyId) {
        Company company = new Company();
        companyId = company.getId();
        List<Coupon> couponList = couponsRepository.getCouponByCompanyId(companyId);
        for (Coupon coupon : couponList) {
            if (companyId != null && companiesLogic.getCompany(companyId).equals(companyId)) {
                couponList.add(coupon);
            }
        }
        return couponList;
    }
}

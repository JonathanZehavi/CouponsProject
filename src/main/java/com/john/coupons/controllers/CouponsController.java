package com.john.coupons.controllers;

import com.john.coupons.dto.Coupon;
import com.john.coupons.logic.CouponsLogic;
import com.john.coupons.entities.CouponEntity;
import com.john.coupons.enums.Category;
import com.john.coupons.exceptions.ApplicationException;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    private final CouponsLogic couponsLogic;

    @Autowired
    private CouponsController(CouponsLogic couponsLogic) {
        this.couponsLogic = couponsLogic;
    }

    @PostMapping
    public Coupon addCoupon(@RequestBody Coupon coupon) throws ApplicationException {
        return couponsLogic.createCoupon(coupon);
    }

    @PutMapping
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponsLogic.updateCoupon(coupon);
    }

    @GetMapping("/{id}")
    public CouponEntity getCoupon(@PathVariable(name = "id") int id) {
        return couponsLogic.getCouponById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable("id") int id) {
        couponsLogic.deleteCoupon(id);
    }

    @GetMapping("/byCategory")
    public List<Coupon> getCouponByCategory(@RequestParam(name = "category") Category category) {
        return couponsLogic.findByCategory(category);
    }

    @GetMapping List<Coupon> getAllCoupons(){
        return couponsLogic.getAllCoupons();
    }
    @GetMapping("/byCompanyId")
    public List<Coupon> getCouponByCompanyId(@PathVariable(name = "companyId") Integer companyId){
        return couponsLogic.getCouponByCompanyId(companyId);
    }


}

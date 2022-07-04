package com.john.coupons.repositories;

import com.john.coupons.dto.Coupon;
import com.john.coupons.entities.CouponEntity;
import com.john.coupons.enums.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICouponsRepository extends CrudRepository<CouponEntity, Integer> {

//    @Query("SELECT new com.john.coupons.dto.Coupon(c.id, c.companyId, c.category, c.title, c.description, c.startDate, c.endDate, c.amount, c.price)" +
//            "FROM CouponEntity c WHERE c.category= :category")
    List<Coupon> findByCategory(Category category);

//    @Query("SELECT new com.john.coupons.dto.Coupon(c.id, c.companyId, c.category, c.title, c.description, c.startDate, c.endDate, c.amount, c.price)" +
//            "FROM CouponEntity c WHERE c.id= :id")
    CouponEntity findById(int id);

    @Query("SELECT c FROM CouponEntity c WHERE c.companyId= :companyId")
    List<Coupon> getCouponByCompanyId(@Param("companyId") Integer companyId);

    @Query("SELECT c FROM CouponEntity c")
    List<Coupon> getAllCoupons();


}

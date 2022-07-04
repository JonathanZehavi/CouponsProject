package com.john.coupons.repositories;

import com.john.coupons.dto.Purchase;
import com.john.coupons.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchasesRepository extends CrudRepository<PurchaseEntity, Integer> {

//    @Query("SELECT new com.john.coupons.dto.Purchase(p.customerId, p.couponId, p.amount, p.timeStamp)" +
//            "FROM PurchaseEntity p WHERE p.customerId= :customerId")
//    List<PurchaseEntity> findAllByCustomerId(@Param("customerId") int customerId);

    PurchaseEntity findById(int id);

    @Query("SELECT p FROM PurchaseEntity p")
    List<Purchase> getAllPurchases();
}

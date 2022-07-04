package com.john.coupons.logic;

import com.john.coupons.dto.Purchase;
import com.john.coupons.entities.CouponEntity;
import com.john.coupons.entities.CustomerEntity;
import com.john.coupons.entities.PurchaseEntity;
import com.john.coupons.repositories.IPurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PurchasesLogic {

    @Autowired
    private final IPurchasesRepository purchasesRepository;
    private final CustomersLogic customersLogic;
    private final CouponsLogic couponsLogic;

    public PurchasesLogic(IPurchasesRepository purchasesRepository, CustomersLogic customersLogic, CouponsLogic couponsLogic) {
        this.purchasesRepository = purchasesRepository;
        this.customersLogic = customersLogic;
        this.couponsLogic = couponsLogic;
    }

    public Purchase createPurchase(Purchase purchase) {
        PurchaseEntity purchaseEntity = new PurchaseEntity(purchase);
        CustomerEntity customerEntity = null;
        CouponEntity couponEntity = null;
        if (purchase.getCouponId() != null && purchase.getCustomerId() != null) {
            customerEntity = customersLogic.getCustomerById(purchase.getCustomerId());
            couponEntity = couponsLogic.getCouponById(purchase.getCouponId());
        }
        purchaseEntity.setCustomerEntity(customerEntity);
        purchaseEntity.setCouponEntity(couponEntity);
        purchaseEntity = purchasesRepository.save(purchaseEntity);
        return new Purchase(purchaseEntity);
    }

    public Purchase updatePurchase(Purchase purchase) {
        PurchaseEntity purchaseEntity = new PurchaseEntity(purchase);
        purchaseEntity = purchasesRepository.save(purchaseEntity);
        return new Purchase(purchaseEntity);
    }

    public PurchaseEntity getPurchaseById(int id) {
        PurchaseEntity purchaseEntity = purchasesRepository.findById(id);
        return purchaseEntity;
    }

    public void deletePurchase(int id) {
        purchasesRepository.deleteById(id);
    }

//    public List<PurchaseEntity> getPurchasesByCustomerId(int customerId){
//        customerId = purchaseEntity.getCustomerEntity().getId();
//        List<PurchaseEntity> purchaseList = purchasesRepository.findAllByCustomerId(customerId);
//        return purchaseList;
//    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> purchaseList = purchasesRepository.getAllPurchases();
        return purchaseList;
    }

}

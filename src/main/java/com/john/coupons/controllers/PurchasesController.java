package com.john.coupons.controllers;

import com.john.coupons.dto.Purchase;
import com.john.coupons.entities.PurchaseEntity;
import com.john.coupons.logic.PurchasesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    private PurchasesLogic purchasesLogic;

    @Autowired
    public PurchasesController(PurchasesLogic purchasesLogic) {
        this.purchasesLogic = purchasesLogic;
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchasesLogic.createPurchase(purchase);
    }

    @PutMapping
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        return purchasesLogic.updatePurchase(purchase);
    }

    @GetMapping("{id}")
    public PurchaseEntity getPurchaseById(@RequestParam("id") int id) {
        return purchasesLogic.getPurchaseById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@RequestParam("id") int id) {
        purchasesLogic.deletePurchase(id);
    }

//    @GetMapping("/ByCustomer/{customerId}")
//    public List<PurchaseEntity> getPurchasesByCustomerId(@PathVariable(name = "customerId") int customerId) {
//        return purchasesLogic.getPurchasesByCustomerId(customerId);
//    }

    @GetMapping
    public List<Purchase> getAllPurchases(){
        return purchasesLogic.getAllPurchases();
    }

}

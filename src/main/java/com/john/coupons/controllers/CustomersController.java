package com.john.coupons.controllers;

import com.john.coupons.dto.Customer;
import com.john.coupons.entities.CustomerEntity;
import com.john.coupons.logic.CustomersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersLogic customersLogic;

    @Autowired
    public CustomersController(CustomersLogic customersLogic) {
        this.customersLogic = customersLogic;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customersLogic.createCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
       return customersLogic.updateCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerEntity getCustomerById(@RequestParam(name = "id") int id) {
       return customersLogic.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") int id) {
        customersLogic.deleteCustomer(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customersLogic.getAllCustomers();
    }
}

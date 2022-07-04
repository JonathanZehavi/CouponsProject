package com.john.coupons.controllers;

import com.john.coupons.dto.Company;
import com.john.coupons.entities.CompanyEntity;
import com.john.coupons.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private final CompaniesLogic companiesLogic;

    @Autowired
    private CompaniesController(CompaniesLogic companiesLogic) {
        this.companiesLogic = companiesLogic;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companiesLogic.createCompany(company);
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        return companiesLogic.updateCompany(company);
    }

    @GetMapping("/{id}")
    public CompanyEntity getCompany(@PathVariable("id") int id) {
        return companiesLogic.getCompany(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companiesLogic.deleteCompany(id);
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companiesLogic.getAllCompanies();
    }
}

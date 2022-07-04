package com.john.coupons.repositories;

import com.john.coupons.dto.Company;
import com.john.coupons.entities.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompaniesRepository extends CrudRepository<CompanyEntity, Integer> {

//    @Query("SELECT new com.john.coupons.dto.Company(c.id, c.companyName, c.phoneNumber, c.address, c.category)" +
//            "FROM CompanyEntity c WHERE c.id= :id")
    CompanyEntity findById(int id);

    @Query("SELECT c FROM CompanyEntity c")
    List<Company> getAllCompanies();
}

package com.john.coupons.repositories;

import com.john.coupons.dto.Customer;
import com.john.coupons.entities.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomersRepository extends CrudRepository<CustomerEntity, Integer> {

//    @Query("SELECT new com.john.coupons.dto.Customer(c.id, c.address, c.amountOfChildren, c.age, c.poneNumber, c.userId)" +
//            "FROM CustomerEntity c WHERE c.id= :id") @Param("id")
    CustomerEntity findById(int id);

    @Query("SELECT c FROM CustomerEntity c")
    List<Customer> getAllCustomers();


}

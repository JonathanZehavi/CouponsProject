package com.john.coupons.logic;

import com.john.coupons.dto.Customer;
import com.john.coupons.entities.CustomerEntity;
import com.john.coupons.entities.UserEntity;
import com.john.coupons.repositories.ICustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomersLogic {

    @Autowired
    private final ICustomersRepository customersRepository;
    private final UsersLogic usersLogic;

    public CustomersLogic(ICustomersRepository customersRepository, UsersLogic usersLogic) {
        this.customersRepository = customersRepository;
        this.usersLogic = usersLogic;
    }


    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        UserEntity userEntity = null;
        if (customer.getUserId() != null){
            userEntity = usersLogic.getUser(customer.getUserId());
        }
        customerEntity.setUserEntity(userEntity);
        customerEntity = customersRepository.save(customerEntity);
        return new Customer(customerEntity);
    }

    public Customer updateCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        customerEntity = customersRepository.save(customerEntity);
        return new Customer(customerEntity);
    }

    public CustomerEntity getCustomerById(int id) {
        CustomerEntity customerEntity = customersRepository.findById(id);
        return customerEntity;
    }

    public void deleteCustomer(int id) {
        customersRepository.deleteById(id);
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = customersRepository.getAllCustomers();
        return customerList;
    }
}

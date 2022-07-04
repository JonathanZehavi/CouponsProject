package com.john.coupons.logic;


import com.john.coupons.dto.User;
import com.john.coupons.entities.UserEntity;
import com.john.coupons.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersLogic {

    @Autowired
    private final IUserRepository userRepository;
    private CustomersLogic customersLogic;

    public UsersLogic(IUserRepository userRepository, @Lazy CustomersLogic customersLogic) {
        this.userRepository = userRepository;
        this.customersLogic = customersLogic;
    }


    public User createUser(User user) {
        UserEntity userEntity = new UserEntity(user);
        userEntity = userRepository.save(userEntity);
        return new User(userEntity);
    }

    public User updateUser(User user) {
        UserEntity userEntity = new UserEntity(user);
        userEntity = userRepository.save(userEntity);
        return new User(userEntity);
    }

    public UserEntity getUser(int id) {
        UserEntity userEntity = userRepository.findById(id);
        return userEntity;

    }

    public List<UserEntity> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public UserEntity findByUserName(String username) {
        List<UserEntity> userList = userRepository.findByUsername(username);
        return userList.get(0);
    }

    public boolean existById(int id) {
        if (userRepository.existsById(id)){
            return true;
        }
        return false;
    }

}

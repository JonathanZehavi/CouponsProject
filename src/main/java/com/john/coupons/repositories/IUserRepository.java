package com.john.coupons.repositories;

import com.john.coupons.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

    boolean existsById(int id);

    List<UserEntity> findByUsername(String username);

    UserEntity findById(int id);

    List<UserEntity> findAll();


}

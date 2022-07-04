package com.john.coupons.controllers;

import com.john.coupons.dto.User;
import com.john.coupons.entities.UserEntity;
import com.john.coupons.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {


    private final UsersLogic usersLogic;

    @Autowired
    public UsersController(UsersLogic usersLogic) {
        this.usersLogic = usersLogic;
    }


    @PostMapping
    public void createUser(@RequestBody User user) {
        usersLogic.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        usersLogic.updateUser(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable(name = "id") int id) {
        return usersLogic.getUser(id);
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return usersLogic.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        usersLogic.deleteUser(id);
    }

    @GetMapping("/byUserName")
    public UserEntity findByUserName(@RequestParam("username") String username) {
        return usersLogic.findByUserName(username);
    }

    @GetMapping("/isUserExist/{id}")
    public boolean isUserExist(@PathVariable(name = "id") int id) {
        return usersLogic.existById(id);
    }


}

package com.finance_dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance_dashboard.model.User;
import com.finance_dashboard.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return service.getAllUsers();
    }

    @PutMapping("/deactivate/{id}")
    public String deactivateUser(@PathVariable Long id){
        service.deactivateUser(id);
        return "User deactivated";
    }

}
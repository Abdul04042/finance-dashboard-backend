package com.finance_dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance_dashboard.model.User;
import com.finance_dashboard.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deactivateUser(Long id) {

        User user = repository.findById(id).orElseThrow();

        user.setActive(false);

        repository.save(user);
    }

}

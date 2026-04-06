package com.finance_dashboard.service;

import java.util.List;
import com.finance_dashboard.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    void deactivateUser(Long id);

}
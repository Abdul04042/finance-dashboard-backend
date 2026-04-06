package com.finance_dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finance_dashboard.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
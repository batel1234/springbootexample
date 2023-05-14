package com.javatpoint.service;

import com.javatpoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByNameContains(String name);
}

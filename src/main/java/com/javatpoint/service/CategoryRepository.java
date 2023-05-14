package com.javatpoint.service;

import com.javatpoint.model.Category;
import com.javatpoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

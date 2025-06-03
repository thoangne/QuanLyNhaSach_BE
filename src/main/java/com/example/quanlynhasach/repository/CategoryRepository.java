package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByname(String name);
}
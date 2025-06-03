package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findBytitle(String title);
}
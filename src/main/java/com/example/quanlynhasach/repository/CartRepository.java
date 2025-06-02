package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);
}
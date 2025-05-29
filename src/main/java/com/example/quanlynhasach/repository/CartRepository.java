package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    List<Cart> findByUser(User user);
}
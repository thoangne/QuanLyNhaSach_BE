package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.CartItem;
import com.example.quanlynhasach.model.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
    List<CartItem> findByCartId(int cartId);
}
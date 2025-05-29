package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;

import java.util.List;
import java.util.UUID;

public interface CartService {
    Cart createCart(User user);

    List<Cart> getCartsByUser(User user);

    Cart getCartById(UUID id);

    void deleteCart(UUID id);
}
package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;

import java.util.List;

public interface CartService {
    Cart createCart(User user);

    List<Cart> getCartsByUser(User user);

    Cart getCartById(int id);

    boolean deleteCart(int id);
}
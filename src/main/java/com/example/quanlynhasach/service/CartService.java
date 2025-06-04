package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.CartItem;
import com.example.quanlynhasach.model.Product;
import com.example.quanlynhasach.model.User;

import java.util.List;

public interface CartService {
    Cart createCart(User user);

    List<Cart> getCartsByUser(User user);

    Cart getCartById(int id);

    boolean deleteCart(int id);

    List<CartItem> getCartItems(int cartId);

    void addItemToCart(User user, Product product, int quantity);

    void removeItemFromCart(User user, int productId);

    void clearCart(User user);
}
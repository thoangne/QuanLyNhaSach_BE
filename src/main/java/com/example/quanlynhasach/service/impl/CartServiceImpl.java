package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;
import com.example.quanlynhasach.repository.CartRepository;
import com.example.quanlynhasach.service.CartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart(user, LocalDateTime.now());
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByUser(User user) {
        return cartRepository.findByUser(user);
    }

    @Override
    public Cart getCartById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.orElse(null);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
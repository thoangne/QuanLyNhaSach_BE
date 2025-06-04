package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.*;
import com.example.quanlynhasach.repository.CartItemRepository;
import com.example.quanlynhasach.repository.CartRepository;
import com.example.quanlynhasach.repository.ProductRepository;
import com.example.quanlynhasach.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
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
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCart(int id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItem> getCartItems(int cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    @Override
    public void addItemToCart(User user, Product product, int quantity) {
        Cart cart = getOrCreateCartByUser(user);
        CartItemKey key = new CartItemKey(cart.getId(), product.getId());

        CartItem item = cartItemRepository.findById(key)
                .orElse(new CartItem(cart, product, 0));
        item.setQuantity(item.getQuantity() + quantity);
        cartItemRepository.save(item);
    }

    @Override
    public void removeItemFromCart(User user, int productId) {
        Cart cart = getOrCreateCartByUser(user);
        CartItemKey key = new CartItemKey(cart.getId(), productId);
        cartItemRepository.deleteById(key);
    }

    @Override
    public void clearCart(User user) {
        Cart cart = getOrCreateCartByUser(user);
        List<CartItem> items = cartItemRepository.findByCartId(cart.getId());
        cartItemRepository.deleteAll(items);
    }

    private Cart getOrCreateCartByUser(User user) {
        List<Cart> carts = cartRepository.findByUser(user);
        if (!carts.isEmpty()) {
            return carts.get(0);
        } else {
            Cart newCart = new Cart(user, LocalDateTime.now());
            return cartRepository.save(newCart);
        }
    }
}
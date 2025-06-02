package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.User;
import com.example.quanlynhasach.service.CartService;
import com.example.quanlynhasach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    // Tạo giỏ hàng mới cho user (theo userId)
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestParam int userId) {
        User user = userService.getUserById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        Cart cart = cartService.createCart(user);
        return ResponseEntity.ok(cart);
    }

    // Lấy danh sách cart theo userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartsByUser(@PathVariable int userId) {
        User user = userService.getUserById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Cart> carts = cartService.getCartsByUser(user);
        return ResponseEntity.ok(carts);
    }

    // Lấy cart theo cartId
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable int id) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    // Xóa cart theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
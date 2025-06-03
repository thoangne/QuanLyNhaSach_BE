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
    public ResponseEntity<?> createCart(@RequestParam int userId) {
        try {
            User user = userService.getUserById(userId).orElse(null);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            Cart cart = cartService.createCart(user);
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi tạo giỏ hàng: " + e.getMessage());
        }
    }

    // Lấy danh sách cart theo userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartsByUser(@PathVariable int userId) {
        try {
            User user = userService.getUserById(userId).orElse(null);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            List<Cart> carts = cartService.getCartsByUser(user);
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi lấy giỏ hàng theo người dùng: " + e.getMessage());
        }
    }

    // Lấy cart theo cartId
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable int id) {
        try {
            Cart cart = cartService.getCartById(id);
            if (cart == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi lấy giỏ hàng: " + e.getMessage());
        }
    }

    // Xóa cart theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        try {
            boolean deleted = cartService.deleteCart(id);
            if (deleted) {
                return ResponseEntity.ok("Đã xóa giỏ hàng có ID = " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi lấy giỏ hàng: " + e.getMessage());
        }
    }
}
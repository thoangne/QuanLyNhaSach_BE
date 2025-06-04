package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.Cart;
import com.example.quanlynhasach.model.CartItem;
import com.example.quanlynhasach.model.Product;
import com.example.quanlynhasach.model.User;
import com.example.quanlynhasach.service.CartService;
import com.example.quanlynhasach.service.ProductService;
import com.example.quanlynhasach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    public CartController(CartService cartService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
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

    // lấy danh sách item theo cartid
    @GetMapping("/items/{cartId}")
    public ResponseEntity<?> getCartItems(@PathVariable int cartId) {
        List<CartItem> items = cartService.getCartItems(cartId);

        if (items.isEmpty()) {
            return ResponseEntity.status(404).body("Không có sản phẩm nào trong giỏ hàng.");
        }

        return ResponseEntity.ok(items);
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

    @PostMapping("/additem")
    public ResponseEntity<?> addItemToCart(
            @RequestParam int userId,
            @RequestParam int productId,
            @RequestParam int quantity) {

        if (quantity <= 0) {
            return ResponseEntity.badRequest().body("Số lượng phải lớn hơn 0");
        }

        Optional<User> userOpt = userService.getUserById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Không tìm thấy người dùng với ID: " + userId);
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(404).body("Không tìm thấy sản phẩm với ID: " + productId);
        }

        cartService.addItemToCart(userOpt.get(), product, quantity);
        return ResponseEntity.ok("Thêm sản phẩm vào giỏ hàng thành công");
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @DeleteMapping("/removeitem")
    public ResponseEntity<?> removeItemFromCart(
            @RequestParam int userId,
            @RequestParam int productId) {

        return userService.getUserById(userId).map(user -> {
            cartService.removeItemFromCart(user, productId);
            return ResponseEntity.ok("Xóa sản phẩm khỏi giỏ hàng thành công");
        }).orElseGet(() -> ResponseEntity.status(404).body("Không tìm thấy người dùng với ID: " + userId));
    }

    // Xóa toàn bộ sản phẩm trong giỏ hàng của user
    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestParam int userId) {
        return userService.getUserById(userId).map(user -> {
            cartService.clearCart(user);
            return ResponseEntity.ok("Đã xóa toàn bộ sản phẩm trong giỏ hàng");
        }).orElseGet(() -> ResponseEntity.status(404).body("Không tìm thấy người dùng với ID: " + userId));
    }
}
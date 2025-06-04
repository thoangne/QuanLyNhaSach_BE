package com.example.quanlynhasach.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {

    @EmbeddedId
    private CartItemKey id = new CartItemKey();

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;

        if (cart.getId() == 0 || product.getId() == 0) {
            throw new IllegalArgumentException("Cart or Product ID is null");
        }

        this.id = new CartItemKey(cart.getId(), product.getId());
    }

    // Getters and Setters

    public CartItemKey getId() {
        return id;
    }

    public void setId(CartItemKey id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getBook() {
        return product;
    }

    public void setBook(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
package com.example.quanlynhasach.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {

    @EmbeddedId
    private CartItemKey id = new CartItemKey();

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "CartId")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Integer quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
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
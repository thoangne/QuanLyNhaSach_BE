package com.example.quanlynhasach.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemKey implements Serializable {

    private int cartId;
    private int productId;

    public CartItemKey() {
    }

    public CartItemKey(int cartId, int productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    // Getters, Setters, equals() and hashCode()

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CartItemKey))
            return false;
        CartItemKey that = (CartItemKey) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }
}
package com.example.quanlynhasach.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CartItemKey implements Serializable {

    private UUID cartId;
    private UUID productId;

    public CartItemKey() {
    }

    public CartItemKey(UUID cartId, UUID productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    // Getters, Setters, equals() and hashCode()

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
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
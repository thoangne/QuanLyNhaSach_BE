package com.example.quanlynhasach.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class OrderDetailId implements Serializable {

    private UUID orderId;
    private UUID productId;

    // Constructors
    public OrderDetailId() {
    }

    public OrderDetailId(UUID orderId, UUID productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    // Equals & HashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof OrderDetailId))
            return false;
        OrderDetailId other = (OrderDetailId) obj;
        return orderId.equals(other.orderId) && productId.equals(other.productId);
    }

    @Override
    public int hashCode() {
        return orderId.hashCode() + productId.hashCode();
    }
}
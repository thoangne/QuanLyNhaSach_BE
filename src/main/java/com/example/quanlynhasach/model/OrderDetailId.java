package com.example.quanlynhasach.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailId implements Serializable {

    private int orderId;
    private int productId;

    // Constructors
    public OrderDetailId() {
    }

    public OrderDetailId(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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
        return this.orderId == other.orderId && this.productId == other.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
package com.example.quanlynhasach.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false, columnDefinition = "BINARY(36)")
    private Order order;

    @Column(nullable = false)
    private String method;

    private String status;
    private LocalDateTime paidAt;

    // Constructors
    public Payment() {
    }

    public Payment(Order order, String method, String status, LocalDateTime paidAt) {
        this.order = order;
        this.method = method;
        this.status = status;
        this.paidAt = paidAt;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return method;
    }

    public void setPaymentMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paidAt;
    }

    public void setPaymentDate(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }
}
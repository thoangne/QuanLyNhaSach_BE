package com.example.quanlynhasach.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false, columnDefinition = "BINARY(36)")
    private User user;

    private LocalDateTime createAt;

    public Cart() {
    }

    public Cart(User user, LocalDateTime createAt) {
        this.user = user;
        this.createAt = createAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
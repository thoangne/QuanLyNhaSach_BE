package com.example.quanlynhasach.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "compose")
@IdClass(ComposeId.class)
public class Compose {

    @Id
    @Column(columnDefinition = "BINARY(36)")
    private UUID productId;

    @Id
    @Column(columnDefinition = "BINARY(36)")
    private UUID authorId;

    // Constructors
    public Compose() {
    }

    public Compose(UUID productId, UUID authorId) {
        this.productId = productId;
        this.authorId = authorId;
    }

    // Getters and Setters
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
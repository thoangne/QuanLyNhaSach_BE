package com.example.quanlynhasach.model;

import jakarta.persistence.*;

@Entity
@Table(name = "compose")
@IdClass(ComposeId.class)
public class Compose {

    @Id
    private int productId;

    @Id
    private int authorId;

    // Constructors
    public Compose() {
    }

    public Compose(int productId, int authorId) {
        this.productId = productId;
        this.authorId = authorId;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
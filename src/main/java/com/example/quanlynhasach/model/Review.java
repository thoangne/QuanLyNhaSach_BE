package com.example.quanlynhasach.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false, columnDefinition = "BINARY(36)")
    private User user;

    @ManyToOne
    @JoinColumn(name = "productid", nullable = false, columnDefinition = "BINARY(36)")
    private Product product;

    @Column(nullable = false)
    private int rating;

    private String comment;

    // Constructors
    public Review() {
    }

    public Review(User user, Product product, int rating, String comment) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
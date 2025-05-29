package com.example.quanlynhasach.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(36)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String address;
    private String contact;

    // Constructors
    public Publisher() {
    }

    public Publisher(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
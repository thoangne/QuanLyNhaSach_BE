package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Publisher findByname(String name);
}
package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByname(String name);
}
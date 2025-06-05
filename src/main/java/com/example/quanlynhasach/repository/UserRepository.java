package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByname(String name);

    User findByEmailAndPassword(String email, String password);
}
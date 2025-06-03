package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(int productId);

    List<Review> findByUserId(int userId);

    void deleteByProductId(int productId);

}
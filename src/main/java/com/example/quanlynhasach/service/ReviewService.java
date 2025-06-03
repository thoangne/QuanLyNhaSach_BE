package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getAllReviews();

    List<Review> getReviewsByProductId(int productId);

    Review getReviewById(int id);

    boolean deleteReview(int id);

    boolean deleteReviewsByProductId(int productId);

}
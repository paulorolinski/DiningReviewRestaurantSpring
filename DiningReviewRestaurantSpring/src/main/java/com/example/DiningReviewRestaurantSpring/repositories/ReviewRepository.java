package com.example.DiningReviewRestaurantSpring.repositories;

import com.example.DiningReviewRestaurantSpring.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

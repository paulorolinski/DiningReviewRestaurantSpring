package com.example.DiningReviewRestaurantSpring.repositories;

import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

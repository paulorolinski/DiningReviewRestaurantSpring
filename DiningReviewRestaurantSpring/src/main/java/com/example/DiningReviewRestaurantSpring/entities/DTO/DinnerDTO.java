package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.entities.Review;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DinnerDTO(Long id, @NotNull String name, @NotNull Double price, @NotNull String imgUrl, List<Review> reviews, @NotNull Restaurant restaurant) {
}

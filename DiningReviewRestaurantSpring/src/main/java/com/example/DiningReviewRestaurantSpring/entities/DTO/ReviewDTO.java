package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import com.example.DiningReviewRestaurantSpring.entities.User;
import jakarta.validation.constraints.NotNull;

public record ReviewDTO(Long id, @NotNull String comment, @NotNull Double rating, @NotNull User user, @NotNull Dinner plate) {
}

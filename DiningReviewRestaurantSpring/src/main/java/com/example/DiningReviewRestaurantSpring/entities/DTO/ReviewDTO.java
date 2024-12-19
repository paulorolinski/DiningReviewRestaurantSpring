package com.example.DiningReviewRestaurantSpring.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record ReviewDTO(Long id, @NotNull String comment, @NotNull Double rating) {
}

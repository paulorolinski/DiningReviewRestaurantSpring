package com.example.DiningReviewRestaurantSpring.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record DinnerDTO(Long id, @NotNull String name, @NotNull Double price, @NotNull String imgUrl) {
}

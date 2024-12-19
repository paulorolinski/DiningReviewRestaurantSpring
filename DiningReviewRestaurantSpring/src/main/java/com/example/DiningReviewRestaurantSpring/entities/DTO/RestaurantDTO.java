package com.example.DiningReviewRestaurantSpring.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record RestaurantDTO(Long id, @NotNull String name, @NotNull String cep, @NotNull String address, @NotNull String imgUrl) {
}

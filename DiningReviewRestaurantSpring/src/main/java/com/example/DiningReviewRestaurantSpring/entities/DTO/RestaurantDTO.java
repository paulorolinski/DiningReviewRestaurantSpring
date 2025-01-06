package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record RestaurantDTO(Long id, @NotNull String name, @NotNull String cep, @NotNull String address, @NotNull String imgUrl, @NotNull Set<Dinner> plates) {
}

package com.example.DiningReviewRestaurantSpring.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotNull String login, @NotNull String password) {
}

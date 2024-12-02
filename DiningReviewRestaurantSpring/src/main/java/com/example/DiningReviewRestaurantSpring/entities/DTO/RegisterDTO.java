package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String login, @NotNull String password, String email, String phone, UserRole role) {
}

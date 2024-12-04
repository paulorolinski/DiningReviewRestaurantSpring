package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String id, String login, String phone, String email, String password, UserRole role) {
}

package com.example.DiningReviewRestaurantSpring.entities.DTO;
import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record UserDTO(String id, @NotNull String login, @NotNull String phone, @NotNull String email, @NotNull String password, @NotNull UserRole role) {
}

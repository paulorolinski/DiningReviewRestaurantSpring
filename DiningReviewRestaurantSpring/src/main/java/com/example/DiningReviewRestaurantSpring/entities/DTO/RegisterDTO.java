package com.example.DiningReviewRestaurantSpring.entities.DTO;

import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

package com.example.DiningReviewRestaurantSpring.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}

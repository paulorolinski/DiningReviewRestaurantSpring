package com.example.DiningReviewRestaurantSpring.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) { super("Resource not found. id:  " + id);}
}

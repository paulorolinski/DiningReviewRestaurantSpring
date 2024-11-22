package com.example.DiningReviewRestaurantSpring.services.exceptions;

public class ResourceNotFoundUserException extends RuntimeException {
    public ResourceNotFoundUserException(String id) { super("Resource not found. id:  " + id);}
}

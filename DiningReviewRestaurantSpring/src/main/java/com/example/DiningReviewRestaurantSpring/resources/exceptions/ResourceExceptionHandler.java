package com.example.DiningReviewRestaurantSpring.resources.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {
}

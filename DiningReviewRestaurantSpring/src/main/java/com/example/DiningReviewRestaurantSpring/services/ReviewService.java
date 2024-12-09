package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.ReviewDTO;
import com.example.DiningReviewRestaurantSpring.entities.Review;
import com.example.DiningReviewRestaurantSpring.repositories.ReviewRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public List<ReviewDTO> findAll() {
        List<Review> reviews = repository.findAll();
        return reviews.stream().map(this::toReviewDTO).collect(Collectors.toList());
    }

    public ReviewDTO findById(Long id) {
        Optional<Review> obj = repository.findById(id);
        Review review = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return toReviewDTO(review);
    }

    public ReviewDTO insert(Review obj) {
        repository.save(obj);
        return toReviewDTO(obj);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ReviewDTO update(Long id, ReviewDTO obj) {
        if (repository.existsById(id)) {
            Review entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toReviewDTO(entity);
        }
        throw new ResourceNotFoundException(id);
    }

    public void updateData(Review entity, ReviewDTO obj) {
        entity.setComment(obj.comment());
        entity.setRating(obj.rating());
    }

    ReviewDTO toReviewDTO(Review review) {
        return new ReviewDTO(review.getId(), review.getComment(), review.getRating());
    }
}

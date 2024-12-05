package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.ReviewDTO;
import com.example.DiningReviewRestaurantSpring.entities.Review;
import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.repositories.ReviewRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    ReviewService reviewService;

    Review review;

    ReviewDTO reviewDTO;

    @BeforeEach
    void setUp() {
        review = new Review(1L, "Comentário 1", 3.0, null,  null);
        reviewDTO = new ReviewDTO(1L, "Comentário 2", 5.0);
    }

    @Test
    @DisplayName("Should return all reviews")
    void findAll() {
        when(reviewRepository.findAll()).thenReturn(Collections.singletonList(review));

        List<ReviewDTO> result = reviewService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Comentário 1", result.get(0).comment());
    }

    @Test
    @DisplayName("Should find a Review by ID")
    void findById() {
        when(reviewRepository.findById(anyLong())).thenReturn(Optional.of(review));

        ReviewDTO result = reviewService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals(1L, review.getId());
    }

    @Test
    @DisplayName("Should save Review")
    void insert() {
        when(reviewRepository.save(any(Review.class))).thenReturn(review);

        ReviewDTO result = reviewService.insert(review);

        assertNotNull(result);
        assertEquals(1L, result.id());
    }

    @Test
    @DisplayName("Should delete Review when exists")
    void delete() {
        when(reviewRepository.existsById(anyLong())).thenReturn(true);

        assertDoesNotThrow(() -> reviewService.delete(1L));
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw a exception when review not found")
    void ExceptionWhenFindById() {
        when(reviewRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> reviewService.delete(1L));
    }

    @Test
    @DisplayName("Should throw an DBexception")
    void ExceptionDB() {
        when(reviewRepository.existsById(anyLong())).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(reviewRepository).deleteById(anyLong());

        assertThrows(DatabaseException.class, () -> reviewService.delete(1L));
    }

    @Test
    @DisplayName("Should update Review and Return ReviewDTO")
    void update() {
        when(reviewRepository.existsById(anyLong())).thenReturn(true);
        when(reviewRepository.getReferenceById(anyLong())).thenReturn(review);

        ReviewDTO result = reviewService.update(1L, reviewDTO);

        assertNotNull(result);
        assertEquals("Comentário 2", result.comment());
        assertEquals(5.0, result.rating());
    }

    @Test
    @DisplayName("Should update review fields")
    void updateData() {
        reviewService.updateData(review, reviewDTO);
        assertEquals("Comentário 2", review.getComment());
        assertEquals(5.0, review.getRating());
    }

    @Test
    @DisplayName("Should convert Review to ReviewDTO correctly")
    void toReviewDTO_ShouldConvertReviewToReviewDTO() {
        ReviewDTO reviewDTO = reviewService.toReviewDTO(review);
        assertNotNull(reviewDTO);
        assertEquals(review.getId(), reviewDTO.id());
        assertEquals(review.getComment(), reviewDTO.comment());
        assertEquals(review.getRating(), reviewDTO.rating());
    }
}
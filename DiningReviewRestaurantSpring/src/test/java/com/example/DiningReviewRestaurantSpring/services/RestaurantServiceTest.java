package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.RestaurantDTO;
import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.repositories.RestaurantRepository;
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
class RestaurantServiceTest {
    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    RestaurantService restaurantService;

    Restaurant restaurant;

    RestaurantDTO restaurantDTO;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(1L, "Burguer King", "89221-120", "Rua teste", "http://", null);
        restaurantDTO = new RestaurantDTO(1L, "newName", "newCep", "newAddress", "newImgUrl");
    }

    @Test
    @DisplayName("Should return all restaurants")
    void findAll() {
        when(restaurantRepository.findAll()).thenReturn(Collections.singletonList(restaurant));

        List<RestaurantDTO> result = restaurantService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Burguer King", result.get(0).name());
    }

    @Test
    @DisplayName("Should find a Restaurant by ID")
    void findById() {
        when(restaurantRepository.findById(anyLong())).thenReturn(Optional.of(restaurant));

        RestaurantDTO result = restaurantService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals(1L, restaurant.getId());
    }

    @Test
    @DisplayName("Should save Restaurant")
    void insert() {
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        RestaurantDTO result = restaurantService.insert(restaurant);

        assertNotNull(result);
        assertEquals(1L, result.id());
    }

    @Test
    @DisplayName("Should delete Restaurant when exists")
    void delete() {
        when(restaurantRepository.existsById(anyLong())).thenReturn(true);

        assertDoesNotThrow(() -> restaurantService.delete(1L));
        verify(restaurantRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw a exception when restaurant not found")
    void ExceptionWhenFindById() {
        when(restaurantRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> restaurantService.delete(1L));
    }

    @Test
    @DisplayName("Should throw an DBexception")
    void ExceptionDB() {
        when(restaurantRepository.existsById(anyLong())).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(restaurantRepository).deleteById(anyLong());

        assertThrows(DatabaseException.class, () -> restaurantService.delete(1L));
    }

    @Test
    @DisplayName("Should throw a exception when review not found in update")
    void ExceptionWhenUpdate() {
        when(restaurantRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> restaurantService.update(1L, restaurantDTO));
    }

    @Test
    @DisplayName("Should update Restaurant and Return RestaurantDTO")
    void update() {
        when(restaurantRepository.existsById(anyLong())).thenReturn(true);
        when(restaurantRepository.getReferenceById(anyLong())).thenReturn(restaurant);

        RestaurantDTO result = restaurantService.update(1L, restaurantDTO);

        assertNotNull(result);
        assertEquals("newName", result.name());
        assertEquals("newCep", result.cep());
        assertEquals("newAddress", result.address());
        assertEquals("newImgUrl", result.imgUrl());
    }

    @Test
    @DisplayName("Should update restaurant fields")
    void updateData() {
        restaurantService.updateData(restaurant, restaurantDTO);
        assertEquals("newName", restaurant.getName());
        assertEquals("newCep", restaurant.getCep());
        assertEquals("newAddress", restaurant.getAddress());
        assertEquals("newImgUrl", restaurant.getImgUrl());
    }

    @Test
    @DisplayName("Should convert Restaurant to RestaurantDTO correctly")
    void toRestaurantDTO_ShouldConvertRestaurantToRestaurantDTO() {
        RestaurantDTO restaurantDTO = restaurantService.toRestaurantDTO(restaurant);
        assertNotNull(restaurantDTO);
        assertEquals(restaurant.getId(), restaurantDTO.id());
        assertEquals(restaurant.getName(), restaurantDTO.name());
        assertEquals(restaurant.getCep(), restaurantDTO.cep());
        assertEquals(restaurant.getAddress(), restaurantDTO.address());
        assertEquals(restaurant.getImgUrl(), restaurantDTO.imgUrl());
    }
}
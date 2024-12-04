package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.UserDTO;
import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    User user, user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User("login1", "password1", "email1", "phone1", UserRole.USER);
        user.setId("1");
    }


    @Test
    @DisplayName("Should return all users")
    void findAll() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<UserDTO> result = userService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("login1", result.get(0).login());
    }

    @Test
    void findById() {
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));

        UserDTO result = userService.findById("1");

        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("1", user.getId());
    }

    @Test
    void insert() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO result = userService.insert(user);

        assertNotNull(result);
        assertEquals("1", result.id());
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void updateData() {
    }
}
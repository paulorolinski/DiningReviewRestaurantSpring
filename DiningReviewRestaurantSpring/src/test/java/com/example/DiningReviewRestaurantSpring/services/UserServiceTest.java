package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.UserDTO;
import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundUserException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    User user;

    UserDTO userDTO;

    @Disabled
    @BeforeEach
    void setUp() {
        user = new User("login1", "password1", "email1", "phone1", UserRole.USER);
        user.setId("1");
        userDTO = new UserDTO("1", "newLogin", "newPhone", "newEmail", "newPassword", UserRole.USER);
    }

    @Disabled
    @Test
    @DisplayName("Should return all users")
    void findAll() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<UserDTO> result = userService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("login1", result.get(0).login());
    }

    @Disabled
    @Test
    @DisplayName("Should find a User by ID")
    void findById() {
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));

        UserDTO result = userService.findById("1");

        assertNotNull(result);
        assertEquals("1", result.id());
        assertEquals("1", user.getId());
    }

    @Disabled
    @Test
    @DisplayName("Should save User")
    void insert() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO result = userService.insert(user);

        assertNotNull(result);
        assertEquals("1", result.id());
    }

    @Disabled
    @Test
    @DisplayName("Should delete User when exists")
    void delete() {
        when(userRepository.existsById(anyString())).thenReturn(true);

        assertDoesNotThrow(() -> userService.delete("1"));
        verify(userRepository, times(1)).deleteById("1");
    }

    @Disabled
    @Test
    @DisplayName("Should throw a exception when user not found")
    void ExceptionWhenFindById() {
        when(userRepository.existsById(anyString())).thenReturn(false);

        assertThrows(ResourceNotFoundUserException.class, () -> userService.delete("1"));
    }

    @Disabled
    @Test
    @DisplayName("Should throw an DBexception")
    void ExceptionDB() {
        when(userRepository.existsById(anyString())).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(userRepository).deleteById(anyString());

        assertThrows(DatabaseException.class, () -> userService.delete("1"));
    }

    @Disabled
    @Test
    @DisplayName("Should throw a exception when review not found in update")
    void ExceptionWhenUpdate() {
        when(userRepository.existsById(anyString())).thenReturn(false);

        assertThrows(ResourceNotFoundUserException.class, () -> userService.update("1", userDTO));
    }

    @Disabled
    @Test
    @DisplayName("Should update User and Return UserDTO")
    void update() {
        when(userRepository.existsById(anyString())).thenReturn(true);
        when(userRepository.getReferenceById(anyString())).thenReturn(user);

        UserDTO result = userService.update("1", userDTO);

        assertNotNull(result);
        assertEquals("newLogin", result.login());
        assertEquals("newPhone", result.phone());
        assertEquals("newEmail", result.email());
        assertEquals(UserRole.USER, result.role());
    }

    @Disabled
    @Test
    @DisplayName("Should update user fields")
    void updateData() {
        userService.updateData(user, userDTO);
        assertEquals("newLogin", user.getLogin());
        assertEquals("newPhone", user.getPhone());
        assertEquals("newEmail", user.getEmail());
        assertEquals(UserRole.USER, user.getRole());
    }
}
package com.example.DiningReviewRestaurantSpring.services;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.DiningReviewRestaurantSpring.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    @Mock
    private User mockUser;

    @BeforeEach
    @Disabled
    void setUp() {
        String secret = "mySecretKey";
        ReflectionTestUtils.setField(tokenService, "secret", secret);
        lenient().when(mockUser.getLogin()).thenReturn("testUser");
    }

    @Test
    @DisplayName("Should generate a valid token")
    @Disabled
    void generateToken_ShouldReturnValidToken() {
        String token = tokenService.generateToken(mockUser);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    @DisplayName("Should throw RuntimeException when JWT creation fails")
    @Disabled
    void generateToken_ShouldThrowExceptionWhenJWTCreationFails() {
        doThrow(JWTCreationException.class).when(mockUser).getLogin();

        assertThrows(RuntimeException.class, () -> tokenService.generateToken(mockUser));
    }

    @Test
    @DisplayName("Should validate a valid token")
    @Disabled
    void validateToken_ShouldReturnSubjectWhenValid() {
        String token = tokenService.generateToken(mockUser);
        String subject = tokenService.validateToken(token);
        assertEquals("testUser", subject);
    }

    @Test
    @DisplayName("Should throw RuntimeException when JWT validation fails")
    @Disabled
    void validateToken_ShouldThrowExceptionWhenInvalidToken() {
        String invalidToken = "invalidToken";
        assertThrows(RuntimeException.class, () -> tokenService.validateToken(invalidToken));
    }
}
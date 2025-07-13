// package com.example.DiningReviewRestaurantSpring.services;

// import com.example.DiningReviewRestaurantSpring.entities.User;
// import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.when;

// @ExtendWith(MockitoExtension.class)
// class AuthorizathionServiceTest {

//     @InjectMocks
//     private AuthorizathionService authorizathionService;

//     @Mock
//     private UserRepository userRepository;

//     User mockUser;

//     @Disabled
//     @BeforeEach
//     void setUp() {
//         mockUser = new User();
//         mockUser.setLogin("testUser");
//         mockUser.setPassword("testPassword");
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should load an User by his Username")
//     void loadUserByUsername_ShouldReturnUserDetails() {
//         when(userRepository.findByLogin(anyString())).thenReturn(mockUser);

//         UserDetails userDetails = authorizathionService.loadUserByUsername("testUser");

//         assertNotNull(userDetails);
//         assertEquals(mockUser.getLogin(), userDetails.getUsername());
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should throw an UserNameNotFoundException when User not found")
//     void loadUserByUsername_ShouldThrowExceptionWhenUserNotFound() {
//         when(userRepository.findByLogin(anyString())).thenReturn(null);

//         assertThrows(UsernameNotFoundException.class, () -> authorizathionService.loadUserByUsername("nonExistingUser"));
//     }
// }
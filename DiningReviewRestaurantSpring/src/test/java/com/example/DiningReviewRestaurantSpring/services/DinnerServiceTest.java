// package com.example.DiningReviewRestaurantSpring.services;

// import com.example.DiningReviewRestaurantSpring.entities.DTO.DinnerDTO;
// import com.example.DiningReviewRestaurantSpring.entities.Dinner;
// import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
// import com.example.DiningReviewRestaurantSpring.repositories.DinnerRepository;
// import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
// import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
// import org.junit.jupiter.api.*;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.dao.DataIntegrityViolationException;
// import java.util.*;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class)
// class DinnerServiceTest {
//     @Mock
//     DinnerRepository dinnerRepository;

//     @InjectMocks
//     DinnerService dinnerService;

//     Dinner dinner;

//     DinnerDTO dinnerDTO;

//     @Disabled
//     @BeforeEach
//     void setUp() {
//         dinner = new Dinner(1L, "Burguer King", 20.2, "Rua teste", null, null);
//         dinnerDTO = new DinnerDTO(1L, "newName", 25.7, "newImgUrl");
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should return all dinners")
//     void findAll() {
//         when(dinnerRepository.findAll()).thenReturn(Collections.singletonList(dinner));

//         List<DinnerDTO> result = dinnerService.findAll();

//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals("Burguer King", result.get(0).name());
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should find a Dinner by ID")
//     void findById() {
//         when(dinnerRepository.findById(anyLong())).thenReturn(Optional.of(dinner));

//         DinnerDTO result = dinnerService.findById(1L);

//         assertNotNull(result);
//         assertEquals(1L, result.id());
//         assertEquals(1L, dinner.getId());
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should save Dinner")
//     void insert() {
//         when(dinnerRepository.save(any(Dinner.class))).thenReturn(dinner);

//         DinnerDTO result = dinnerService.insert(dinner);

//         assertNotNull(result);
//         assertEquals(1L, result.id());
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should delete Dinner when exists")
//     void delete() {
//         when(dinnerRepository.existsById(anyLong())).thenReturn(true);

//         assertDoesNotThrow(() -> dinnerService.delete(1L));
//         verify(dinnerRepository, times(1)).deleteById(1L);
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should throw a exception when dinner not found")
//     void ExceptionWhenFindById() {
//         when(dinnerRepository.existsById(anyLong())).thenReturn(false);

//         assertThrows(ResourceNotFoundException.class, () -> dinnerService.delete(1L));
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should throw an DBexception")
//     void ExceptionDB() {
//         when(dinnerRepository.existsById(anyLong())).thenReturn(true);
//         doThrow(DataIntegrityViolationException.class).when(dinnerRepository).deleteById(anyLong());

//         assertThrows(DatabaseException.class, () -> dinnerService.delete(1L));
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should throw a exception when review not found in update")
//     void ExceptionWhenUpdate() {
//         when(dinnerRepository.existsById(anyLong())).thenReturn(false);

//         assertThrows(ResourceNotFoundException.class, () -> dinnerService.update(1L, dinnerDTO));
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should update Dinner and Return DinnerDTO")
//     void update() {
//         when(dinnerRepository.existsById(anyLong())).thenReturn(true);
//         when(dinnerRepository.getReferenceById(anyLong())).thenReturn(dinner);

//         DinnerDTO result = dinnerService.update(1L, dinnerDTO);

//         assertNotNull(result);
//         assertEquals("newName", result.name());
//         assertEquals(25.7, result.price());
//         assertEquals("newImgUrl", result.imgUrl());
//     }

//     @Disabled
//     @Test
//     @DisplayName("Should update dinner fields")
//     void updateData() {
//         dinnerService.updateData(dinner, dinnerDTO);
//         assertEquals("newName", dinner.getName());
//         assertEquals(25.7, dinner.getPrice());
//         assertEquals("newImgUrl", dinner.getImgUrl());
//     }
// }
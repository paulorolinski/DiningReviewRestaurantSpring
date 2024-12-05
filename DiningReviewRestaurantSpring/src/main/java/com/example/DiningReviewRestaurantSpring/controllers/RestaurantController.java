package com.example.DiningReviewRestaurantSpring.controllers;

import com.example.DiningReviewRestaurantSpring.entities.DTO.RestaurantDTO;
import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> findAll() {
        List<RestaurantDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantDTO> findById(@PathVariable Long id) {
        RestaurantDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> insert(@RequestBody Restaurant obj) {
        RestaurantDTO restaurantDTO = service.insert(obj);
        return ResponseEntity.ok().body(restaurantDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RestaurantDTO> update(@PathVariable Long id, @RequestBody RestaurantDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

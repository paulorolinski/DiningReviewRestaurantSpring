package com.example.DiningReviewRestaurantSpring.controllers;

import com.example.DiningReviewRestaurantSpring.entities.DTO.ReviewDTO;
import com.example.DiningReviewRestaurantSpring.entities.Review;
import com.example.DiningReviewRestaurantSpring.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    ReviewService service;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> findAll() {
        List<ReviewDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
        ReviewDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> insert(@RequestBody Review obj) {
        ReviewDTO reviewDTO = service.insert(obj);
        return ResponseEntity.ok().body(reviewDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReviewDTO> update(@PathVariable Long id, @RequestBody ReviewDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

package com.example.DiningReviewRestaurantSpring.resources;

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
    public ResponseEntity<List<Review>> findAll() {
        List<Review> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        Review obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Review> insert(@RequestBody Review obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

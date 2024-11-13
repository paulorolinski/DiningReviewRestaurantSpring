package com.example.DiningReviewRestaurantSpring.resources;

import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DiningReviewRestaurantSpring.services.DinnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dinners")
public class DinnerController {

    @Autowired
    DinnerService service;

    @GetMapping
    public ResponseEntity<List<Dinner>> findAll() {
        List<Dinner> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dinner> findById(@PathVariable Long id) {
        Dinner obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Dinner> insert(@RequestBody Dinner obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Dinner> update(@PathVariable Long id, @RequestBody Dinner obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

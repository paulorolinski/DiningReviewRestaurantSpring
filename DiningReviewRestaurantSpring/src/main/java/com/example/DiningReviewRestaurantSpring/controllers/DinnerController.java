package com.example.DiningReviewRestaurantSpring.controllers;

import com.example.DiningReviewRestaurantSpring.entities.DTO.DinnerDTO;
import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DiningReviewRestaurantSpring.services.DinnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dinners")
public class DinnerController {

    @Autowired
    DinnerService service;

    @GetMapping
    public ResponseEntity<List<DinnerDTO>> findAll() {
        List<DinnerDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DinnerDTO> findById(@PathVariable Long id) {
        DinnerDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DinnerDTO insert(@Valid @RequestBody DinnerDTO obj) {
        return service.insert(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DinnerDTO update(@PathVariable Long id, @Valid @RequestBody DinnerDTO obj) {
        return service.update(id, obj);
    }

}

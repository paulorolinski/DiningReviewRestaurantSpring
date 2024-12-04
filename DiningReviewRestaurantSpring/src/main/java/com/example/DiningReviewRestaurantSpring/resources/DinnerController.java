package com.example.DiningReviewRestaurantSpring.resources;

import com.example.DiningReviewRestaurantSpring.entities.DTO.DinnerDTO;
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
    public ResponseEntity<DinnerDTO> insert(@RequestBody Dinner obj) {
        DinnerDTO dinnerDTO = service.insert(obj);
        return ResponseEntity.ok().body(dinnerDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DinnerDTO> update(@PathVariable Long id, @RequestBody DinnerDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

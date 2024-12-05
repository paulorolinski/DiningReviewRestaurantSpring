package com.example.DiningReviewRestaurantSpring.controllers;

import com.example.DiningReviewRestaurantSpring.entities.DTO.UserDTO;
import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody User obj) {
        UserDTO userDTO = service.insert(obj);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO obj) {
        UserDTO userDTO = service.update(id, obj);
        return ResponseEntity.ok().body(userDTO);
    }

}

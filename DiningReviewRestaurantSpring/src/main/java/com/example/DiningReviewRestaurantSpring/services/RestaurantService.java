package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.repositories.RestaurantRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant findById(Long id) {
        Optional<Restaurant> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Restaurant insert(Restaurant obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            if(repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Restaurant update(Long id, Restaurant obj) {
        if (repository.existsById(id)) {
            Restaurant entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        return null;
    }

    public void updateData(Restaurant entity, Restaurant obj) {
        entity.setName(obj.getName());
        entity.setCep(obj.getCep());
        entity.setAddress((obj.getAddress()));
        entity.setImgUrl(obj.getImgUrl());
    }
}

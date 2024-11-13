package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import com.example.DiningReviewRestaurantSpring.repositories.DinnerRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DinnerService {

    @Autowired
    private DinnerRepository repository;

    public List<Dinner> findAll() {
        return repository.findAll();
    }

    public Dinner findById(Long id) {
        Optional<Dinner> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Dinner insert(Dinner obj) {
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

    public Dinner update(Long id, Dinner obj) {
        if (repository.existsById(id)) {
            Dinner entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        return null;
    }

    public void updateData(Dinner entity, Dinner obj) {
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}

package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.DinnerDTO;
import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import com.example.DiningReviewRestaurantSpring.repositories.DinnerRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DinnerService {

    @Autowired
    private DinnerRepository repository;

    public List<DinnerDTO> findAll() {
        List<Dinner> dinners = repository.findAll();
        return dinners.stream().map(this::toDinnerDTO).collect(Collectors.toList());
    }

    public DinnerDTO findById(Long id) {
        Optional<Dinner> obj = repository.findById(id);
        Dinner dinner = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return toDinnerDTO(dinner);
    }

    public DinnerDTO insert(Dinner obj) {
        repository.save(obj);
        return toDinnerDTO(obj);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public DinnerDTO update(Long id, DinnerDTO obj) {
        if (repository.existsById(id)) {
            Dinner entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toDinnerDTO(entity);
        }
        throw new ResourceNotFoundException(id);
    }

    public void updateData(Dinner entity, DinnerDTO obj) {
        entity.setName(obj.name());
        entity.setPrice(obj.price());
        entity.setImgUrl(obj.imgUrl());
    }

    public DinnerDTO toDinnerDTO(Dinner dinner) {
        return new DinnerDTO(dinner.getId(), dinner.getName(), dinner.getPrice(), dinner.getImgUrl());
    }
}

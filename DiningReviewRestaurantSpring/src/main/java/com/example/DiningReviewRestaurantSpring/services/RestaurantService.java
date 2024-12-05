package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.RestaurantDTO;
import com.example.DiningReviewRestaurantSpring.entities.Restaurant;
import com.example.DiningReviewRestaurantSpring.repositories.RestaurantRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<RestaurantDTO> findAll() {
        List<Restaurant> restaurant = repository.findAll();
        return restaurant.stream().map(this::toRestaurantDTO).collect(Collectors.toList());
    }

    public RestaurantDTO findById(Long id) {
        Optional<Restaurant> obj = repository.findById(id);
        Restaurant restaurant = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return toRestaurantDTO(restaurant);
    }

    public RestaurantDTO insert(Restaurant obj) {
        repository.save(obj);
        return toRestaurantDTO(obj);
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

    public RestaurantDTO update(Long id, RestaurantDTO obj) {
        if (repository.existsById(id)) {
            Restaurant entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toRestaurantDTO(entity);
        }
        return null;
    }

    public void updateData(Restaurant entity, RestaurantDTO obj) {
        entity.setName(obj.name());
        entity.setCep(obj.cep());
        entity.setAddress((obj.address()));
        entity.setImgUrl(obj.imgUrl());
    }

    RestaurantDTO toRestaurantDTO(Restaurant restaurant) {
        return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getCep(), restaurant.getAddress(), restaurant.getImgUrl());
    }
}

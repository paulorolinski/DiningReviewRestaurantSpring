package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundUserException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(String id) {
        try {
            if(repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundUserException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(String id, User obj) {
        if (repository.existsById(id)) {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        return null;
    }

    public void updateData(User entity, User obj) {
        entity.setLogin(obj.getLogin());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setRole(obj.getRole());
    }
}

package com.example.DiningReviewRestaurantSpring.services;

import com.example.DiningReviewRestaurantSpring.entities.DTO.UserDTO;
import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
import com.example.DiningReviewRestaurantSpring.services.exceptions.DatabaseException;
import com.example.DiningReviewRestaurantSpring.services.exceptions.ResourceNotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(this::toUserDTO).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        Optional<User> obj = repository.findById(id);
        User user = obj.orElseThrow(() -> new ResourceNotFoundUserException(id));
        return toUserDTO(user);
    }

    public UserDTO insert(UserDTO obj) {
        User user = toUser(obj);
        repository.save(user);
        return toUserDTO(user);
    }

    public void delete(String id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundUserException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserDTO update(String id, UserDTO obj) {
        if (repository.existsById(id)) {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toUserDTO(entity);
        }
        throw new ResourceNotFoundUserException(id);
    }

    public void updateData(User entity, UserDTO obj) {
        entity.setLogin(obj.login());
        entity.setEmail(obj.email());
        entity.setPhone(obj.phone());
        entity.setRole(obj.role());
    }

    private UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getLogin(), user.getPhone(), user.getEmail(), user.getPassword(), user.getRole());
    }

    private User toUser(UserDTO userDTO) {
        return new User(userDTO.login(), userDTO.password(), userDTO.email(), userDTO.phone(), userDTO.role());
    }
}

package com.example.DiningReviewRestaurantSpring.config;

import com.example.DiningReviewRestaurantSpring.entities.User;
import com.example.DiningReviewRestaurantSpring.entities.enums.UserRole;
import com.example.DiningReviewRestaurantSpring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User(null, "123123dasdasdasdasd", "Paulo", "9999", "paulorolinski.ifc@gmail.com", "aaa", UserRole.ADMIN.getRole());
//        userRepository.save(user1);
    }
}

package com.example.DiningReviewRestaurantSpring.repositories;

import com.example.DiningReviewRestaurantSpring.entities.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DinnerRepository extends JpaRepository<Dinner, Long> {

}

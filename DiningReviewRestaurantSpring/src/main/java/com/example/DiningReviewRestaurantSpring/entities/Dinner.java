package com.example.DiningReviewRestaurantSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_dinner")
@Entity(name = "tb_dinner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dinner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "plate")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}

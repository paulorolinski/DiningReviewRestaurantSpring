package com.example.DiningReviewRestaurantSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "tb_restaurant")
@Entity(name = "tb_restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cep;
    private String address;
    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    Set<Dinner> plates = new HashSet<>();
}

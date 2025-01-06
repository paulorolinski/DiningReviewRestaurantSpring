package com.example.DiningReviewRestaurantSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_restaurant")
@Entity(name = "tb_restaurant")
@Getter
@Setter
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

    @JsonIgnoreProperties("restaurant")
    @OneToMany(mappedBy = "restaurant")
    Set<Dinner> plates = new HashSet<>();
}

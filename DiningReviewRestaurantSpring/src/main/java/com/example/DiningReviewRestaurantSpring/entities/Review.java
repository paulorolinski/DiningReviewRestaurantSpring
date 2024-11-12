package com.example.DiningReviewRestaurantSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "tb_review")
@Table(name = "tb_review")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private Double rating;
}

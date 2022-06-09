package com.sparta.spring_deep_assignment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<AnsweredFood> foods;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;


    public FoodOrder(String restaurantName, List<AnsweredFood> answeredFoods, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = answeredFoods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}

package com.sparta.spring_deep_assignment.model;

import com.sparta.spring_deep_assignment.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Long restaurantId, FoodDto requestDto) {
        this.restaurantId = restaurantId;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}

package com.sparta.spring_deep_assignment.repository;

import com.sparta.spring_deep_assignment.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);
}

package com.sparta.spring_deep_assignment.repository;

import com.sparta.spring_deep_assignment.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

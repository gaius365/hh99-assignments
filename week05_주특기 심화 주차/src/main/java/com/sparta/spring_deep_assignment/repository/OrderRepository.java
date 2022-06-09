package com.sparta.spring_deep_assignment.repository;

import com.sparta.spring_deep_assignment.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
}

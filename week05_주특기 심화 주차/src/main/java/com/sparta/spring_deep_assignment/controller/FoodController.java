package com.sparta.spring_deep_assignment.controller;

import com.sparta.spring_deep_assignment.dto.FoodDto;
import com.sparta.spring_deep_assignment.model.Food;
import com.sparta.spring_deep_assignment.repository.FoodRepository;
import com.sparta.spring_deep_assignment.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;
    private final FoodService foodService;

    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foods) {
        foodService.createFood(restaurantId, foods);
    }

    // 메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoods(@PathVariable Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}

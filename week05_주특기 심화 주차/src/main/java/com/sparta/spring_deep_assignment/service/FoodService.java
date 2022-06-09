package com.sparta.spring_deep_assignment.service;

import com.sparta.spring_deep_assignment.dto.FoodDto;
import com.sparta.spring_deep_assignment.model.Food;
import com.sparta.spring_deep_assignment.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public void createFood(Long restaurantId, List<FoodDto> foods) {

        List<Food> existingFoods = foodRepository.findAllByRestaurantId(restaurantId);

        for (int i = 0; i < foods.size(); i++) {
            String name = foods.get(i).getName();
            int price = foods.get(i).getPrice();

            for (int j = 0; j < existingFoods.size(); j++) {
                String existingName = existingFoods.get(j).getName();
                if (Objects.equals(existingName, name)) { // 질문: 왜 "=="을 못 쓸까요?
                    throw new IllegalArgumentException("음식명 중복 에러");
                }
            }

            if (price < 100 || price > 1000000) {
                throw new IllegalArgumentException("가격 범위 에러");
            }

            if (price % 100 != 0) {
                throw new IllegalArgumentException("가격 단위 에러");
            }

            Food food = new Food(restaurantId, foods.get(i));
            foodRepository.save(food);
        }

    }
}

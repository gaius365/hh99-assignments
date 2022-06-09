package com.sparta.spring_deep_assignment.service;

import com.sparta.spring_deep_assignment.dto.OrderDto;
import com.sparta.spring_deep_assignment.dto.OrderedFoodDto;
import com.sparta.spring_deep_assignment.model.AnsweredFood;
import com.sparta.spring_deep_assignment.model.Food;
import com.sparta.spring_deep_assignment.model.FoodOrder;
import com.sparta.spring_deep_assignment.model.Restaurant;
import com.sparta.spring_deep_assignment.repository.FoodRepository;
import com.sparta.spring_deep_assignment.repository.OrderRepository;
import com.sparta.spring_deep_assignment.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;

    public FoodOrder createOrder(OrderDto requestDto) {
        Long restaurantId = requestDto.getRestaurantId();
        List<OrderedFoodDto> orderedFoods = requestDto.getFoods();
        int totalPrice = 0;

        // 음식점 검색
        Restaurant orderedRestaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("식당 ID 에러")
        );
        String restaurantName = orderedRestaurant.getName();
        int minOrderPrice = orderedRestaurant.getMinOrderPrice();
        int deliveryFee = orderedRestaurant.getDeliveryFee();

        // 음식 상세정보 전환 및 저장
        List<AnsweredFood> answeredFoods = new ArrayList<>();

        for (int i = 0; i < orderedFoods.size(); i++) {
            Long foodId = orderedFoods.get(i).getId();
            int quantity = orderedFoods.get(i).getQuantity();

            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("주문 수량 에러");
            }

            Food orderedFood = foodRepository.findById(foodId).orElseThrow(
                    () -> new NullPointerException("음식 ID 에러")
            );
            String name = orderedFood.getName();
            int price = orderedFood.getPrice() * quantity;

            totalPrice += price;

            AnsweredFood answeredFood = AnsweredFood.builder()
                    .name(name)
                    .quantity(quantity)
                    .price(price)
                    .build();

            answeredFoods.add(answeredFood);
        }

        if (totalPrice < minOrderPrice) {
            throw new IllegalArgumentException("최소주문가격 에러");
        }

        totalPrice += deliveryFee;

        System.out.println(restaurantName);
        System.out.println(answeredFoods);
        System.out.println(deliveryFee);
        System.out.println(totalPrice);

        FoodOrder foodOrder = new FoodOrder(restaurantName, answeredFoods, deliveryFee, totalPrice);
        orderRepository.save(foodOrder);
        return foodOrder;
    }
}

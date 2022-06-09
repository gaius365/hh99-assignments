package com.sparta.spring_deep_assignment.service;

import com.sparta.spring_deep_assignment.dto.RestaurantDto;
import com.sparta.spring_deep_assignment.model.Restaurant;
import com.sparta.spring_deep_assignment.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(RestaurantDto requestDto) {
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if(minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("최소주문가격 범위 에러");
        }

        if(minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("최소주문가격 단위 에러");
        }

        if(deliveryFee < 0 || deliveryFee > 10000) {
            throw new IllegalArgumentException("기본배달비 범위 에러");
        }

        if(deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("기본배달비 단위 에러");
        }

        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}

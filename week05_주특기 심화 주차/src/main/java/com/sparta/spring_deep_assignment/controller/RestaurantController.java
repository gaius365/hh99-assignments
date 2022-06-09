package com.sparta.spring_deep_assignment.controller;

import com.sparta.spring_deep_assignment.dto.RestaurantDto;
import com.sparta.spring_deep_assignment.model.Restaurant;
import com.sparta.spring_deep_assignment.repository.RestaurantRepository;
import com.sparta.spring_deep_assignment.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {
        return restaurantService.createRestaurant(requestDto);
    }

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}

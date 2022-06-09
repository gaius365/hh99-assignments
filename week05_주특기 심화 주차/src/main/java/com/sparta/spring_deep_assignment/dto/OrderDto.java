package com.sparta.spring_deep_assignment.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {
    private Long restaurantId;
    private List<OrderedFoodDto> foods;
}

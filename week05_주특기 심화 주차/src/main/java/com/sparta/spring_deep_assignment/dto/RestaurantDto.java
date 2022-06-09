package com.sparta.spring_deep_assignment.dto;

import lombok.Getter;

@Getter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}

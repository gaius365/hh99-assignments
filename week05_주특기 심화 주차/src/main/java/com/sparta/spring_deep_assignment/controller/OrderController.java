package com.sparta.spring_deep_assignment.controller;

import com.sparta.spring_deep_assignment.dto.OrderDto;
import com.sparta.spring_deep_assignment.model.FoodOrder;
import com.sparta.spring_deep_assignment.repository.OrderRepository;
import com.sparta.spring_deep_assignment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    // 주문
    @PostMapping("/order/request")
    public FoodOrder createOrder(@RequestBody OrderDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    // 주문 조회
    @GetMapping("/orders")
    public List<FoodOrder> getOrders() {
        return orderRepository.findAll();
    }
}

package com.unisew.order_service.controllers;

import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.UpdateOrderRequest;
import com.unisew.order_service.response.ResponseObject;
import com.unisew.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<ResponseObject> createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> viewOrder(@PathVariable("id") int orderId) {
        return orderService.viewOrder(orderId);
    }

    @PutMapping("")
    public ResponseEntity<ResponseObject> updateOrder(@RequestBody UpdateOrderRequest request) {
        return orderService.updateOrder(request);
    }



}

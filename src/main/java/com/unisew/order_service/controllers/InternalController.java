package com.unisew.order_service.controllers;

import com.unisew.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/order")
@RequiredArgsConstructor
public class InternalController {

    private final OrderService orderService;

    @GetMapping("")
    public boolean isSafeToBan(@RequestParam(name = "garmentId") int garmentId) {
        return orderService.isSafeToBan(garmentId);
    }
}

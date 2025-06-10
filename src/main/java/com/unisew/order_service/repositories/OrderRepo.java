package com.unisew.order_service.repositories;

import com.unisew.order_service.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}

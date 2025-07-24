package com.unisew.order_service.repositories;

import com.unisew.order_service.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAllBySchoolId(int schoolId);

    List<Order> findAllByGarmentId(int garmentId);
}

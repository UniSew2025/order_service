package com.unisew.order_service.repositories;

import com.unisew.order_service.models.SubOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubOrderRepo extends JpaRepository<SubOrder, Integer> {
}

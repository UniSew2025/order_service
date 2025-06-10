package com.unisew.order_service.repositories;

import com.unisew.order_service.models.SubOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubOrderDetailRepo extends JpaRepository<SubOrderDetail, Integer> {
}

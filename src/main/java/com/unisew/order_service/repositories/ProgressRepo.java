package com.unisew.order_service.repositories;

import com.unisew.order_service.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepo extends JpaRepository<Progress, Integer> {
}

package com.unisew.order_service.repositories;

import com.unisew.order_service.models.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepo extends JpaRepository<Quotation, Integer> {
}

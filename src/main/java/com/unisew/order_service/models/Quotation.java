package com.unisew.order_service.models;

import com.unisew.order_service.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`quotation`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "`early_delivery_date`")
    LocalDate earlyDeliveryDate;

    long price;

    @Column(name = "`order_date`")
    LocalDate orderDate;

    String note;

    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "`garment_id`")
    int garmentId;

    @ManyToOne
    @JoinColumn(name = "`order_id`")
    Order order;
}

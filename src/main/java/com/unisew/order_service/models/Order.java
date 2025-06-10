package com.unisew.order_service.models;

import com.unisew.order_service.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`order`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "`school_deadline`")
    LocalDate schoolDeadline;

    @Column(name = "`garment_deadline`")
    LocalDate garmentDeadline;

    long price;

    @Column(name = "`ship_fee`")
    long shipFee;

    @Column(name = "`service_fee`")
    long serviceFee;

    @Column(name = "`design_fee`")
    long designFee;

    @Column(name = "`order_date`")
    LocalDate orderDate;

    String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "`school_status`")
    Status schoolStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "`garment_status`")
    Status garmentStatus;

    @Column(name = "`school_id`")
    Integer schoolId;

    @Column(name = "`contract_id`")
    Integer contractId;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<SubOrder> subOrders;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<OrderDetail> orderDetails;
}

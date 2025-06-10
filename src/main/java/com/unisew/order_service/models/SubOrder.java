package com.unisew.order_service.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "`sub_order`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "`start_date`")
    LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "`order_id`")
    Order order;

    @OneToMany(mappedBy = "subOrder")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<SubOrderDetail> subOrderDetails;

    @Column(name = "`garment_id`")
    Integer garmentId;

    @Column(name = "contract_id")
    Integer contractId;

    @OneToOne(mappedBy = "subOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Progress progress;
}

package com.unisew.order_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    ORDER_CREATED("created"),
    ORDER_PENDING_QUOTE("pending_quote"),
    ORDER_PAID("paid"),
    ORDER_UNPAID("unpaid"),
    ORDER_FABRIC_PREPARATION("fabric_preparation"),
    ORDER_CUTTING("cutting"),
    ORDER_PATCHING("patching"),
    ORDER_IRONING("ironing"),
    ORDER_QUALITY_CHECK("quality_check"),
    ORDER_PACKAGING("packaging"),
    ORDER_SEWING("sewing"),
    ORDER_EMBROIDERING("embroidering"),
    ORDER_HAND_SEWING("hand_sewing"),
    ORDER_CANCELED("canceled"),
    ORDER_COMPLETED("completed"),
    QUOTATION_ACCEPTED("accepted"),
    QUOTATION_REJECTED("rejected"),;

    private final String value;
}

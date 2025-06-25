package com.unisew.order_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    ORDER_CREATED("created"),
    ORDER_PENDING_QUOTE("pending_quote");

    private final String value;
}

package com.unisew.order_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppConfig {

    SERVICE_FEE(500000);

    private final long fee;
}

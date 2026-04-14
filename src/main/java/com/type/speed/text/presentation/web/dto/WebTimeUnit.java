package com.type.speed.text.presentation.web.dto;

import java.util.concurrent.TimeUnit;

public enum WebTimeUnit {
    SEC,
    MIN;

    public static WebTimeUnit fromDomain(TimeUnit timeUnit) {
        return switch (timeUnit) {
            case SECONDS -> SEC;
            case MINUTES -> MIN;
            default -> throw new IllegalArgumentException("Unsupported time unit for WEB: " + timeUnit);
        };
    }
}
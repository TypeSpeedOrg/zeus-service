package com.type.speed.text.application.dto;

import java.util.concurrent.TimeUnit;

public enum ApplicationTimeUnit {
    SEC,
    MIN;

    public static ApplicationTimeUnit fromDomain(TimeUnit timeUnit) {
        return switch (timeUnit) {
            case SECONDS -> SEC;
            case MINUTES -> MIN;
            default -> throw new IllegalArgumentException("Unsupported time unit: " + timeUnit);
        };
    }
}

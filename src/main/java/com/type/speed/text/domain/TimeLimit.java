package com.type.speed.text.domain;

import java.util.concurrent.TimeUnit;

public class TimeLimit {
    private final int value;
    private final TimeUnit timeUnit;
    private final boolean isDefault;

    public TimeLimit(int value, TimeUnit timeUnit, boolean isDefault) {
        this.value = value;
        this.timeUnit = timeUnit;
        this.isDefault = isDefault;
    }

    public int getValue() {
        return value;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public boolean isDefault() {
        return isDefault;
    }
}

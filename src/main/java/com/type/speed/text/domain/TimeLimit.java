package com.type.speed.text.domain;

import java.util.concurrent.TimeUnit;

public class TimeLimit {
    private final int valueSeconds;
    private final TimeUnit timeUnit;
    private final boolean isDefault;

    public TimeLimit(int valueSeconds, TimeUnit timeUnit, boolean isDefault) {
        if (valueSeconds <= 0) {
            throw new IllegalArgumentException("value must be positive or zero");
        }
        if (TimeUnit.MINUTES != timeUnit && TimeUnit.SECONDS != timeUnit) {
            throw new IllegalArgumentException("timeUnit must be either SECONDS or MINUTES or HOURS");
        }
        this.valueSeconds = valueSeconds;
        this.timeUnit = timeUnit;
        this.isDefault = isDefault;
    }

    public int getValueSeconds() {
        return valueSeconds;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public boolean isDefault() {
        return isDefault;
    }
}

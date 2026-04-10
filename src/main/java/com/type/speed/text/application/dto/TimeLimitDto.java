package com.type.speed.text.application.dto;

public class TimeLimitDto {
    private final int value;
    private final String timeUnit;
    private final boolean isDefault;


    public TimeLimitDto(int value, String timeUnit, boolean isDefault) {
        this.value = value;
        this.timeUnit = timeUnit;
        this.isDefault = isDefault;
    }

    public int getValue() {
        return value;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public boolean isDefault() {
        return isDefault;
    }
}

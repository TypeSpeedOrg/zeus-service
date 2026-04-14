package com.type.speed.text.application.dto;

import java.util.concurrent.TimeUnit;

public record TimeLimitDto(int valueSeconds, TimeUnit timeUnit, boolean isDefault) {}


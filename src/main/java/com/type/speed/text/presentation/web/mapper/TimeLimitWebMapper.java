package com.type.speed.text.presentation.web.mapper;

import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.presentation.web.dto.TimeLimitResponse;
import com.type.speed.text.presentation.web.dto.WebTimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TimeLimitWebMapper {

    public TimeLimitResponse toResponse(TimeLimitDto dto) {
        String displayValue = formatDisplayValue(dto.valueSeconds(), WebTimeUnit.fromDomain(dto.timeUnit()));

        return new TimeLimitResponse(
                dto.valueSeconds(),
                displayValue,
                dto.isDefault()
        );
    }

    private String formatDisplayValue(int totalSeconds, WebTimeUnit timeUnit) {
        if (WebTimeUnit.SEC == timeUnit) {
            return String.format("%d %s", totalSeconds, timeUnit);
        }

        if (WebTimeUnit.MIN == timeUnit) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;

            if (seconds == 0) {
                return String.format("%d %s", minutes, timeUnit);
            }

            return String.format("%d %s %d %s", minutes, timeUnit, seconds, WebTimeUnit.SEC);
        }

        throw new IllegalArgumentException("TimeUnit not supported: " + timeUnit);
    }
}

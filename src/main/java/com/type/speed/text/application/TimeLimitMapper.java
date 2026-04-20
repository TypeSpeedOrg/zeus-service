package com.type.speed.text.application;

import com.type.speed.text.application.dto.ApplicationTimeUnit;
import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.domain.TimeLimit;
import org.springframework.stereotype.Component;

@Component
public class TimeLimitMapper {

    public TimeLimitDto toResponse(TimeLimit timeLimit) {
        int valueSeconds = timeLimit.getValueSeconds();
        String displayValue = formatDisplayValue(valueSeconds, ApplicationTimeUnit.fromDomain(timeLimit.getTimeUnit()));

        return new TimeLimitDto(
                valueSeconds,
                displayValue,
                timeLimit.isDefault()
        );
    }

    private String formatDisplayValue(int totalSeconds, ApplicationTimeUnit timeUnit) {
        if (ApplicationTimeUnit.SEC == timeUnit) {
            return String.format("%d %s", totalSeconds, timeUnit);
        }

        if (ApplicationTimeUnit.MIN == timeUnit) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;

            if (seconds == 0) {
                return String.format("%d %s", minutes, timeUnit);
            }

            return String.format("%d %s %d %s", minutes, timeUnit, seconds, ApplicationTimeUnit.SEC);
        }

        throw new IllegalArgumentException("TimeUnit not supported: " + timeUnit);
    }
}

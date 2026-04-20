package com.type.speed.text.application.dto;

import java.util.List;

public record TextConfigDto(List<TextLanguageDto> textLanguages, List<TimeLimitDto> timeLimits) {
}

package com.type.speed.text.application;

import com.type.speed.text.application.dto.TextConfigDto;
import com.type.speed.text.application.dto.TextLanguageDto;
import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.domain.service.TextLanguageService;
import com.type.speed.text.domain.service.TimeLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextConfigService {
    private static final Logger logger = LoggerFactory.getLogger(TextConfigService.class);
    private final TextLanguageService textLanguageService;
    private final TimeLimitService timeLimitService;
    private final TimeLimitMapper timeLimitMapper;

    public TextConfigService(TextLanguageService textLanguageService, TimeLimitService timeLimitService, TimeLimitMapper timeLimitMapper) {
        this.textLanguageService = textLanguageService;
        this.timeLimitService = timeLimitService;
        this.timeLimitMapper = timeLimitMapper;
    }

    public TextConfigDto getTextConfigs() {
        List<TextLanguageDto> textLanguages = textLanguageService.findAll().stream()
                .map(textLanguage -> new TextLanguageDto(textLanguage.getTitle(), textLanguage.getCode()))
                .toList();
        logger.info("Found {} textLanguages", textLanguages);
        List<TimeLimitDto> timeLimits = timeLimitService.findAll().stream()
                .map(timeLimitMapper::toResponse)
                .toList();
        logger.info("Found {} timeLimits", timeLimits);
        return new TextConfigDto(textLanguages, timeLimits);
    }
}

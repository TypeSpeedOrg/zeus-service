package com.type.speed.text.application;

import com.type.speed.text.application.dto.TextConfigDto;
import com.type.speed.text.application.dto.TextLanguageDto;
import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.application.dto.WordConfigDto;
import com.type.speed.text.domain.SpecialSymbols;
import com.type.speed.text.domain.WordLength;
import com.type.speed.text.domain.service.TextLanguageService;
import com.type.speed.text.domain.service.TimeLimitService;
import com.type.speed.text.domain.service.WordConfigService;
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
    private final WordConfigService wordConfigService;
    private final WordConfigMapper wordConfigMapper;

    public TextConfigService(TextLanguageService textLanguageService, TimeLimitService timeLimitService, TimeLimitMapper timeLimitMapper, WordConfigService wordConfigService, WordConfigMapper wordConfigMapper) {
        this.textLanguageService = textLanguageService;
        this.timeLimitService = timeLimitService;
        this.timeLimitMapper = timeLimitMapper;
        this.wordConfigService = wordConfigService;
        this.wordConfigMapper = wordConfigMapper;
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
        List<WordLength> wordLengths = wordConfigService.findAllWordLength();
        logger.info("Found {} wordLengths", wordLengths);
        List<SpecialSymbols> specialSymbols = wordConfigService.findAllSpecialSymbols();
        logger.info("Found {} specialSymbols", specialSymbols);
        WordConfigDto wordConfigDto = wordConfigMapper.toDto(wordLengths, specialSymbols);
        return new TextConfigDto(textLanguages, timeLimits, wordConfigDto);
    }
}

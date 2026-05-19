package com.type.speed.text.application;

import com.type.speed.text.application.dto.TextConfigDto;
import com.type.speed.text.application.dto.TextLanguageDto;
import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.application.dto.WordConfigDto;
import com.type.speed.text.domain.SpecialSymbols;
import com.type.speed.text.domain.WordLength;
import com.type.speed.text.domain.repository.TextLanguageDataMapper;
import com.type.speed.text.domain.repository.TimeLimitDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TextConfigService {
    private static final Logger logger = LoggerFactory.getLogger(TextConfigService.class);
    private final TextLanguageDataMapper textLanguageDataMapper;
    private final TimeLimitDataMapper timeLimitDataMapper;
    private final TimeLimitMapper timeLimitMapper;
    private final WordConfigMapper wordConfigMapper;

    public TextConfigService(TextLanguageDataMapper textLanguageDataMapper, TimeLimitDataMapper timeLimitDataMapper, TimeLimitMapper timeLimitMapper, WordConfigMapper wordConfigMapper) {
        this.textLanguageDataMapper = textLanguageDataMapper;
        this.timeLimitDataMapper = timeLimitDataMapper;
        this.timeLimitMapper = timeLimitMapper;
        this.wordConfigMapper = wordConfigMapper;
    }

    public TextConfigDto getTextConfigs() {
        List<TextLanguageDto> textLanguages = textLanguageDataMapper.findAll().stream()
                .map(textLanguage -> new TextLanguageDto(textLanguage.getTitle(), textLanguage.getCode()))
                .toList();
        List<TimeLimitDto> timeLimits = timeLimitDataMapper.findAll().stream()
                .map(timeLimitMapper::toResponse)
                .toList();
        List<WordLength> wordLengths = Arrays.stream(WordLength.values()).toList();
        List<SpecialSymbols> specialSymbols = Arrays.stream(SpecialSymbols.values()).toList();
        logger.info("Successfully loaded text configurations. Languages: {}, Time limits: {}, Word lengths: {}, Special symbols: {}",
                textLanguages.size(), timeLimits.size(), wordLengths.size(), specialSymbols.size());
        WordConfigDto wordConfigDto = wordConfigMapper.toDto(wordLengths, specialSymbols);
        return new TextConfigDto(textLanguages, timeLimits, wordConfigDto);
    }
}

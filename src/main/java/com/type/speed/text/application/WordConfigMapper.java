package com.type.speed.text.application;

import com.type.speed.text.application.dto.*;
import com.type.speed.text.application.dto.SpecialSymbolDto.SpecialSymbolOptionDto;
import com.type.speed.text.application.dto.WordLengthDto.WordLengthOptionDto;
import com.type.speed.text.domain.SpecialSymbols;
import com.type.speed.text.domain.WordLength;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordConfigMapper {

    public WordConfigDto toDto(List<WordLength> lengths, List<SpecialSymbols> symbols) {
        List<WordLengthOptionDto> lengthOptions = lengths.stream()
                .map(length -> new WordLengthOptionDto(
                        ApplicationWordLength.fromDomain(length).getTitle(),
                        ApplicationWordLength.fromDomain(length).name(),
                        length == WordLength.REGULAR
                ))
                .toList();
        WordLengthDto wordLengthDto = new WordLengthDto(lengthOptions, true);

        List<SpecialSymbolOptionDto> symbolOptions = symbols.stream()
                .map(symbol -> new SpecialSymbolOptionDto(
                        ApplicationSpecialSymbols.fromDomain(symbol).getTitle(),
                        ApplicationSpecialSymbols.fromDomain(symbol).name(),
                        symbol == SpecialSymbols.PUNCTUATION
                ))
                .toList();
        SpecialSymbolDto specialSymbolDto = new SpecialSymbolDto(symbolOptions, false);

        return new WordConfigDto(wordLengthDto, specialSymbolDto);
    }
}

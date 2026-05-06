package com.type.speed.text.domain.service;

import com.type.speed.text.domain.SpecialSymbols;
import com.type.speed.text.domain.WordLength;

import java.util.List;

public class WordConfigService {

    public List<WordLength> findAllWordLength() {
        return List.of(WordLength.values());
    }

    public List<SpecialSymbols> findAllSpecialSymbols() {
        return List.of(SpecialSymbols.values());
    }
}

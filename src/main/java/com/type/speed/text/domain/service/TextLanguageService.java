package com.type.speed.text.domain.service;

import com.type.speed.text.domain.TextLanguage;
import com.type.speed.text.domain.repository.TextLanguageDataMapper;

import java.util.List;

public class TextLanguageService {
    private final TextLanguageDataMapper textLanguageDataMapper;

    public TextLanguageService(TextLanguageDataMapper textLanguageDataMapper) {
        this.textLanguageDataMapper = textLanguageDataMapper;
    }

    public List<TextLanguage> findAll() {
        return textLanguageDataMapper.findAll();
    }
}

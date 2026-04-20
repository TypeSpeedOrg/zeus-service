package com.type.speed.text.domain.repository;

import com.type.speed.text.domain.TextLanguage;

import java.util.List;

public interface TextLanguageDataMapper {

    List<TextLanguage> findAll();
}

package com.type.speed.text.domain.repository;

import com.type.speed.text.domain.Word;
import com.type.speed.text.domain.WordLength;

import java.util.List;

public interface WordDataMapper {

    List<Word> findRandomBy(WordLength wordLength, String langCode, int limit);
}

package com.type.speed.text.application;

import com.type.speed.text.application.dto.ApplicationWordLength;
import com.type.speed.text.domain.Word;
import com.type.speed.text.domain.WordLength;
import com.type.speed.text.domain.repository.WordDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationWordService {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationWordService.class);
    private final WordDataMapper wordDataMapper;

    public ApplicationWordService(WordDataMapper wordDataMapper) {
        this.wordDataMapper = wordDataMapper;
    }
    
    public List<String> findRandomWordsBy(ApplicationWordLength wordLength, String languageCode, int wordsLimit) {
        logger.info("Looking for random words by word length: {}, lang code: {} and limit: {}", wordLength, languageCode, wordsLimit);
        if (wordLength == null || languageCode == null || languageCode.isBlank() || wordsLimit <= 0) {
            throw new IllegalArgumentException("Word length and lang code can't be null. Limit must be positive");
        }
        List<Word> result = wordDataMapper.findRandomBy(WordLength.valueOf(wordLength.name()), languageCode, wordsLimit);
        logger.info("Words found count: {}", result.size());
        return result.stream()
                .map(Word::getValue)
                .toList();
    }
}

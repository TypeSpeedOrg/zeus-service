package com.type.speed.text.presentation.web;

import com.type.speed.text.application.ApplicationWordService;
import com.type.speed.text.application.dto.ApplicationWordLength;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {
    private final ApplicationWordService wordService;

    public WordsController(ApplicationWordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<String> getWords(@RequestParam String langCode, @RequestParam ApplicationWordLength wordLength,
                                 @RequestParam int wordsLimit) {
        return wordService.findRandomWordsBy(wordLength, langCode, wordsLimit);
    }
}

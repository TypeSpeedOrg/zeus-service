package com.type.speed.text.domain;

public class Word {
    private final String value;
    private final WordLength length;
    private final String languageCode;

    public Word(String value, WordLength length, String languageCode) {
        if (value == null || value.isBlank() || length == null ||
                languageCode == null || languageCode.isBlank()) {
            throw new IllegalArgumentException("Value, length and lang code can't be null");
        }
        this.value = value;
        this.length = length;
        this.languageCode = languageCode;
    }

    public WordLength getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}

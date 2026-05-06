package com.type.speed.text.application.dto;

import com.type.speed.text.domain.SpecialSymbols;

public enum ApplicationSpecialSymbols {
    PUNCTUATION("Punctuation"),
    CHARACTERS("Special characters");

    private final String title;

    ApplicationSpecialSymbols(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ApplicationSpecialSymbols fromDomain(SpecialSymbols specialSymbol) {
        return switch (specialSymbol) {
            case PUNCTUATION -> PUNCTUATION;
            case CHARACTERS -> CHARACTERS;
            default -> throw new IllegalArgumentException("Unsupported special symbol " + specialSymbol);
        };
    }
}

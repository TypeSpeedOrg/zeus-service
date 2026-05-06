package com.type.speed.text.application.dto;

import com.type.speed.text.domain.WordLength;

public enum ApplicationWordLength {
    SHORT("Short"),
    REGULAR("Regular"),
    LONG("Long");

    private final String title;

    ApplicationWordLength(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ApplicationWordLength fromDomain(WordLength domain) {
        return switch (domain) {
            case SHORT -> SHORT;
            case REGULAR -> REGULAR;
            case LONG -> LONG;
            default -> throw new IllegalArgumentException("Unsupported word length: " + domain);
        };
    }
}

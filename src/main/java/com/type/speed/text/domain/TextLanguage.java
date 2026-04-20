package com.type.speed.text.domain;

public class TextLanguage {
    private final String title;
    private final String code;

    public TextLanguage(String title, String code) {
        if (title == null || title.isEmpty() || code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Title and code cannot be null or empty");
        }
        this.title = title;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}

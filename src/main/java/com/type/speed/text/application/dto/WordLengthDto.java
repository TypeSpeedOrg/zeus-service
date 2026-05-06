package com.type.speed.text.application.dto;

import java.util.List;

public record WordLengthDto(List<WordLengthOptionDto> options, boolean isRequired) {

    public record WordLengthOptionDto(String title, String code, boolean isDefault) {
    }
}

package com.type.speed.text.application.dto;

import java.util.List;

public record SpecialSymbolDto(List<SpecialSymbolOptionDto> options, boolean isRequired) {

    public record SpecialSymbolOptionDto(String title, String code, boolean isDefault) {
    }
}

package com.type.speed.text.presentation.web;

import com.type.speed.text.application.TextConfigService;
import com.type.speed.text.application.dto.TextConfigDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text-configs")
public class TextConfigsController {

    private final TextConfigService textConfigService;

    public TextConfigsController(TextConfigService textConfigService) {
        this.textConfigService = textConfigService;
    }

    @GetMapping
    public TextConfigDto getTextConfigs() {
        return textConfigService.getTextConfigs();
    }
}
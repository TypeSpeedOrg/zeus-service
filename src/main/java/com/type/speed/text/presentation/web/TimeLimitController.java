package com.type.speed.text.presentation.web;

import com.type.speed.text.application.TimeLimitService;
import com.type.speed.text.application.dto.TimeLimitDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time-limits")
public class TimeLimitController {

    private final TimeLimitService timeLimitService;

    public TimeLimitController(TimeLimitService timeLimitService) {
        this.timeLimitService = timeLimitService;
    }

    @GetMapping
    public List<TimeLimitDto> getTimeLimits() {
        return timeLimitService.findAll();
    }
}
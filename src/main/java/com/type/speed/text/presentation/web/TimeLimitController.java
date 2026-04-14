package com.type.speed.text.presentation.web;

import com.type.speed.text.application.TimeLimitService;
import com.type.speed.text.presentation.web.dto.TimeLimitResponse;
import com.type.speed.text.presentation.web.mapper.TimeLimitWebMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time-limits")
public class TimeLimitController {

    private final TimeLimitService timeLimitService;
    private final TimeLimitWebMapper timeLimitWebMapper;

    public TimeLimitController(TimeLimitService timeLimitService, TimeLimitWebMapper timeLimitWebMapper) {
        this.timeLimitService = timeLimitService;
        this.timeLimitWebMapper = timeLimitWebMapper;
    }

    @GetMapping
    public List<TimeLimitResponse> getTimeLimits() {
        return timeLimitService.findAll().stream()
                .map(timeLimitWebMapper::toResponse)
                .toList();
    }
}
package com.type.speed.text.domain.service;

import com.type.speed.text.domain.TimeLimit;
import com.type.speed.text.domain.repository.TimeLimitDataMapper;

import java.util.List;

public class TimeLimitService {
    private final TimeLimitDataMapper timeLimitDataMapper;

    public TimeLimitService(TimeLimitDataMapper timeLimitDataMapper) {
        this.timeLimitDataMapper = timeLimitDataMapper;
    }

    public List<TimeLimit> findAll() {
        return timeLimitDataMapper.findAll();
    }
}

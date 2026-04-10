package com.type.speed.text.application;

import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.domain.repository.TimeLimitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLimitService {
    private final TimeLimitRepository timeLimitRepository;

    public TimeLimitService(TimeLimitRepository timeLimitRepository) {
        this.timeLimitRepository = timeLimitRepository;
    }

    public List<TimeLimitDto> findAll() {
        return timeLimitRepository.findAll().stream()
                .map(timeLimit -> new TimeLimitDto(timeLimit.getValue(), timeLimit.getTimeUnit().name(), timeLimit.isDefault()))
                .toList();
    }
}

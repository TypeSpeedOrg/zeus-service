package com.type.speed.text.application;

import com.type.speed.text.application.dto.TimeLimitDto;
import com.type.speed.text.domain.repository.TimeLimitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLimitService {
    private final static Logger logger = LoggerFactory.getLogger(TimeLimitService.class);
    private final TimeLimitRepository timeLimitRepository;

    public TimeLimitService(TimeLimitRepository timeLimitRepository) {
        this.timeLimitRepository = timeLimitRepository;
    }

    public List<TimeLimitDto> findAll() {
        List<TimeLimitDto> result = timeLimitRepository.findAll().stream()
                .map(timeLimit -> new TimeLimitDto(timeLimit.getValueSeconds(), timeLimit.getTimeUnit(), timeLimit.isDefault()))
                .toList();
        logger.info("Found all time limits: {}", result);
        return result;
    }
}

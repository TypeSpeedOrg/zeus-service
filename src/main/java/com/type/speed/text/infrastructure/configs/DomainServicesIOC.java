package com.type.speed.text.infrastructure.configs;

import com.type.speed.text.domain.repository.TextLanguageDataMapper;
import com.type.speed.text.domain.repository.TimeLimitDataMapper;
import com.type.speed.text.domain.service.TextLanguageService;
import com.type.speed.text.domain.service.TimeLimitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServicesIOC {

    @Bean
    public TextLanguageService textLanguageService(TextLanguageDataMapper textLanguageDataMapper) {
        return new TextLanguageService(textLanguageDataMapper);
    }

    @Bean
    public TimeLimitService timeLimitService(TimeLimitDataMapper timeLimitDataMapper) {
        return new TimeLimitService(timeLimitDataMapper);
    }
}

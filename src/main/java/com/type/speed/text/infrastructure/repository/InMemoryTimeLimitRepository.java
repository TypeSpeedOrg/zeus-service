package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.TimeLimit;
import com.type.speed.text.domain.repository.TimeLimitRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class InMemoryTimeLimitRepository implements TimeLimitRepository {

    @Override
    public List<TimeLimit> findAll() {
        return List.of(
                new TimeLimit(30, TimeUnit.SECONDS, true),
                new TimeLimit(60, TimeUnit.SECONDS, false),
                new TimeLimit(90, TimeUnit.SECONDS, false),
                new TimeLimit(120, TimeUnit.SECONDS, false)
        );
    }
}

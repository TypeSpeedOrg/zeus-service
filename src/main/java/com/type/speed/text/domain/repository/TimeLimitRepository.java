package com.type.speed.text.domain.repository;

import com.type.speed.text.domain.TimeLimit;

import java.util.List;

public interface TimeLimitRepository {

    List<TimeLimit> findAll();
}

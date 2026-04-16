package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.TimeLimit;
import com.type.speed.text.domain.repository.TimeLimitRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeLimitSQLRepository implements TimeLimitRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TimeLimitDataMapper timeLimitRowMapper;

    public TimeLimitSQLRepository(JdbcTemplate jdbcTemplate, TimeLimitDataMapper timeLimitRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.timeLimitRowMapper = timeLimitRowMapper;
    }

    @Override
    public List<TimeLimit> findAll() {
        String sql = "select value_seconds, time_unit, is_default from time_limits";

        return jdbcTemplate.query(sql, timeLimitRowMapper);
    }
}

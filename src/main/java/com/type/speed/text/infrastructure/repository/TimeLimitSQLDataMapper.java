package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.TimeLimit;
import com.type.speed.text.domain.repository.TimeLimitDataMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class TimeLimitSQLDataMapper implements TimeLimitDataMapper {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<TimeLimit> ROW_MAPPER = (rs, rowNum) -> new TimeLimit(
            rs.getInt("value_seconds"),
            TimeUnit.valueOf(rs.getString("time_unit")),
            rs.getBoolean("is_default")
    );

    public TimeLimitSQLDataMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TimeLimit> findAll() {
        String sql = "select value_seconds, time_unit, is_default from time_limits";

        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
}

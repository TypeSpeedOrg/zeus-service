package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.TimeLimit;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@Component
public class TimeLimitDataMapper implements RowMapper<TimeLimit> {

    @Override
    public TimeLimit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TimeLimit(
                rs.getInt("value_seconds"),
                TimeUnit.valueOf(rs.getString("time_unit")),
                rs.getBoolean("is_default")
        );
    }
}

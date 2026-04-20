package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.TextLanguage;
import com.type.speed.text.domain.repository.TextLanguageDataMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TextLanguageSQLDataMapper implements TextLanguageDataMapper {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<TextLanguage> ROW_MAPPER = (rs, rowNum) -> new TextLanguage(
            rs.getString("title"),
            rs.getString("code")
    );

    public TextLanguageSQLDataMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TextLanguage> findAll() {
        String sql = "select code, title from text_languages";

        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
}

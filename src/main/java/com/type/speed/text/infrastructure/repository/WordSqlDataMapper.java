package com.type.speed.text.infrastructure.repository;

import com.type.speed.text.domain.Word;
import com.type.speed.text.domain.WordLength;
import com.type.speed.text.domain.repository.WordDataMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordSqlDataMapper implements WordDataMapper {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Word> ROW_MAPPER = (rs, rowNum) -> new Word(
            rs.getString("val"),
            WordLength.valueOf(rs.getString("len")),
            rs.getString("lang_code"));

    public WordSqlDataMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Word> findRandomBy(WordLength wordLength, String langCode, int limit) {
        String sql = "SELECT val, lang_code, len FROM words WHERE lang_code = ? AND len = ? ORDER BY random() LIMIT ?";

        return jdbcTemplate.query(sql, ROW_MAPPER, langCode, wordLength.name(), limit);
    }
}

CREATE TABLE words (
    val varchar(255) NOT NULL,
    lang_code varchar(2) NOT NULL,
    len varchar(15) NOT NULL,

    PRIMARY KEY (val, lang_code),

    CONSTRAINT fk_words_text_languages
        FOREIGN KEY (lang_code)
        REFERENCES text_languages(code)
        ON DELETE RESTRICT
);

CREATE INDEX idx_words_lang_length ON words(lang_code, len);
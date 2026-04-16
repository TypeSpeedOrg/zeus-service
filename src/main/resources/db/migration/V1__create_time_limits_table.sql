CREATE TABLE time_limits (
                             value_seconds INTEGER NOT NULL,
                             time_unit     VARCHAR(20) NOT NULL,
                             is_default    BOOLEAN NOT NULL DEFAULT FALSE,

                             CONSTRAINT pk_time_limits PRIMARY KEY (value_seconds, time_unit)
);
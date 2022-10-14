CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE param_customer (
    id INTEGER NOT NULL,
    name VARCHAR(255),
    age INTEGER DEFAULT 0,
    create_at TIMESTAMP with time zone,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);
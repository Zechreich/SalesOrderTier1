CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE param_product (
    id INTEGER NOT NULL,
    product_name VARCHAR(255),
    product_category VARCHAR(255),
    price INTEGER DEFAULT 0,
    stock INTEGER DEFAULT 0,
    create_at TIMESTAMP with time zone,
    CONSTRAINT pk_product PRIMARY KEY (id)
);
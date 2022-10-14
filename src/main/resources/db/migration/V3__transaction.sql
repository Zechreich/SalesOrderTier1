CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE transaction_history (
    id INTEGER NOT NULL,
    id_customer INTEGER NOT NULL,
    id_product INTEGER NOT NULL,
    quantity INTEGER DEFAULT 0,
    total_price INTEGER DEFAULT 0,
    bank_transfer_number VARCHAR NOT NULL,
    create_at TIMESTAMP with time zone,
    CONSTRAINT pk_transaction_history PRIMARY KEY (id)
);
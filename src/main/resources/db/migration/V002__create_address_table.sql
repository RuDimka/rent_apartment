create sequence address_sequence start 2 increment 1;

CREATE TABLE address(
    id INT8 PRIMARY KEY NOT NULL,
    city VARCHAR,
    street VARCHAR,
    house_number VARCHAR
);

INSERT INTO address(id, city, street, house_number)
    VALUES (1, 'Пенза', 'Пушкина', '2в');


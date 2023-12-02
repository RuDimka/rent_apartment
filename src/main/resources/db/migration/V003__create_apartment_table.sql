create sequence apartment_sequence start 2 increment 1;

CREATE TABLE apartment(
    id INT8 PRIMARY KEY NOT NULL,
    rooms_count VARCHAR,
    price FLOAT,
    free_pets BOOLEAN,
    rating FLOAT,
    date_registration TIMESTAMP,
    free_flag BOOLEAN,
    address INT8 REFERENCES address(id)
);

INSERT INTO apartment(id, rooms_count, price, free_pets, rating, date_registration, free_flag, address)
    VALUES (1, '2', 11.1, true, 4.4, NULL, true, 1);


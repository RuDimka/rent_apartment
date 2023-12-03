create sequence user_info_sequence start 2 increment 1;

CREATE TABLE IF NOT EXISTS user_info(
    id int8 PRIMARY KEY NOT NULL,
    nick_name VARCHAR,
    email VARCHAR,
    password VARCHAR,
    date_registration VARCHAR,
    token VARCHAR,
    parent_city VARCHAR
);

INSERT INTO user_info(id, nick_name, email, password, date_registration, token, parent_city)
    VALUES (1, 'Test', 'test@gmail.com', 'test', NULL, 'test_token', 'Пенза');

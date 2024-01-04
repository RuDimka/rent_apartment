CREATE TABLE integration_data_info
(
    id              VARCHAR PRIMARY KEY NOT NULL,
    integration_url VARCHAR,
    token           VARCHAR
);

INSERT INTO integration_data_info(id,integration_url, token)
VALUES ('GEO', 'https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s', 'NTVmMjQ1MWRkN2Q1NGJjZGJmZWI4OTI2NjA0NjcxYzM=');


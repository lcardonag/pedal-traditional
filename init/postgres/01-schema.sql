-- Postgres schema for pedal-traditional (customers datasource)
-- Fixed typo from upstream ebike_data.sql (line 15 comma)

CREATE TABLE IF NOT EXISTS bikes (
    id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
    warranty_status char(10),
    image bytea,
    model varchar(50) NOT NULL,
    price int NOT NULL,
    date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS service_user (
    id serial PRIMARY KEY,
    fullname varchar(150) NOT NULL,
    username varchar(50) NOT NULL,
    email varchar(75) NOT NULL,
    user_role varchar(50) NOT NULL,
    password varchar(75) NOT NULL,
    date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS bike_order (
    id serial PRIMARY KEY,
    date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    product_id int NOT NULL,
    customer_id int NOT NULL,
    price int NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES service_user(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES bikes(id)
);

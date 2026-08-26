create table if not exists bikes (
                                     id serial primary key,
                                     name varchar(100) not null,
    warranty_status char(10),
    image bytea,
    model varchar(50) not null,
    price int not null,
    date_created timestamp not null default CURRENT_TIMESTAMP
    )

create table if not exists service_user (
                                            id serial primary key,
                                            fullname varchar(150) not null,
    username varchar(50) not null,
    email varchar(75) not null,_
    user_role varchar(50) not null,
    password varchar(75) not null,
    date_created timestamp not null default CURRENT_TIMESTAMP
    )

create table if not exists bike_order (
                                          id serial primary key,
                                          date_created timestamp not null default CURRENT_TIMESTAMP,
                                          product_id int not null,
                                          customer_id int not null,
                                          price int not null,
                                          constraint fk_customer foreign key(customer_id) references service_user(id),
    constraint fk_product foreign key(product_id) references bikes(id)
    )

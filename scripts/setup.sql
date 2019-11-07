create schema favorite_places collate utf8mb4_0900_ai_ci;

create table user
(
    user_id int auto_increment
        primary key,
    userName int null,
    passWord int null
);

create table favorites
(
    id int auto_increment
        primary key,
    parkingLotId int null,
    user_id int null,
    constraint favorites_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on update cascade on delete cascade
);


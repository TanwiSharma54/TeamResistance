create schema if not exists favorite_places collate utf8mb4_0900_ai_ci;

create table if not exists user
(
    id int auto_increment
        primary key,
    userName varchar(20) null,
    passWord int null
);

create table if not exists favorites
(
    id int auto_increment
        primary key,
    parkingLotId int(10) null,
    name varchar(64) null,
    description varchar(120) null,
    price double null,
    available int null,
    user_id int null,
    constraint favorites_user_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

create table if not exists role
(
    role_id int auto_increment,
    role_name varchar(25) not null,
    userName varchar(20) not null,
    user_id int not null,
    constraint role_id_uindex
        unique (role_id),
    constraint role_user_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

alter table role
    add primary key (role_id);

INSERT INTO user VALUES(1, 'tsharma', 1234), (2, 'nyaang', 1234);
INSERT INTO `role` VALUES (1,'user','tsharma',1), (2,'user','nyaang',2);



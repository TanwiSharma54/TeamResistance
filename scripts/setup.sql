create schema favorite_places collate utf8mb4_0900_ai_ci;


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

create table user
(
    user_id int auto_increment
        primary key,
    userName varchar(20) null,
    passWord int null
);

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_uindex` (`role_id`),
  KEY `role_user_user_id_fk` (`user_id`),
  CONSTRAINT `role_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO user VALUES(1, 'tsharma', 1234), (2, 'nyaang', 1234);

INSERT INTO `role` VALUES (1,'user','tsharma',1), (2,'user','nyaang',2);



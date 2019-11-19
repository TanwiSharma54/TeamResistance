delete from favorites;
delete from user;
delete from role;
Alter table favorites AUTO_INCREMENT = 0;
Alter table user AUTO_INCREMENT = 0;
Alter table role AUTO_INCREMENT = 0;
INSERT INTO user VALUES(1, 'tsharma', 1234), (2, 'nyaang', 1234);
INSERT INTO `role` VALUES (1,'user','tsharma',1), (2,'user','nyaang',2);


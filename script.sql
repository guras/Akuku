drop table users;

create table users (
  user_id integer UNSIGNED NOT NULL AUTO_INCREMENT,
  username varchar(256) NOT NULL,
  
  
  name varchar(256) NOT NULL,
  surname varchar(256) NOT NULL,
  password varchar(256) NOT NULL,
  enabled tinyint(1) NOT NULL default 1 ,
  PRIMARY KEY (user_id)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into users values (1 , 'test', 'Marcin', 'Górecki', 'test', 1);

CREATE TABLE `user_roles` (
  `USER_ROLE_ID` INT(10) UNSIGNED NOT NULL,
  `USER_ID` INT(10) UNSIGNED NOT NULL,
  `AUTHORITY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (1, 1, 'ROLE_USER');
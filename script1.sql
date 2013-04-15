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

insert into users values (1 , 'test', 'Marcin', 'G�recki', 'test', 1);

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


CREATE TABLE `Weekly_Report` (
  ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  HIGHLIHGTS VARCHAR(4096),
  LOWLIGHTS VARCHAR(4096),
  USER_ID INT(10) UNSIGNED NOT NULL,
  REPORT_WEEK INT(3) NOT NULL,
  REPORT_YEAR INT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT `FK_USER` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Weekly_Report` (
  ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  HIGHLIHGTS VARCHAR(4096),
  LOWLIGHTS VARCHAR(4096),
  USER_ID INT(10) UNSIGNED NOT NULL,
  REPORT_WEEK INT(3) NOT NULL,
  REPORT_YEAR INT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT `FK_USER` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Project_Report` (
  ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  COLOR VARCHAR(16) NOT NULL,
  PROJECT VARCHAR(256) NOT NULL,
  WEEKLYREPORT INT(10) UNSIGNED NOT NULL,
  MAINACHEVEMENTS VARCHAR(4096),
  DONELASTWEEK VARCHAR(4096),
  NEXTSTEPS VARCHAR(4096),
  EDC VARCHAR(256),
  ETC VARCHAR(256),
  PRIMARY KEY (ID),
  CONSTRAINT `FK_WEEKLYREPORT` FOREIGN KEY (`WEEKLYREPORT`) REFERENCES `WEEKLY_REPORT` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
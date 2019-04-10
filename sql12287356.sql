-- Adminer 4.7.0 MySQL dump

SET NAMES utf8;
SET time_zone = '+5:30';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE USER 'sql12287356'@'localhost' IDENTIFIED WITH mysql_native_password AS 'rupindersingh1234';GRANT ALL PRIVILEGES ON *.* TO 'sql12287356'@'localhost' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;CREATE DATABASE IF NOT EXISTS `sql12287356`;GRANT ALL PRIVILEGES ON `sql12287356`.* TO 'sql12287356'@'localhost';GRANT ALL PRIVILEGES ON `sql12287356\_%`.* TO 'sql12287356'@'localhost';
SET PASSWORD FOR 'sql12287356'@'localhost' = PASSWORD('rupindersingh1234');
 
USE `sql12287356`;

DROP TABLE IF EXISTS `accountDetails`;
CREATE TABLE `accountDetails` (
  `AccountNo` int(11) NOT NULL AUTO_INCREMENT,
  `CardNo` varchar(100) NOT NULL,
  `Pin` varchar(100) NOT NULL,
  `AvailBal` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `AccountType` varchar(100) NOT NULL,
  PRIMARY KEY (`AccountNo`,`CardNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `accountDetails` (`AccountNo`, `CardNo`, `Pin`, `AvailBal`, `UserName`, `AccountType`) VALUES
(1,	'1000',	'1111',	'19900',	'Rupa',	'Saving')
ON DUPLICATE KEY UPDATE `AccountNo` = VALUES(`AccountNo`), `CardNo` = VALUES(`CardNo`), `Pin` = VALUES(`Pin`), `AvailBal` = VALUES(`AvailBal`), `UserName` = VALUES(`UserName`), `AccountType` = VALUES(`AccountType`);

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `admin` (`UserName`, `Password`) VALUES
('admin',	'admin')
ON DUPLICATE KEY UPDATE `UserName` = VALUES(`UserName`), `Password` = VALUES(`Password`);

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `AccountNo` varchar(50) NOT NULL,
  `CardNo` varchar(50) NOT NULL,
  `Credit` varchar(50) DEFAULT NULL,
  `Debit` varchar(50) DEFAULT NULL,
  `oldBal` varchar(50) DEFAULT NULL,
  `availBal` varchar(50) DEFAULT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `transaction` (`AccountNo`, `CardNo`, `Credit`, `Debit`, `oldBal`, `availBal`, `Date`) VALUES
('1',	'1000',	NULL,	'500',	'19600',	'19100',	'2019-04-10 08:45:55'),
('1',	'1000',	'500',	NULL,	'19100',	'19600',	'2019-04-10 08:46:41'),
('1',	'1000',	NULL,	'100',	'19600',	'19500',	'2019-04-10 10:18:14'),
('1',	'1000',	'500',	NULL,	'19500',	'20000',	'2019-04-10 10:19:24'),
('1',	'1000',	NULL,	'100',	'20000',	'19900',	'2019-04-10 11:27:28')
ON DUPLICATE KEY UPDATE `AccountNo` = VALUES(`AccountNo`), `CardNo` = VALUES(`CardNo`), `Credit` = VALUES(`Credit`), `Debit` = VALUES(`Debit`), `oldBal` = VALUES(`oldBal`), `availBal` = VALUES(`availBal`), `Date` = VALUES(`Date`);

-- 2019-04-10 14:01:50

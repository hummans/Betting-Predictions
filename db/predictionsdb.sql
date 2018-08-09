-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for betting4life
CREATE DATABASE IF NOT EXISTS `betting4life` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `betting4life`;

-- Dumping structure for table betting4life.bets
CREATE TABLE IF NOT EXISTS `bets` (
  `betID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`betID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.bets: ~7 rows (approximately)
/*!40000 ALTER TABLE `bets` DISABLE KEYS */;
INSERT INTO `bets` (`betID`, `description`, `date`) VALUES
	(1, 'Grigor Dimitrov vs. Rafael Nadal', '2018-08-08 21:00:00'),
	(2, 'Levski vs. CSKA', '2018-08-09 00:32:00'),
	(3, 'Kubrat Pulev vs. Mike Tyson', '2018-07-11 00:00:00'),
	(4, 'Will Boyko Borisov become minister again?', '2018-04-01 00:00:00'),
	(5, 'France vs. Germany', '2018-08-07 13:00:00'),
	(6, 'Roger Federer vs. Grigor Dimitrov', '2018-06-09 13:34:00'),
	(7, 'Lennox Lewis vs. Vitali Klitschko', '2018-07-30 14:30:00');
/*!40000 ALTER TABLE `bets` ENABLE KEYS */;

-- Dumping structure for table betting4life.predictions
CREATE TABLE IF NOT EXISTS `predictions` (
  `predictionID` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  `betID` int(11) NOT NULL,
  PRIMARY KEY (`predictionID`),
  KEY `FK__users__predictions` (`userID`),
  KEY `FK_predictions_bets` (`betID`),
  CONSTRAINT `FK__users__predictions` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`),
  CONSTRAINT `FK_predictions_bets` FOREIGN KEY (`betID`) REFERENCES `bets` (`betID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.predictions: ~11 rows (approximately)
/*!40000 ALTER TABLE `predictions` DISABLE KEYS */;
INSERT INTO `predictions` (`predictionID`, `content`, `date`, `userID`, `betID`) VALUES
	(2, 'Grigor Dimitrov is in great shape and I expect him to win against Nadal. ', '2018-08-09 22:37:52', 13, 1),
	(4, 'Myke Tyson is a better boxer, but he is too old now. Pulev has to win.', '2018-08-08 22:46:54', 30, 3),
	(5, 'Boyko will rule Bulgaria forever. Mark my words.', '2018-04-01 12:35:44', 29, 4),
	(12, 'I think Levski will win', '2018-07-09 22:46:53', 30, 2),
	(14, 'CSKA is in a better overall form. They will dominate the eternal derby.', '2018-08-09 19:26:50', 31, 2),
	(15, 'The Ukranian is unbeatable. He will knock out Lewis in 4 rounds.', '2018-08-01 12:45:55', 31, 7),
	(16, 'France were great at the World Cup. Mbappe will destroy Germany.', '2018-08-08 11:32:51', 31, 5),
	(17, 'Against all odds, I firmly believe Levski is capable of winning this.', '2018-08-10 00:01:43', 10, 2),
	(18, 'Close match expected but Federer will claim the win eventually', '2018-08-10 01:23:32', 31, 6),
	(19, 'The German Machine can\'t be stopped. All in on Germany!', '2018-08-10 02:02:16', 29, 5),
	(20, 'What I believe is that the match of the century will see Klitschko winning.', '2018-08-10 02:51:35', 32, 7);
/*!40000 ALTER TABLE `predictions` ENABLE KEYS */;

-- Dumping structure for table betting4life.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.roles: ~0 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`roleID`, `name`) VALUES
	(1, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table betting4life.users
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.users: ~6 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userID`, `username`, `password`, `fullname`) VALUES
	(10, 'testuser5', '$2a$10$kM.w6UTvFQLp3TrmP6Eh8.nvTp/mRFPuIQOU7q0B1UnCHC.1H607.', 'Test Tester'),
	(13, 'testuser100', '$2a$10$lDRIpHiCiSMyggyM34Xt8.aBLbdLIhB.iXVI1rxPRmEqOlNLTSbOW', 'Tester Testerov'),
	(29, 'ivan123', '$2a$10$QkOxyCIMoz5/GikUzfMB8urz03X..r1DOGJsfVCZYXbNID6Y/x4iO', 'Ivan Ivanov'),
	(30, 'georgi91', '$2a$10$cHWzbocQ5/TRsVg5IcsAV.SRkfRaINyKoOVdBjIRRwCeUXNC.6QxC', 'Georgi Georgiev'),
	(31, 'ivo64', '$2a$10$KUC7glQQNq6b9paWew53aeL0fjY9w4ou6ezEnvmNupWRKiNITU6CG', 'Ivo Ivo'),
	(32, 'lamer', '$2a$10$5SSnkZ.Qin7K8SXaSMyCHersRx9B5nBAHnhIHaiZsApH2kmXyyX7W', 'Lamer Lamerov');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table betting4life.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `userID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`roleID`),
  KEY `FK__roles` (`roleID`),
  CONSTRAINT `FK__roles` FOREIGN KEY (`roleID`) REFERENCES `roles` (`roleID`),
  CONSTRAINT `FK__users` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.users_roles: ~6 rows (approximately)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`userID`, `roleID`) VALUES
	(10, 1),
	(13, 1),
	(29, 1),
	(30, 1),
	(31, 1),
	(32, 1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

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
  `type` enum('Sports','Other') NOT NULL,
  `description` varchar(255) NOT NULL,
  `outcomeA` varchar(50) NOT NULL,
  `outcomeB` varchar(50) NOT NULL,
  PRIMARY KEY (`betID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.bets: ~0 rows (approximately)
/*!40000 ALTER TABLE `bets` DISABLE KEYS */;
INSERT INTO `bets` (`betID`, `type`, `description`, `outcomeA`, `outcomeB`) VALUES
	(1, 'Sports', 'Grigor Dimitrov vs. Rafael Nadal', 'Dimitrov to win', 'Nadal to win'),
	(2, 'Sports', 'Levski vs. CSKA', 'Levski to win', 'CSKA to win'),
	(3, 'Sports', 'Kubrat Pulev vs. Mike Tyson', 'Pulev to win', 'Tyson to win'),
	(4, 'Other', 'Will Boyko Borisov become minister again?', 'Yes', 'No');
/*!40000 ALTER TABLE `bets` ENABLE KEYS */;

-- Dumping structure for table betting4life.predictions
CREATE TABLE IF NOT EXISTS `predictions` (
  `predictionID` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `datePublished` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  `betID` int(11) NOT NULL,
  PRIMARY KEY (`predictionID`),
  KEY `FK__users__predictions` (`userID`),
  KEY `FK_predictions_bets` (`betID`),
  CONSTRAINT `FK__users__predictions` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`),
  CONSTRAINT `FK_predictions_bets` FOREIGN KEY (`betID`) REFERENCES `bets` (`betID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.predictions: ~0 rows (approximately)
/*!40000 ALTER TABLE `predictions` DISABLE KEYS */;
INSERT INTO `predictions` (`predictionID`, `content`, `datePublished`, `userID`, `betID`) VALUES
	(2, 'Grigor Dimitrov is in great shape and I expect him to win against Nadal. ', '2018-08-01 12:47:54', 1, 1),
	(4, 'Myke Tyson is a better boxer, but he is too old now. Pulev has to win.', '2018-08-01 12:49:22', 2, 3),
	(5, 'Boyko will rule Bulgaria forever. Mark my words.', '2018-08-01 12:50:21', 2, 4);
/*!40000 ALTER TABLE `predictions` ENABLE KEYS */;

-- Dumping structure for table betting4life.users
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userID`, `username`, `password`, `fullname`) VALUES
	(1, 'ivan123', '123456', 'Ivan Ivanov'),
	(2, 'georgi91', 'qwerty', 'Georgi Georgiev');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table betting4life.users_bets
CREATE TABLE IF NOT EXISTS `users_bets` (
  `userID` int(11) NOT NULL,
  `betID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`betID`),
  KEY `FK_users_bets_bets` (`betID`),
  CONSTRAINT `FK_users_bets_bets` FOREIGN KEY (`betID`) REFERENCES `bets` (`betID`),
  CONSTRAINT `FK_users_bets_users` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table betting4life.users_bets: ~0 rows (approximately)
/*!40000 ALTER TABLE `users_bets` DISABLE KEYS */;
INSERT INTO `users_bets` (`userID`, `betID`) VALUES
	(1, 1),
	(2, 1),
	(1, 2),
	(2, 2),
	(2, 3),
	(2, 4);
/*!40000 ALTER TABLE `users_bets` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

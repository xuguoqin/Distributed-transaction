# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: integral
# Generation Time: 2018-07-22 05:28:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_eventpublish
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_eventpublish`;

CREATE TABLE `tb_eventpublish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` tinyint(1) DEFAULT NULL,
  `payload` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `event_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_eventpublish` WRITE;
/*!40000 ALTER TABLE `tb_eventpublish` DISABLE KEYS */;

INSERT INTO `tb_eventpublish` (`id`, `status`, `payload`, `create_time`, `event_type`)
VALUES
	(8,1,'{\"user_id\":29340}','2018-07-22 00:04:00','add_integral'),
	(9,1,'{\"user_id\":29340}','2018-07-22 00:04:00','add_integral'),
	(10,1,'{\"user_id\":29340}','2018-07-22 00:04:00','add_integral'),
	(11,1,'{\"user_id\":29340}','2018-07-22 00:08:00','add_integral'),
	(12,1,'{\"user_id\":29340}','2018-07-22 00:08:00','add_integral');

/*!40000 ALTER TABLE `tb_eventpublish` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_integral
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_integral`;

CREATE TABLE `tb_integral` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `integral_num` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_integral` WRITE;
/*!40000 ALTER TABLE `tb_integral` DISABLE KEYS */;

INSERT INTO `tb_integral` (`id`, `integral_num`, `user_id`)
VALUES
	(3,10,29340),
	(4,10,29340),
	(5,10,29340),
	(6,10,29340),
	(7,10,29340);

/*!40000 ALTER TABLE `tb_integral` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

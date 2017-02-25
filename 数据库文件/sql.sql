/*
SQLyog Ultimate v8.32 
MySQL - 5.6.19-0ubuntu0.14.04.1 : Database - hibernate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hibernate` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hibernate`;

/*Table structure for table `t_message` */

DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_title` varchar(100) NOT NULL,
  `message_content` varchar(10000) NOT NULL,
  `message_date` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FK_t_message` (`user_id`),
  CONSTRAINT `FK_t_message` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_message` */

insert  into `t_message`(`message_id`,`message_title`,`message_content`,`message_date`,`user_id`) values (2,'2','2','2016-02-01 12:28:01',1),(3,'1820','<p>请输入公告内容1820</p>','2016-12-30 18:22:39',1),(5,'ceshifade123','<p>请输入公告内容123</p>','2016-12-31 11:30:24',1),(6,'21312','<p>请输入公告内容1231</p>','2017-01-02 14:16:26',1),(7,'213123123123','<p style=\"text-align: center;\">请<span style=\"text-decoration:underline;\">输入公告</span>内容1<span style=\"text-decoration:line-through;\">2312</span>3123123</p>','2017-01-02 14:18:16',1),(9,'213213123123123','<p><strong>请输入公告内容1231231</strong></p>','2017-01-03 19:05:16',1),(12,'333333333','<p>请输入公告内容</p>','2017-01-05 09:55:19',1),(14,'123123','<p>请输入公告内容</p>','2017-01-05 09:56:09',1),(15,'123123','<p>请输入公告内容</p>','2017-01-05 10:00:02',1),(16,'12312','<p>请输入公告内容213123</p>','2017-01-05 10:00:31',1),(17,'ceshi12321321','<p>请输入公告内容123123</p>','2017-01-05 10:30:06',5),(18,'ceshi3423423','<p>请输入公告内容1231</p>','2017-01-05 10:30:14',5),(19,'ceshi76976867','<p>请输入公告内容</p>','2017-01-05 10:30:22',5),(20,'ceshi2','<p>请输入公告2131231内容</p>','2017-01-05 10:32:56',6);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `user_password` varchar(10) NOT NULL,
  `user_access` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`user_password`,`user_access`) values (1,'admin','admin',1),(5,'ceshi','123',0),(6,'ceshi2','123',0),(7,'ceshi3','123',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

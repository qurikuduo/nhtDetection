/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `ipdb`;

USE `ipdb`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `nhtInfo` */

DROP TABLE IF EXISTS `nhtInfo`;

CREATE TABLE `nhtInfo` (
  `ip` varchar(256) NOT NULL COMMENT 'IP地址的字符串表示',
  `ipLong` bigint(20) NOT NULL COMMENT 'IP地址的整数表示形式',
  `nhtScore` int(11) NOT NULL COMMENT 'NHT得分',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注信息',
  `id` bigint(20) NOT NULL COMMENT 'id，主键，IP的整数形式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nhtInfo` */

insert  into `nhtInfo`(`ip`,`ipLong`,`nhtScore`,`updateTime`,`createTime`,`memo`,`id`) values ('192.168.0.2',1,60,'2019-08-27 20:21:00','2019-08-27 20:21:00','test',0),('192.168.0.3',2,0,'2019-08-28 11:49:00','2019-08-28 11:49:00','abctest123',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

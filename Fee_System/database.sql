/*
SQLyog Enterprise - MySQL GUI v8.02 RC
MySQL - 5.5.5-10.3.16-MariaDB : Database - fee_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`fee_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `fee_system`;

/*Table structure for table `admindata` */

DROP TABLE IF EXISTS `admindata`;

CREATE TABLE `admindata` (
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admindata` */

insert  into `admindata`(`name`,`contact`,`address`,`email`) values ('Amaan ','9999999999','Civil Lines','amaan@gmail.com'),('dhruv','9754612313','Kota','dd@gmail.com');

/*Table structure for table `course_master` */

DROP TABLE IF EXISTS `course_master`;

CREATE TABLE `course_master` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `course_master` */

insert  into `course_master`(`course_id`,`course_name`,`fee`,`duration`) values (1,'java core',5000,100),(2,'pyhton',5500,100),(3,'C',3500,100),(4,'machine learning',12000,200),(5,'DSA',3500,100);

/*Table structure for table `logindata` */

DROP TABLE IF EXISTS `logindata`;

CREATE TABLE `logindata` (
  `email` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `usertype` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `logindata` */

insert  into `logindata`(`email`,`password`,`usertype`) values ('amaan@gmail.com','147','admin'),('dd@gmail.com','dd','operator');

/*Table structure for table `operatordata` */

DROP TABLE IF EXISTS `operatordata`;

CREATE TABLE `operatordata` (
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `operatordata` */

insert  into `operatordata`(`name`,`contact`,`address`,`email`) values ('dhruv','1234567890','dadabari','dd@gmail.com');

/*Table structure for table `st_course` */

DROP TABLE IF EXISTS `st_course`;

CREATE TABLE `st_course` (
  `st_course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(100) DEFAULT NULL,
  `s_id` int(100) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `fee` varchar(100) DEFAULT NULL,
  `duration` varchar(100) DEFAULT NULL,
  `commencement_date` date DEFAULT NULL,
  PRIMARY KEY (`st_course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `st_course` */

insert  into `st_course`(`st_course_id`,`course_id`,`s_id`,`course_name`,`fee`,`duration`,`commencement_date`) values (5,3,1,'C','3500','100','2023-09-04'),(6,2,1,'pyhton','5500','100','2023-09-04');

/*Table structure for table `st_installment` */

DROP TABLE IF EXISTS `st_installment`;

CREATE TABLE `st_installment` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `amount` varchar(100) DEFAULT NULL,
  `t_date` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `st_installment` */

insert  into `st_installment`(`t_id`,`s_id`,`course_id`,`amount`,`t_date`,`remark`) values (7,1,3,'3000','2023-09-11','cash'),(8,1,2,'3000','2023-09-11','cash'),(9,1,3,'500','2023-09-11','cash');

/*Table structure for table `st_photo` */

DROP TABLE IF EXISTS `st_photo`;

CREATE TABLE `st_photo` (
  `s_id` int(100) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_photo` */

insert  into `st_photo`(`s_id`,`photo`) values (1,'1_FB2.gif');

/*Table structure for table `stdata` */

DROP TABLE IF EXISTS `stdata`;

CREATE TABLE `stdata` (
  `s_id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `stdata` */

insert  into `stdata`(`s_id`,`name`,`contact`,`address`,`email`) values (1,'Dhruv','6459783120','Civil Lines, kota','dhruv@gmail.com'),(2,'Manish','987654321','Sakatpura ,kota','manish@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

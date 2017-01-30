-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: admin
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.15.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fy_a_lectures`
--

DROP TABLE IF EXISTS `fy_a_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_a_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(1) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_a_lectures`
--

LOCK TABLES `fy_a_lectures` WRITE;
/*!40000 ALTER TABLE `fy_a_lectures` DISABLE KEYS */;
INSERT INTO `fy_a_lectures` VALUES ('2016-05-07','CC_108',1),('2016-05-07','CC_110',1),('2016-05-08','CC_108',5),('2016-05-08','CC_109',1),('2016-05-08','CC_112',1),('2016-05-09','CC_108',2),('2016-05-09','CC_109',1),('2016-05-12','CC_108',2);
/*!40000 ALTER TABLE `fy_a_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fy_a_reports`
--

DROP TABLE IF EXISTS `fy_a_reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_a_reports` (
  `roll_no` int(11) NOT NULL DEFAULT '0',
  `cc_108` int(11) DEFAULT NULL,
  `cc_109` int(11) DEFAULT NULL,
  `cc_110` int(11) DEFAULT NULL,
  `cc_111` int(11) DEFAULT NULL,
  `cc_112` int(11) DEFAULT NULL,
  `cc_113` int(11) DEFAULT NULL,
  `cc_114` int(11) DEFAULT NULL,
  `EC` int(11) DEFAULT NULL,
  `FC` int(11) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_a_reports`
--

LOCK TABLES `fy_a_reports` WRITE;
/*!40000 ALTER TABLE `fy_a_reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `fy_a_reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fy_b_lectures`
--

DROP TABLE IF EXISTS `fy_b_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_b_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(1) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_b_lectures`
--

LOCK TABLES `fy_b_lectures` WRITE;
/*!40000 ALTER TABLE `fy_b_lectures` DISABLE KEYS */;
INSERT INTO `fy_b_lectures` VALUES ('2016-05-07','CC_114',1),('2016-05-08','CC_109',1),('2016-05-08','CC_110',2),('2016-05-08','EC',1),('2016-05-12','CC_109',1);
/*!40000 ALTER TABLE `fy_b_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `roll_no` int(5) NOT NULL DEFAULT '0',
  `name` varchar(30) DEFAULT NULL,
  `Class` varchar(10) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `blood_group` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'nandini','fy_a',NULL,NULL,NULL),(2,'sahil','fy_a',NULL,NULL,NULL),(3,'harsh','fy_a',NULL,NULL,NULL),(61,'a','FY_B','qwertyuiop',779849212,'O+');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_a_lectures`
--

DROP TABLE IF EXISTS `sy_a_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_a_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(2) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_a_lectures`
--

LOCK TABLES `sy_a_lectures` WRITE;
/*!40000 ALTER TABLE `sy_a_lectures` DISABLE KEYS */;
INSERT INTO `sy_a_lectures` VALUES ('2016-05-04','CC_208',1),('2016-05-04','CC_209',1),('2016-05-04','CC_210',2),('2016-05-04','CC_211',1),('2016-05-04','FC',1),('2016-05-05','CC_212',1),('2016-05-05','CC_214',1),('2016-05-05','EC',1),('2016-05-06','CC_208',1),('2016-05-06','CC_210',1),('2016-05-06','CC_211',1),('2016-05-06','FC',1),('2016-05-07','CC_208',2),('2016-05-07','CC_209',2),('2016-05-07','CC_210',1),('2016-05-07','CC_212',1),('2016-05-07','CC_214',1),('2016-05-07','FC',1),('2016-05-08','CC_211',2),('2016-05-08','FC',1),('2016-05-09','CC_208',1),('2016-05-09','CC_209',2),('2016-05-09','CC_210',2),('2016-05-09','CC_211',1),('2016-05-09','CC_212',2),('2016-05-09','CC_213',1),('2016-05-09','CC_214',1),('2016-05-09','EC',1),('2016-05-09','FC',2);
/*!40000 ALTER TABLE `sy_a_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_b_lectures`
--

DROP TABLE IF EXISTS `sy_b_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_b_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(2) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_b_lectures`
--

LOCK TABLES `sy_b_lectures` WRITE;
/*!40000 ALTER TABLE `sy_b_lectures` DISABLE KEYS */;
INSERT INTO `sy_b_lectures` VALUES ('2016-05-07','CC_208',1),('2016-05-08','CC_208',1),('2016-05-08','CC_211',1);
/*!40000 ALTER TABLE `sy_b_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_details`
--

DROP TABLE IF EXISTS `teacher_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_details` (
  `username` varchar(15) NOT NULL,
  `password` varchar(25) DEFAULT '1234',
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `blood_group` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_details`
--

LOCK TABLES `teacher_details` WRITE;
/*!40000 ALTER TABLE `teacher_details` DISABLE KEYS */;
INSERT INTO `teacher_details` VALUES ('Bharat','a','nandini.soni845@gmail.com','acbd',8866714514,'A+'),('Dhara','abcd','nandini.soni8@gmail.com','acbd',1234567890,'A+'),('Manali','1234','qwertyu','sdfcgvbhjnkl,		',9220636252,'AB-');
/*!40000 ALTER TABLE `teacher_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_lectures`
--

DROP TABLE IF EXISTS `total_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_lectures` (
  `class` varchar(4) DEFAULT NULL,
  `subject` varchar(10) DEFAULT NULL,
  `total_lectures` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_lectures`
--

LOCK TABLES `total_lectures` WRITE;
/*!40000 ALTER TABLE `total_lectures` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_strength`
--

DROP TABLE IF EXISTS `total_strength`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_strength` (
  `class` varchar(10) DEFAULT NULL,
  `total_students` int(9) DEFAULT NULL,
  `lowest_rollno` int(5) DEFAULT NULL,
  `highest_rollno` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_strength`
--

LOCK TABLES `total_strength` WRITE;
/*!40000 ALTER TABLE `total_strength` DISABLE KEYS */;
INSERT INTO `total_strength` VALUES ('fy_a',60,1,60),('fy_b',60,61,120),('sy_a',75,2001,2075),('sy_b',75,2101,2175),('ty_a',60,3001,3060),('ty_b',60,3061,3120);
/*!40000 ALTER TABLE `total_strength` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_a_lectures`
--

DROP TABLE IF EXISTS `ty_a_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_a_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(2) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_a_lectures`
--

LOCK TABLES `ty_a_lectures` WRITE;
/*!40000 ALTER TABLE `ty_a_lectures` DISABLE KEYS */;
INSERT INTO `ty_a_lectures` VALUES ('2016-05-07','CC_308',1),('2016-05-07','CC_310',1),('2016-05-08','CC_308',1),('2016-05-08','CC_311',1),('2016-05-08','FC',1),('2016-05-12','CC_307',2);
/*!40000 ALTER TABLE `ty_a_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_b_lectures`
--

DROP TABLE IF EXISTS `ty_b_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_b_lectures` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `subject` varchar(7) NOT NULL DEFAULT '',
  `lecture` int(2) DEFAULT '0',
  PRIMARY KEY (`date`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_b_lectures`
--

LOCK TABLES `ty_b_lectures` WRITE;
/*!40000 ALTER TABLE `ty_b_lectures` DISABLE KEYS */;
INSERT INTO `ty_b_lectures` VALUES ('2016-05-07','cc_307',2),('2016-05-07','cc_308',3),('2016-05-07','cc_309',2),('2016-05-08','CC_308',1),('2016-05-08','CC_311',1),('2016-05-10','CC_311',1);
/*!40000 ALTER TABLE `ty_b_lectures` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-14 19:34:37

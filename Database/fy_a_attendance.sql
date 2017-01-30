-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: odd_sem_attendance
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
-- Table structure for table `fy_a_attendance`
--

DROP TABLE IF EXISTS `fy_a_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_a_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_101` int(11) DEFAULT '0',
  `cc_102` int(11) DEFAULT '0',
  `cc_103` int(11) DEFAULT '0',
  `cc_104` int(11) DEFAULT '0',
  `cc_105` int(11) DEFAULT '0',
  `cc_106` int(11) DEFAULT '0',
  `cc_107` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_a_attendance`
--

LOCK TABLES `fy_a_attendance` WRITE;
/*!40000 ALTER TABLE `fy_a_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `fy_a_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fy_b_attendance`
--

DROP TABLE IF EXISTS `fy_b_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_b_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_101` int(11) DEFAULT '0',
  `cc_102` int(11) DEFAULT '0',
  `cc_103` int(11) DEFAULT '0',
  `cc_104` int(11) DEFAULT '0',
  `cc_105` int(11) DEFAULT '0',
  `cc_106` int(11) DEFAULT '0',
  `cc_107` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_b_attendance`
--

LOCK TABLES `fy_b_attendance` WRITE;
/*!40000 ALTER TABLE `fy_b_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `fy_b_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_a_attendance`
--

DROP TABLE IF EXISTS `sy_a_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_a_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_201` int(11) DEFAULT '0',
  `cc_202` int(11) DEFAULT '0',
  `cc_203` int(11) DEFAULT '0',
  `cc_204` int(11) DEFAULT '0',
  `cc_205` int(11) DEFAULT '0',
  `cc_206` int(11) DEFAULT '0',
  `cc_207` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_a_attendance`
--

LOCK TABLES `sy_a_attendance` WRITE;
/*!40000 ALTER TABLE `sy_a_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_a_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_b_attendance`
--

DROP TABLE IF EXISTS `sy_b_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_b_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_201` int(11) DEFAULT '0',
  `cc_202` int(11) DEFAULT '0',
  `cc_203` int(11) DEFAULT '0',
  `cc_204` int(11) DEFAULT '0',
  `cc_205` int(11) DEFAULT '0',
  `cc_206` int(11) DEFAULT '0',
  `cc_207` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_b_attendance`
--

LOCK TABLES `sy_b_attendance` WRITE;
/*!40000 ALTER TABLE `sy_b_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_b_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_a_attendance`
--

DROP TABLE IF EXISTS `ty_a_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_a_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_301` int(11) DEFAULT '0',
  `cc_302` int(11) DEFAULT '0',
  `cc_303` int(11) DEFAULT '0',
  `cc_304` int(11) DEFAULT '0',
  `cc_305` int(11) DEFAULT '0',
  `cc_306` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_a_attendance`
--

LOCK TABLES `ty_a_attendance` WRITE;
/*!40000 ALTER TABLE `ty_a_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_a_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_b_attendance`
--

DROP TABLE IF EXISTS `ty_b_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_b_attendance` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `roll_no` int(4) NOT NULL DEFAULT '0',
  `cc_301` int(11) DEFAULT '0',
  `cc_302` int(11) DEFAULT '0',
  `cc_303` int(11) DEFAULT '0',
  `cc_304` int(11) DEFAULT '0',
  `cc_305` int(11) DEFAULT '0',
  `cc_306` int(11) DEFAULT '0',
  `EC` int(11) DEFAULT '0',
  `FC` int(11) DEFAULT '0',
  PRIMARY KEY (`date`,`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_b_attendance`
--

LOCK TABLES `ty_b_attendance` WRITE;
/*!40000 ALTER TABLE `ty_b_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_b_attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-14 19:36:21

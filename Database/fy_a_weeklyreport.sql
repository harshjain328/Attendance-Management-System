-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: report
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
-- Table structure for table `fy_a_weeklyreport`
--

DROP TABLE IF EXISTS `fy_a_weeklyreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fy_a_weeklyreport` (
  `roll_no` int(5) NOT NULL,
  `week_2` int(3) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fy_a_weeklyreport`
--

LOCK TABLES `fy_a_weeklyreport` WRITE;
/*!40000 ALTER TABLE `fy_a_weeklyreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `fy_a_weeklyreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `sy_a_report`
--

DROP TABLE IF EXISTS `sy_a_report`;
/*!50001 DROP VIEW IF EXISTS `sy_a_report`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `sy_a_report` AS SELECT 
 1 AS `roll_no`,
 1 AS `CC_208`,
 1 AS `CC_209`,
 1 AS `CC_210`,
 1 AS `CC_211`,
 1 AS `CC_212`,
 1 AS `CC_213`,
 1 AS `CC_214`,
 1 AS `EC`,
 1 AS `FC`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sy_a_weeklyreport`
--

DROP TABLE IF EXISTS `sy_a_weeklyreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_a_weeklyreport` (
  `roll_no` int(5) NOT NULL,
  `week_1` int(3) DEFAULT NULL,
  `week_2` int(3) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_a_weeklyreport`
--

LOCK TABLES `sy_a_weeklyreport` WRITE;
/*!40000 ALTER TABLE `sy_a_weeklyreport` DISABLE KEYS */;
INSERT INTO `sy_a_weeklyreport` VALUES (2001,173,NULL),(2002,173,NULL),(2003,180,NULL),(2004,160,NULL),(2005,173,NULL),(2006,160,NULL),(2007,153,NULL),(2008,147,NULL),(2009,160,NULL),(2010,160,NULL),(2011,173,NULL),(2012,167,NULL),(2013,173,NULL),(2014,160,NULL),(2015,147,NULL),(2016,133,NULL),(2017,127,NULL),(2018,133,NULL),(2019,133,NULL),(2020,147,NULL),(2021,153,NULL),(2022,147,NULL),(2023,147,NULL),(2024,147,NULL),(2025,153,NULL),(2026,147,NULL),(2027,153,NULL),(2028,160,NULL),(2029,160,NULL),(2030,167,NULL),(2031,167,NULL),(2032,167,NULL),(2033,167,NULL),(2034,167,NULL),(2035,160,NULL),(2036,160,NULL),(2037,160,NULL),(2038,160,NULL),(2039,160,NULL),(2040,167,NULL),(2041,160,NULL),(2042,153,NULL),(2043,147,NULL),(2044,147,NULL),(2045,160,NULL),(2046,167,NULL),(2047,153,NULL),(2048,147,NULL),(2049,153,NULL),(2050,153,NULL),(2051,147,NULL),(2052,167,NULL),(2053,160,NULL),(2054,153,NULL),(2055,160,NULL),(2056,167,NULL),(2057,173,NULL),(2058,173,NULL),(2059,167,NULL),(2060,167,NULL),(2061,160,NULL),(2062,160,NULL),(2063,160,NULL),(2064,167,NULL),(2065,153,NULL),(2066,167,NULL),(2067,173,NULL),(2068,180,NULL),(2069,173,NULL),(2070,153,NULL),(2071,160,NULL),(2072,167,NULL),(2073,173,NULL),(2074,173,NULL),(2075,167,NULL);
/*!40000 ALTER TABLE `sy_a_weeklyreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `sy_a_report`
--

/*!50001 DROP VIEW IF EXISTS `sy_a_report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sy_a_report` AS select `even_sem_attendance`.`sy_a_attendance`.`roll_no` AS `roll_no`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_208`) / 5) * 100) AS `CC_208`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_209`) / 5) * 100) AS `CC_209`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_210`) / 6) * 100) AS `CC_210`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_211`) / 5) * 100) AS `CC_211`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_212`) / 4) * 100) AS `CC_212`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_213`) / 1) * 100) AS `CC_213`,((sum(`even_sem_attendance`.`sy_a_attendance`.`cc_214`) / 3) * 100) AS `CC_214`,((sum(`even_sem_attendance`.`sy_a_attendance`.`EC`) / 2) * 100) AS `EC`,((sum(`even_sem_attendance`.`sy_a_attendance`.`FC`) / 6) * 100) AS `FC` from `even_sem_attendance`.`sy_a_attendance` group by `even_sem_attendance`.`sy_a_attendance`.`roll_no` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-14 19:37:54

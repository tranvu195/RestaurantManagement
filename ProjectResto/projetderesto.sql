-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: projetrestaurant
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `billet`
--

DROP TABLE IF EXISTS `billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billet` (
  `IDBillet` char(10) NOT NULL,
  `DateB` datetime DEFAULT NULL,
  `IDTable` char(10) DEFAULT NULL,
  `IDPersonnel` char(10) DEFAULT NULL,
  `PrixTotal` float DEFAULT NULL,
  `Fini` int(11) DEFAULT NULL,
  `Paye` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDBillet`),
  KEY `FK_Billet_Tables` (`IDTable`),
  KEY `FK_Billet_Personnel` (`IDPersonnel`),
  CONSTRAINT `FK_Billet_Personnel` FOREIGN KEY (`IDPersonnel`) REFERENCES `personnel` (`IDPersonnel`),
  CONSTRAINT `FK_Billet_Tables` FOREIGN KEY (`IDTable`) REFERENCES `tables` (`IDTable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billet`
--

LOCK TABLES `billet` WRITE;
/*!40000 ALTER TABLE `billet` DISABLE KEYS */;
INSERT INTO `billet` VALUES ('bi0001','1995-08-19 00:00:00','tab001','SE0001',200000,0,0),('bi0002','1995-08-19 00:00:00','tab002','SE0002',100000,0,0),('bi0003','1995-08-19 00:00:00','tab003','SE0001',150000,0,0);
/*!40000 ALTER TABLE `billet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billetendetail`
--

DROP TABLE IF EXISTS `billetendetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billetendetail` (
  `IDBillet` char(10) NOT NULL,
  `IDPlat` char(10) DEFAULT NULL,
  `NombreDePlat` int(11) DEFAULT NULL,
  `Prix` float DEFAULT NULL,
  PRIMARY KEY (`IDBillet`),
  KEY `FK_BilletEnDetail_Plat` (`IDPlat`),
  CONSTRAINT `FK_BilletEnDetail_Plat` FOREIGN KEY (`IDPlat`) REFERENCES `plat` (`IDPlat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billetendetail`
--

LOCK TABLES `billetendetail` WRITE;
/*!40000 ALTER TABLE `billetendetail` DISABLE KEYS */;
INSERT INTO `billetendetail` VALUES ('bi0001','plat03',1,200000),('bi0002','plat04',1,100000),('bi0003','plat01',1,150000);
/*!40000 ALTER TABLE `billetendetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personnel` (
  `IDPersonnel` char(10) NOT NULL,
  `RoleP` varchar(50) DEFAULT NULL,
  `Nom` varchar(50) DEFAULT NULL,
  `DateDeNaissance` datetime DEFAULT NULL,
  `NomUsager` varchar(50) DEFAULT NULL,
  `MotDePasse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDPersonnel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personnel`
--

LOCK TABLES `personnel` WRITE;
/*!40000 ALTER TABLE `personnel` DISABLE KEYS */;
INSERT INTO `personnel` VALUES ('',NULL,NULL,NULL,NULL,NULL),('CA0001','caisse','Lucas','1995-08-19 00:00:00','cai1','123'),('CA0002','caisse','Thomas','1994-06-24 00:00:00','cai2','123'),('CH0001','chef','Richard','1995-09-23 00:00:00','ch1','123'),('SE0001','serveur','Yves','1995-09-23 00:00:00','ser1','123'),('SE0002','serveur','Max','1995-03-20 00:00:00','ser2','123');
/*!40000 ALTER TABLE `personnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plat`
--

DROP TABLE IF EXISTS `plat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plat` (
  `IDPlat` char(10) NOT NULL,
  `NomDePlat` varchar(50) DEFAULT NULL,
  `PrixDePlat` float DEFAULT NULL,
  PRIMARY KEY (`IDPlat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat`
--

LOCK TABLES `plat` WRITE;
/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES ('plat01','Sushi',200000),('plat02','Salmon',400000),('plat03','Pizza',100000),('plat04','Lagu',150000),('plat05','Red Bean Rice',50000),('plat06','Egg',50000);
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tables`
--

DROP TABLE IF EXISTS `tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tables` (
  `IDTable` char(10) NOT NULL,
  `IsFull` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDTable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tables`
--

LOCK TABLES `tables` WRITE;
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` VALUES ('tab001',0),('tab002',0),('tab003',0),('tab004',0),('tab005',0),('tab006',0),('tab007',0),('tab008',0),('tab009',0);
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-24 23:42:30

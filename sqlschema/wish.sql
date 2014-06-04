-- MySQL dump 10.13  Distrib 5.6.16, for osx10.7 (x86_64)
--
-- Host: localhost    Database: wish
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `CART`
--

DROP TABLE IF EXISTS `CART`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CART` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `itemid` int(11) DEFAULT NULL,
  `qt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CART`
--

LOCK TABLES `CART` WRITE;
/*!40000 ALTER TABLE `CART` DISABLE KEYS */;
/*!40000 ALTER TABLE `CART` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORY`
--

DROP TABLE IF EXISTS `CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORY` (
  `id` int(11) NOT NULL DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `catimg` varchar(100) DEFAULT NULL,
  `caturl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORY`
--

LOCK TABLES `CATEGORY` WRITE;
/*!40000 ALTER TABLE `CATEGORY` DISABLE KEYS */;
INSERT INTO `CATEGORY` VALUES (100,NULL,'Computers & Electronics','dell-tablet.jpeg',NULL),(101,100,'Desktop PC','desktop.png',NULL),(102,100,'Laptops & Notebooks','laptop.png',NULL),(103,100,'Tablets','tablet.png',NULL),(104,100,'TV & Video','tv.png',NULL),(200,NULL,'Home Appliances','dell-tablet.jpeg',NULL),(201,200,'washers','dell-tablet.jpeg',''),(300,NULL,'Kitchen Appliances','dell-tablet.jpeg',NULL),(301,300,'cooking-range','dell-tablet.jpeg',''),(400,NULL,'Decor','dell-tablet.jpeg',NULL),(401,400,'drapes','dell-tablet.jpeg',''),(500,NULL,'Personal Care','dell-tablet.jpeg',NULL),(600,NULL,'Experiences','dell-tablet.jpeg',NULL);
/*!40000 ALTER TABLE `CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEM`
--

DROP TABLE IF EXISTS `ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ITEM` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `catid` int(11) DEFAULT NULL,
  `imgurl` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `reviews` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `shipping` decimal(10,2) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM`
--

LOCK TABLES `ITEM` WRITE;
/*!40000 ALTER TABLE `ITEM` DISABLE KEYS */;
INSERT INTO `ITEM` VALUES (1,'Popular Item',104,'garden-shear.jpg','Very Popular Item',4,20.60,2.50,'2014-03-15 22:11:19'),(2,'General Part',104,'whouse-tv.jpg','ordinary item',2,67.50,1.00,'2014-03-16 08:24:24'),(3,'Laptop Part',102,'electronics.jpg','This laptop is super fast',3,450.50,1.00,'2014-03-16 08:25:25'),(4,'sony hdtv',104,'vizio-32-tv.jpg','Sony hdtv',4,20.60,2.50,'2014-03-23 05:14:41'),(5,'sony ps3',100,'sony-ps3.jpg','Sony ps3',3,200.60,2.50,'2014-03-23 05:16:15'),(6,'GE Profile French Door Fridge',200,'ge-fridge.jpg','GE Profile 25.5CF French Door Stainless Steel Refrigerator',3,1600.00,50.99,'2014-03-30 01:28:01'),(7,'Samsung 1080p LED Smart HDTV',104,'samsung-tv.jpg','Samsung 40 inch Class 1080p LED Smart HDTV',2,580.00,10.99,'2014-03-30 01:31:32');
/*!40000 ALTER TABLE `ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_WISHLIST`
--

DROP TABLE IF EXISTS `USER_WISHLIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_WISHLIST` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `wlname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_WISHLIST`
--

LOCK TABLES `USER_WISHLIST` WRITE;
/*!40000 ALTER TABLE `USER_WISHLIST` DISABLE KEYS */;
INSERT INTO `USER_WISHLIST` VALUES (1,1,'WishList 1','The Bucket List',NULL),(2,1,'WishList 2','The Get It All',NULL),(9,1,'wishlist 4',NULL,NULL),(10,1,'WishList 3',NULL,NULL),(11,2,'new Wlist',NULL,NULL);
/*!40000 ALTER TABLE `USER_WISHLIST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_WISHLIST_ITEMS`
--

DROP TABLE IF EXISTS `USER_WISHLIST_ITEMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_WISHLIST_ITEMS` (
  `wid` int(11) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `contrib` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`wid`,`itemid`),
  CONSTRAINT `user_wishlist_items_ibfk_1` FOREIGN KEY (`wid`) REFERENCES `USER_WISHLIST` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_WISHLIST_ITEMS`
--

LOCK TABLES `USER_WISHLIST_ITEMS` WRITE;
/*!40000 ALTER TABLE `USER_WISHLIST_ITEMS` DISABLE KEYS */;
INSERT INTO `USER_WISHLIST_ITEMS` VALUES (1,1,2.90),(1,2,51.10),(1,3,138.30),(1,4,13.10),(1,7,50.30),(2,5,59.00);
/*!40000 ALTER TABLE `USER_WISHLIST_ITEMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WISHLIST`
--

DROP TABLE IF EXISTS `WISHLIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WISHLIST` (
  `id` int(10) unsigned NOT NULL,
  `uid` int(11) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `wlname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`uid`,`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WISHLIST`
--

LOCK TABLES `WISHLIST` WRITE;
/*!40000 ALTER TABLE `WISHLIST` DISABLE KEYS */;
INSERT INTO `WISHLIST` VALUES (0,1,0,'WishList 3'),(1,1,2,'Default WishList'),(1,1,3,'Default WishList'),(1,1,4,'Default WishList'),(2,1,3,'Custom WishList'),(3,1,0,'Third WishList'),(3,2,0,'Mango');
/*!40000 ALTER TABLE `WISHLIST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(15) DEFAULT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Susmit','t@online.com','33212347538','2356 bradford st APt 23','2014-03-16 09:25:44',NULL,'default'),(2,'Tapori','tap@online.com','3123563898','2356 ocean st APt 26','2014-03-16 09:27:23',NULL,'default');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-03 19:25:39

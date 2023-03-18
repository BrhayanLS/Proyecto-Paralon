CREATE DATABASE  IF NOT EXISTS `proyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyecto`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actualizacion_pedido`
--

DROP TABLE IF EXISTS `actualizacion_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actualizacion_pedido` (
  `id_actualizacion` int NOT NULL AUTO_INCREMENT,
  `id_pedido_act` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_empleado_antes` int NOT NULL,
  `id_cliente_antes` int NOT NULL,
  `num_factura_antes` varchar(15) NOT NULL,
  `valor_antes` int NOT NULL,
  `id_conductor_antes` int NOT NULL,
  PRIMARY KEY (`id_actualizacion`),
  KEY `id_pedido_actualiza_idx` (`id_pedido_act`),
  CONSTRAINT `id_pedido_actualiza` FOREIGN KEY (`id_pedido_act`) REFERENCES `pedido_produccion` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actualizacion_pedido`
--

LOCK TABLES `actualizacion_pedido` WRITE;
/*!40000 ALTER TABLE `actualizacion_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `actualizacion_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `solo_fecha_act` BEFORE INSERT ON `actualizacion_pedido` FOR EACH ROW SET NEW.fecha = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cliente_proveedor`
--

DROP TABLE IF EXISTS `cliente_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_proveedor` (
  `id_cliente_proveedor` int NOT NULL AUTO_INCREMENT,
  `dni_nit` varchar(20) NOT NULL,
  `tipo_proveedor` varchar(15) NOT NULL,
  `razon_social` varchar(70) NOT NULL,
  `rol_cliente_provee` varchar(15) NOT NULL,
  `contacto1` varchar(15) NOT NULL,
  `contacto2` varchar(15) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_cliente_proveedor`),
  UNIQUE KEY `dni_nit_UNIQUE` (`dni_nit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_proveedor`
--

LOCK TABLES `cliente_proveedor` WRITE;
/*!40000 ALTER TABLE `cliente_proveedor` DISABLE KEYS */;
INSERT INTO `cliente_proveedor` VALUES (1,'105','Natural','Jonas SAS','Cliente','125','555','jonas@mail.com','Bogota calle 127'),(3,'asd','Juridico','sasa','Proveedor','333','','hffg','fdsfsed');
/*!40000 ALTER TABLE `cliente_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_salida`
--

DROP TABLE IF EXISTS `detalle_salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_salida` (
  `id_detalle` int NOT NULL AUTO_INCREMENT,
  `id_salida` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_salida_idx` (`id_salida`),
  KEY `id_producto_idx` (`id_producto`),
  CONSTRAINT `id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos_inventario` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_salida` FOREIGN KEY (`id_salida`) REFERENCES `salida_inventario` (`id_salida`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_salida`
--

LOCK TABLES `detalle_salida` WRITE;
/*!40000 ALTER TABLE `detalle_salida` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_salida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleados` int NOT NULL AUTO_INCREMENT,
  `id_cargo` int NOT NULL,
  `dni` varchar(15) NOT NULL,
  `contraseña` text NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `contacto1` varchar(15) NOT NULL,
  `contacto2` varchar(15) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_empleados`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `id_cargo_idx` (`id_cargo`),
  CONSTRAINT `id_cargo` FOREIGN KEY (`id_cargo`) REFERENCES `rol` (`id_cargo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,'1007','1234','Brhayan','Lopez','314',NULL,'brh'),(2,2,'1005','1234','dfds','dgrrg','321','314','nata'),(3,3,'007','1234','Albert','Einstein','1','2','albert'),(4,1,'159','1234','jjj','kkk','350','','jdk'),(10,2,'444','1234','gfdgfd','fdsfds','432','','fds');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `empleados_BEFORE_DELETE` BEFORE DELETE ON `empleados` FOR EACH ROW BEGIN
INSERT INTO ex_empleados(id_empleado_ex, id_cargo, dni, nombres, apellidos, contacto1, contacto2, correo)
value(old.id_empleados, old.id_cargo, old.dni, old.nombres, old.apellidos, old.contacto1,
old.contacto2, old.correo);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `entrada_inventario`
--

DROP TABLE IF EXISTS `entrada_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada_inventario` (
  `id_entrada` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  `id_proveedor` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_entrada`),
  KEY `id_productos_idx` (`id_producto`),
  KEY `id_proveedor_idx` (`id_proveedor`),
  KEY `id_empleado_idx` (`id_empleado`),
  CONSTRAINT `id_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleados`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_productos` FOREIGN KEY (`id_producto`) REFERENCES `productos_inventario` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `cliente_proveedor` (`id_cliente_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada_inventario`
--

LOCK TABLES `entrada_inventario` WRITE;
/*!40000 ALTER TABLE `entrada_inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrada_inventario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `solo_fecha_ent` BEFORE INSERT ON `entrada_inventario` FOR EACH ROW SET NEW.fecha = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ex_empleados`
--

DROP TABLE IF EXISTS `ex_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ex_empleados` (
  `id_ex_empleados` int NOT NULL AUTO_INCREMENT,
  `id_empleado_ex` int NOT NULL,
  `id_cargo` int NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `contacto1` varchar(15) NOT NULL,
  `contacto2` varchar(15) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ex_empleados`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_empleados`
--

LOCK TABLES `ex_empleados` WRITE;
/*!40000 ALTER TABLE `ex_empleados` DISABLE KEYS */;
INSERT INTO `ex_empleados` VALUES (5,12,1,'666','fdsvv','bnvjm','332','','rf'),(6,11,1,'333','gfdgfd','fdsfds','432','','fds');
/*!40000 ALTER TABLE `ex_empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_produccion`
--

DROP TABLE IF EXISTS `pedido_produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_produccion` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_empleado_ped` int NOT NULL,
  `id_cliente_ped` int NOT NULL,
  `numero_factura` varchar(15) NOT NULL,
  `valor` int NOT NULL,
  `id_conductor` int NOT NULL,
  PRIMARY KEY (`id_pedido`),
  UNIQUE KEY `numero_factura_UNIQUE` (`numero_factura`),
  KEY `id_empleado_pedido_idx` (`id_empleado_ped`),
  KEY `id_cliente_pedido_idx` (`id_cliente_ped`),
  KEY `id_conductor_idx` (`id_conductor`),
  CONSTRAINT `id_cliente_pedido` FOREIGN KEY (`id_cliente_ped`) REFERENCES `cliente_proveedor` (`id_cliente_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_conductor` FOREIGN KEY (`id_conductor`) REFERENCES `empleados` (`id_empleados`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_empleado_pedido` FOREIGN KEY (`id_empleado_ped`) REFERENCES `empleados` (`id_empleados`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_produccion`
--

LOCK TABLES `pedido_produccion` WRITE;
/*!40000 ALTER TABLE `pedido_produccion` DISABLE KEYS */;
INSERT INTO `pedido_produccion` VALUES (10,'2023-04-26',1,1,'NU-28',1000000,2),(11,'2023-03-14',1,1,'NU-29',2300000,2);
/*!40000 ALTER TABLE `pedido_produccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `solo_fecha_ped` BEFORE INSERT ON `pedido_produccion` FOR EACH ROW SET NEW.fecha = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `pedido_produccion_AFTER_UPDATE` AFTER UPDATE ON `pedido_produccion` FOR EACH ROW BEGIN
INSERT INTO actualizacion_pedido (id_pedido_act, id_empleado_antes, id_cliente_antes, num_factura_antes, valor_antes, id_conductor_antes)
VALUES (old.id_pedido, old.id_empleado_ped, old.id_cliente_ped, old.numero_factura, old.valor, old.id_conductor);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `produccion`
--

DROP TABLE IF EXISTS `produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produccion` (
  `id_produccion` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `id_empleado_pro` int NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_produccion`),
  UNIQUE KEY `id_produccion_UNIQUE` (`id_produccion`),
  KEY `id_producto_idx` (`id_producto`),
  KEY `id_empleado_produ_idx` (`id_empleado_pro`),
  CONSTRAINT `id_empleado_produ` FOREIGN KEY (`id_empleado_pro`) REFERENCES `empleados` (`id_empleados`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_producto_produc` FOREIGN KEY (`id_producto`) REFERENCES `productos_produccion` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produccion`
--

LOCK TABLES `produccion` WRITE;
/*!40000 ALTER TABLE `produccion` DISABLE KEYS */;
INSERT INTO `produccion` VALUES (1,1,1,'2023-02-17'),(2,2,1,'2023-02-17'),(3,3,1,'2023-02-17'),(4,4,1,'2023-02-17'),(5,5,1,'2023-02-17');
/*!40000 ALTER TABLE `produccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `solo_fecha_pro` BEFORE INSERT ON `produccion` FOR EACH ROW SET NEW.fecha = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos_inventario`
--

DROP TABLE IF EXISTS `productos_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos_inventario` (
  `IdProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`IdProducto`),
  UNIQUE KEY `IdProducto_UNIQUE` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_inventario`
--

LOCK TABLES `productos_inventario` WRITE;
/*!40000 ALTER TABLE `productos_inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_produccion`
--

DROP TABLE IF EXISTS `productos_produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos_produccion` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `costo` int NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_produccion`
--

LOCK TABLES `productos_produccion` WRITE;
/*!40000 ALTER TABLE `productos_produccion` DISABLE KEYS */;
INSERT INTO `productos_produccion` VALUES (1,'Azucar',5000),(2,'Arroz',3000),(3,'Papa',1500),(4,'Fresa',4000),(5,'Mora',4500);
/*!40000 ALTER TABLE `productos_produccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_cargo` int NOT NULL AUTO_INCREMENT,
  `cargo` varchar(45) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  PRIMARY KEY (`id_cargo`),
  UNIQUE KEY `id_cargo_UNIQUE` (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador','Persona encargada de la administración del sistema'),(2,'Jefe Produccion','Persona que vigila toda la produccion'),(3,'Jefe Inventario','A cargo de la bodega');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salida_inventario`
--

DROP TABLE IF EXISTS `salida_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salida_inventario` (
  `id_salida` int NOT NULL AUTO_INCREMENT,
  `id_empleado_sal` int NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_salida`),
  UNIQUE KEY `id_salida_UNIQUE` (`id_salida`),
  KEY `empleado_salida_idx` (`id_empleado_sal`),
  CONSTRAINT `empleado_salida` FOREIGN KEY (`id_empleado_sal`) REFERENCES `empleados` (`id_empleados`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salida_inventario`
--

LOCK TABLES `salida_inventario` WRITE;
/*!40000 ALTER TABLE `salida_inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `salida_inventario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `solo_fecha_sal` BEFORE INSERT ON `salida_inventario` FOR EACH ROW SET NEW.fecha = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'proyecto'
--

--
-- Dumping routines for database 'proyecto'
--
/*!50003 DROP PROCEDURE IF EXISTS `produccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `produccion`(IN fecha_inicio DATE, IN fecha_fin DATE)
BEGIN
SELECT p.id_produccion, p.id_empleado_pro, p.fecha, p.id_producto, pp.nombre, pp.costo
    FROM produccion AS p
    INNER JOIN productos_produccion AS  pp
    ON p.id_producto = pp.id_producto
    WHERE p.fecha BETWEEN fecha_inicio AND fecha_fin
	UNION ALL
    SELECT NULL, NULL, NULL, NULL, 'Total', SUM(pp.costo)
    FROM produccion AS p
    INNER JOIN productos_produccion AS  pp
    ON p.id_producto = pp.id_producto
    WHERE p.fecha BETWEEN fecha_inicio AND fecha_fin; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `produccion_fechas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `produccion_fechas`(IN fecha_inicio DATE, IN fecha_fin DATE)
BEGIN
SELECT a.id_produccion, a.id_empleado_pro, a.fecha, b.id_producto, b.nombre, b.costo
FROM produccion a
INNER JOIN productos_produccion b
ON a.id_producto = b.id_producto
WHERE a.fecha BETWEEN fecha_inicio AND fecha_fin
UNION ALL
SELECT NULL, NULL, NULL, NULL, 'Total', SUM(b.costo)
FROM produccion a
INNER JOIN productos_produccion b 
ON a.id_producto = b.id_producto
WHERE a.fecha BETWEEN fecha_inicio AND fecha_fin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ventas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ventas`(IN fecha_inicio DATE, IN fecha_fin DATE)
BEGIN
SELECT id_pedido, fecha, id_empleado_ped, id_cliente_ped, id_conductor, numero_factura, valor
    FROM pedido_produccion
    WHERE fecha BETWEEN fecha_inicio AND fecha_fin
	UNION ALL
    SELECT NULL, NULL, NULL, NULL, 'Total', SUM(valor)
    FROM pedido_produccion
    WHERE fecha BETWEEN fecha_inicio AND fecha_fin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-18 10:56:20

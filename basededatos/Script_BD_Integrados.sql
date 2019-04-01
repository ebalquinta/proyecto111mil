CREATE DATABASE  IF NOT EXISTS `integrados_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `integrados_db`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: integrados_db
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tema` varchar(100) NOT NULL,
  `grado` tinyint(4) NOT NULL,
  `maxIntentos` tinyint(4) NOT NULL,
  `nivel` tinyint(4) NOT NULL,
  `dificultad` tinyint(4) NOT NULL,
  `id_Materia` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  `id_Plantilla` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Actividad_Materia1_idx` (`id_Materia`),
  KEY `fk_Actividad_Plantilla1_idx` (`id_Plantilla`),
  KEY `fk_Actividad_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_Actividad_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_Materia1` FOREIGN KEY (`id_Materia`) REFERENCES `materia` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_Plantilla1` FOREIGN KEY (`id_Plantilla`) REFERENCES `plantilla` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Numeros',3,3,0,2,3,2,1),(2,'Tabla Periodica',1,2,2,0,5,1,2),(3,'Sumas',2,2,1,1,3,1,3),(4,'Numeros en ingles',1,1,0,0,9,1,4);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `grado` int(11) NOT NULL,
  `division` varchar(10) NOT NULL,
  `nivel` tinyint(4) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `FechaDeNacimiento` date DEFAULT NULL,
  `observaciones` varchar(2000) DEFAULT NULL,
  `edadMadurativa` int(11) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `mail` varchar(60) DEFAULT NULL,
  `id_Domicilio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_Alumno_Domicilio1_idx` (`id_Domicilio`),
  CONSTRAINT `fk_Alumno_Domicilio1` FOREIGN KEY (`id_Domicilio`) REFERENCES `domicilio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Jacco','Lopez',23566085,4,'e',2,'23566085','Jacco','1974-11-17','',4,'0249 423566085','Jacco_Lopez@gmail.com',1),(2,'Jacco','Sanchez',29043036,3,'e',4,'29043036','Jacco','1997-12-03','Este alumno ha demostrado increibles mejoras.',13,'0249 429043036','Jacco_Sanchez@gmail.com',2),(3,'Sebastian','Sanchez',44039533,3,'e',4,'44039533','Sebastian','1961-11-16','',4,'0249 444039533','Sebastian_Sanchez@gmail.com',3),(4,'Sebastian','Perez',33624169,3,'c',4,'33624169','Sebastian','1973-08-17','',12,'0249 433624169','Sebastian_Perez@gmail.com',4),(5,'Yanina','Dominguez',15348318,1,'e',3,'15348318','Yanina','1965-11-06','',18,'0249 415348318','Yanina_Dominguez@gmail.com',5),(6,'Yanina','Perez',26955949,6,'c',2,'26955949','Yanina','1983-03-04','',4,'0249 426955949','Yanina_Perez@gmail.com',7),(7,'Jacco','Gonzalez',43247767,5,'a',0,'43247767','Jacco','1981-11-16','',11,'0249 443247767','Jacco_Gonzalez@gmail.com',8),(8,'Mariela','Perez',17331314,4,'e',2,'17331314','Mariela','1997-06-06','',10,'0249 417331314','Mariela_Perez@gmail.com',9),(9,'Bruno','Perez',45458420,5,'d',3,'45458420','Bruno','1993-06-18','',17,'0249 445458420','Bruno_Perez@gmail.com',10),(10,'Bruno','Perez',11276714,2,'f',2,'11276714','Bruno','1991-08-06','',15,'0249 411276714','Bruno_Perez@gmail.com',11),(11,'Mariela','Martinez',26052078,4,'b',4,'26052078','Mariela','1994-11-11','',7,'0249 426052078','Mariela_Martinez@gmail.com',13),(12,'Ezequiel','Gonzalez',31811735,3,'f',2,'31811735','Ezequiel','1985-09-18','',3,'0249 431811735','Ezequiel_Gonzalez@gmail.com',14),(13,'Mariela','Sanchez',44739567,5,'a',3,'44739567','Mariela','1995-09-24','',14,'0249 444739567','Mariela_Sanchez@gmail.com',15),(14,'Mariela','Perez',35463403,5,'c',4,'35463403','Mariela','1988-12-20','',3,'0249 435463403','Mariela_Perez@gmail.com',16),(15,'Paz','Gonzalez',41746712,2,'d',1,'41746712','Paz','1998-06-08','',15,'0249 441746712','Paz_Gonzalez@gmail.com',17),(16,'Sebastian','Sanchez',41965866,5,'e',3,'41965866','Sebastian','1972-09-09','',5,'0249 441965866','Sebastian_Sanchez@gmail.com',19),(17,'Sebastian','Perez',16338171,2,'d',4,'16338171','Sebastian','1962-10-01','',6,'0249 416338171','Sebastian_Perez@gmail.com',20),(18,'Ezequiel','Perez',15900795,3,'b',0,'15900795','Ezequiel','1989-07-25','',9,'0249 415900795','Ezequiel_Perez@gmail.com',21),(19,'Ezequiel','Gutierrez',32577405,3,'f',4,'32577405','Ezequiel','1988-08-24','',16,'0249 432577405','Ezequiel_Gutierrez@gmail.com',22),(20,'Paz','Perez',16747081,4,'f',3,'16747081','Paz','1984-02-09','',10,'0249 416747081','Paz_Perez@gmail.com',23),(21,'Leandro','Martinez',36271049,3,'e',4,'36271049','Leandro','1975-10-04','',5,'0249 436271049','Leandro_Martinez@gmail.com',25),(22,'Sebastian','Dominguez',37104436,6,'d',0,'37104436','Sebastian','1962-07-06','',13,'0249 437104436','Sebastian_Dominguez@gmail.com',26),(23,'Jacco','Perez',35082085,2,'b',2,'35082085','Jacco','1992-03-02','',15,'0249 435082085','Jacco_Perez@gmail.com',27),(24,'Paz','Perez',19543975,6,'f',0,'19543975','Paz','1979-11-12','',12,'0249 419543975','Paz_Perez@gmail.com',28),(25,'Leandro','Dominguez',25366627,5,'e',1,'25366627','Leandro','2000-05-22','',2,'0249 425366627','Leandro_Dominguez@gmail.com',29);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_docente`
--

DROP TABLE IF EXISTS `alumnos_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos_docente` (
  `id` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  `id_Alumno` int(11) NOT NULL,
  KEY `fk_ListaAlumnos_docente_Docente1_idx` (`id_Docente`),
  KEY `fk_ListaAlumnos_docente_Alumno1_idx` (`id_Alumno`),
  CONSTRAINT `fk_ListaAlumnos_docente_Alumno1` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ListaAlumnos_docente_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_docente`
--

LOCK TABLES `alumnos_docente` WRITE;
/*!40000 ALTER TABLE `alumnos_docente` DISABLE KEYS */;
INSERT INTO `alumnos_docente` VALUES (0,1,1),(1,1,2),(2,1,3),(3,1,4),(4,1,5),(0,2,6),(1,2,7),(2,2,8),(3,2,9),(4,2,10),(0,3,11),(1,3,12),(2,3,13),(3,3,14),(4,3,15),(0,4,16),(1,4,17),(2,4,18),(3,4,19),(4,4,20),(0,5,21),(1,5,22),(2,5,23),(3,5,24),(4,5,25);
/*!40000 ALTER TABLE `alumnos_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloque`
--

DROP TABLE IF EXISTS `bloque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_bloque` varchar(45) NOT NULL,
  `tipoBloquePersistente` int(11) NOT NULL,
  `ruta_sonido` varchar(300) DEFAULT NULL,
  `ruta_imagen` varchar(300) DEFAULT NULL,
  `texto` varchar(1000) DEFAULT NULL,
  `id_Bloque1` int(11) DEFAULT NULL,
  `id_Bloque2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Bloque_Bloque1_idx` (`id_Bloque1`),
  KEY `fk_Bloque_Bloque2_idx` (`id_Bloque2`),
  CONSTRAINT `fk_Bloque_Bloque1` FOREIGN KEY (`id_Bloque1`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Bloque_Bloque2` FOREIGN KEY (`id_Bloque2`) REFERENCES `bloque` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloque`
--

LOCK TABLES `bloque` WRITE;
/*!40000 ALTER TABLE `bloque` DISABLE KEYS */;
INSERT INTO `bloque` VALUES (1,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/uno.jpg',NULL,NULL,NULL),(2,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/uno.jpg',NULL,NULL,NULL),(3,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dos.jpg',NULL,NULL,NULL),(4,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dos.jpg',NULL,NULL,NULL),(5,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tres.jpg',NULL,NULL,NULL),(6,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tres.jpg',NULL,NULL,NULL),(7,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cuatro.jpg',NULL,NULL,NULL),(8,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cuatro.jpg',NULL,NULL,NULL),(9,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cinco.jpg',NULL,NULL,NULL),(10,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cinco.jpg',NULL,NULL,NULL),(11,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/seis.jpg',NULL,NULL,NULL),(12,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/seis.jpg',NULL,NULL,NULL),(13,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/siete.jpg',NULL,NULL,NULL),(14,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/siete.jpg',NULL,NULL,NULL),(15,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/ocho.jpg',NULL,NULL,NULL),(16,'bloque_imagen',2,NULL,'C:/Users/Yani/Desktop/PROYECTO/Repositorio/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/ocho.jpg',NULL,NULL,NULL),(17,'bloque_texto',3,NULL,NULL,'C',NULL,NULL),(18,'bloque_texto',3,NULL,NULL,'N',NULL,NULL),(19,'bloque_texto',3,NULL,NULL,'Bl',NULL,NULL),(20,'bloque_texto',3,NULL,NULL,'100',NULL,NULL),(21,'bloque_texto',3,NULL,NULL,'10',NULL,NULL),(22,'bloque_texto',3,NULL,NULL,'1000',NULL,NULL),(23,'bloque_texto',3,NULL,NULL,'2',NULL,NULL),(24,'bloque_texto',3,NULL,NULL,'3',NULL,NULL),(25,'bloque_texto',3,NULL,NULL,'1',NULL,NULL);
/*!40000 ALTER TABLE `bloque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_1`
--

DROP TABLE IF EXISTS `bloques_plantilla_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_1` (
  `id` int(11) NOT NULL,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  KEY `fk_lista_1_Plantilla1_idx` (`id_Plantilla`),
  KEY `fk_lista_1_Bloques1_idx` (`id_Bloque`),
  CONSTRAINT `fk_lista_1_Bloques1` FOREIGN KEY (`id_Bloque`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_lista_1_Plantilla1` FOREIGN KEY (`id_Plantilla`) REFERENCES `plantilla` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloques_plantilla_1`
--

LOCK TABLES `bloques_plantilla_1` WRITE;
/*!40000 ALTER TABLE `bloques_plantilla_1` DISABLE KEYS */;
INSERT INTO `bloques_plantilla_1` VALUES (0,1,1),(1,1,3),(2,1,5),(3,1,7),(4,1,9),(5,1,11),(6,1,13),(7,1,15),(0,2,17),(1,2,18),(2,2,19),(0,3,20),(1,3,21),(2,3,22),(0,4,23),(1,4,24),(2,4,25);
/*!40000 ALTER TABLE `bloques_plantilla_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_2`
--

DROP TABLE IF EXISTS `bloques_plantilla_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_2` (
  `id` int(11) NOT NULL,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  KEY `fk_lista_2_Plantilla1_idx` (`id_Plantilla`),
  KEY `fk_lista_2_Bloques1_idx` (`id_Bloque`),
  CONSTRAINT `fk_lista_2_Bloques1` FOREIGN KEY (`id_Bloque`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_lista_2_Plantilla1` FOREIGN KEY (`id_Plantilla`) REFERENCES `plantilla` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloques_plantilla_2`
--

LOCK TABLES `bloques_plantilla_2` WRITE;
/*!40000 ALTER TABLE `bloques_plantilla_2` DISABLE KEYS */;
INSERT INTO `bloques_plantilla_2` VALUES (0,1,2),(1,1,4),(2,1,6),(3,1,8),(4,1,10),(5,1,12),(6,1,14),(7,1,16);
/*!40000 ALTER TABLE `bloques_plantilla_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_registroactividad`
--

DROP TABLE IF EXISTS `bloques_registroactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_registroactividad` (
  `id` int(11) NOT NULL,
  `id_RegistroActividad` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  KEY `fk_Bloques_RegistroActividad_Registro_actividad1_idx` (`id_RegistroActividad`),
  KEY `fk_Bloques_RegistroActividad_Bloque1_idx` (`id_Bloque`),
  CONSTRAINT `fk_Bloques_RegistroActividad_Bloque1` FOREIGN KEY (`id_Bloque`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Bloques_RegistroActividad_Registro_actividad1` FOREIGN KEY (`id_RegistroActividad`) REFERENCES `registro_actividad` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloques_registroactividad`
--

LOCK TABLES `bloques_registroactividad` WRITE;
/*!40000 ALTER TABLE `bloques_registroactividad` DISABLE KEYS */;
INSERT INTO `bloques_registroactividad` VALUES (0,1,1),(1,1,3),(2,1,5),(3,1,7),(4,1,9),(5,1,11),(6,1,13),(7,1,15);
/*!40000 ALTER TABLE `bloques_registroactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `docente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `mail` varchar(60) DEFAULT NULL,
  `id_Domicilio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_Docente_Domicilio1_idx` (`id_Domicilio`),
  CONSTRAINT `fk_Docente_Domicilio1` FOREIGN KEY (`id_Domicilio`) REFERENCES `domicilio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'Paz','Sanchez',35216561,'35216561','Paz','0249 435216561','Paz_Sanchez@gmail.com',6),(2,'Yanina','Perez',25540917,'25540917','Yanina','0249 425540917','Yanina_Perez@gmail.com',12),(3,'Leandro','Lopez',15262249,'15262249','Leandro','0249 415262249','Leandro_Lopez@gmail.com',18),(4,'Viviana','Gutierrez',36997924,'36997924','Viviana','0249 436997924','Viviana_Gutierrez@gmail.com',24),(5,'Viviana','Sanchez',26148213,'26148213','Viviana','0249 426148213','Viviana_Sanchez@gmail.com',30);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `domicilio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` varchar(10) DEFAULT NULL,
  `departamento` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'Av.Santamarina',856,NULL,NULL),(2,'Las Acacias',1274,NULL,NULL),(3,'Centinela',468,NULL,NULL),(4,'Centinela',235,NULL,NULL),(5,'Las Acacias',1013,NULL,NULL),(6,'Centinela',816,NULL,NULL),(7,'Av.Santamarina',1869,NULL,NULL),(8,'Centinela',1068,NULL,NULL),(9,'Av. Falucho',1053,NULL,NULL),(10,'25 de Mayo',401,NULL,NULL),(11,'Centinela',1204,NULL,NULL),(12,'Centinela',856,NULL,NULL),(13,'Juan Fugl',440,NULL,NULL),(14,'25 de Mayo',1577,NULL,NULL),(15,'Las Acacias',1172,NULL,NULL),(16,'Juan Fugl',257,NULL,NULL),(17,'Albert Schweitzer',157,NULL,NULL),(18,'Av.Bolivar',102,NULL,NULL),(19,'Av.Bolivar',540,NULL,NULL),(20,'Centinela',1274,NULL,NULL),(21,'Las Acacias',763,NULL,NULL),(22,'Juan XXIII',703,NULL,NULL),(23,'Av. Falucho',953,NULL,NULL),(24,'Albert Schweitzer',1339,NULL,NULL),(25,'Av. Falucho',355,NULL,NULL),(26,'25 de Mayo',431,NULL,NULL),(27,'Av. Falucho',1615,NULL,NULL),(28,'25 de Mayo',401,NULL,NULL),(29,'Centinela',1272,NULL,NULL),(30,'Centinela',1061,NULL,NULL);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `institucion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreInstitucion` varchar(45) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Institucion_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_Institucion_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucion`
--

LOCK TABLES `institucion` WRITE;
/*!40000 ALTER TABLE `institucion` DISABLE KEYS */;
INSERT INTO `institucion` VALUES (1,'Escuela Nacional Ernesto Sabato',1);
/*!40000 ALTER TABLE `institucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materia` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'Historia'),(2,'Geografia'),(3,'Matematica'),(4,'Lengua'),(5,'Quimica'),(6,'Biologia'),(7,'Civica'),(8,'Fisica'),(9,'Ingles'),(10,'Contabilidad'),(11,'Psicologia'),(12,'Filosofia');
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantilla`
--

DROP TABLE IF EXISTS `plantilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plantilla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_plantilla` varchar(45) NOT NULL,
  `enunciado` varchar(1000) NOT NULL,
  `tipoPersistente` varchar(60) NOT NULL,
  `imagen_enunciado` varchar(300) DEFAULT NULL,
  `sonido_enunciado` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantilla`
--

LOCK TABLES `plantilla` WRITE;
/*!40000 ALTER TABLE `plantilla` DISABLE KEYS */;
INSERT INTO `plantilla` VALUES (1,'memoria','Reconocer el par de numeros','Memorama',NULL,NULL),(2,'pyr','¿Cual es el simbolo del elemento CARBONO?','Preguntas y Respuestas','',''),(3,'pyr','¿Cuanto es 50 + 50?','Preguntas y Respuestas','',''),(4,'pyr','¿Que significa ONE?','Preguntas y Respuestas','','');
/*!40000 ALTER TABLE `plantilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_actividad`
--

DROP TABLE IF EXISTS `registro_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registro_actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tiempo` int(11) DEFAULT NULL,
  `finalizo_correctamente` bit(1) DEFAULT NULL,
  `intentos` tinyint(4) DEFAULT NULL,
  `estrella` tinyint(4) DEFAULT NULL,
  `corazon` varchar(200) DEFAULT NULL COMMENT 'texto libre de recompensa del docente',
  `observaciones` varchar(2000) DEFAULT NULL,
  `id_Actividad` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  `id_Alumno` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Actividad_Alumno_Actividad1_idx` (`id_Actividad`),
  KEY `fk_Registro_actividad_Docente1_idx` (`id_Docente`),
  KEY `fk_Registro_actividad_Alumno1_idx` (`id_Alumno`),
  CONSTRAINT `fk_Actividad_Alumno_Actividad1` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Registro_actividad_Alumno1` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Registro_actividad_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_actividad`
--

LOCK TABLES `registro_actividad` WRITE;
/*!40000 ALTER TABLE `registro_actividad` DISABLE KEYS */;
INSERT INTO `registro_actividad` VALUES (1,NULL,_binary '',2,3,'Excelente',NULL,1,2,2),(2,NULL,_binary '\0',NULL,NULL,NULL,NULL,2,1,2);
/*!40000 ALTER TABLE `registro_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solucion`
--

DROP TABLE IF EXISTS `solucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solucion` (
  `id` int(11) NOT NULL,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  KEY `fk_Lista_bloques1_Bloques1_idx` (`id_Bloque`),
  KEY `fk_Lista_bloques1_Plantilla1_idx` (`id_Plantilla`),
  CONSTRAINT `fk_Lista_bloques1_Bloques1` FOREIGN KEY (`id_Bloque`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Lista_bloques1_Plantilla1` FOREIGN KEY (`id_Plantilla`) REFERENCES `plantilla` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solucion`
--

LOCK TABLES `solucion` WRITE;
/*!40000 ALTER TABLE `solucion` DISABLE KEYS */;
INSERT INTO `solucion` VALUES (0,1,1),(1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,1,6),(6,1,7),(7,1,8),(8,1,9),(9,1,10),(10,1,11),(11,1,12),(12,1,13),(13,1,14),(14,1,15),(15,1,16),(0,2,17),(0,3,20),(0,4,25);
/*!40000 ALTER TABLE `solucion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-31 23:53:49

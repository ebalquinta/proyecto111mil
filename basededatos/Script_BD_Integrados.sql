CREATE DATABASE  IF NOT EXISTS `integrados_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `integrados_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: integrados_db
-- ------------------------------------------------------
-- Server version	5.6.38

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Numeros',3,3,0,2,3,1,1),(2,'Animales',3,3,0,0,6,1,2),(3,'Medidas',1,3,1,0,3,1,3),(4,'Puntos Cardinales',1,3,2,1,2,1,4),(5,'Colores',1,3,3,2,9,1,5);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `alumno` VALUES (1,'Viviana','Martinez',17558343,3,'b',2,'29043036','Jacco','1981-04-24','',17,'0249 417558343','Viviana_Martinez@gmail.com',1),(2,'Jacco','Diez',32788349,4,'d',2,'32788349','Jacco','1990-08-07','',3,'0249 432788349','Jacco_Diez@gmail.com',2),(3,'Viviana','Perez',32184889,6,'d',2,'32184889','Viviana','1970-12-03','',11,'0249 432184889','Viviana_Perez@gmail.com',3),(4,'Ezequiel','Martinez',47126785,1,'b',3,'47126785','Ezequiel','1995-12-23','',14,'0249 447126785','Ezequiel_Martinez@gmail.com',4),(5,'Viviana','Gonzalez',34657307,2,'d',3,'34657307','Viviana','1972-09-30','',1,'0249 434657307','Viviana_Gonzalez@gmail.com',5),(6,'Jacco','Dominguez',34316881,3,'a',3,'34316881','Jacco','1987-10-05','',17,'0249 434316881','Jacco_Dominguez@gmail.com',7),(7,'Ezequiel','Gutierrez',44838874,3,'f',1,'44838874','Ezequiel','1988-04-17','',18,'0249 444838874','Ezequiel_Gutierrez@gmail.com',8),(8,'Sebastian','Perez',32132771,4,'a',2,'32132771','Sebastian','1974-09-21','',17,'0249 432132771','Sebastian_Perez@gmail.com',9),(9,'Viviana','Dominguez',30597529,7,'c',3,'30597529','Viviana','1969-06-29','',3,'0249 430597529','Viviana_Dominguez@gmail.com',10),(10,'Mariela','Dominguez',15290055,5,'c',1,'15290055','Mariela','1995-06-21','',15,'0249 415290055','Mariela_Dominguez@gmail.com',11),(11,'Mariela','Lopez',26131197,3,'f',4,'26131197','Mariela','1970-03-21','',14,'0249 426131197','Mariela_Lopez@gmail.com',13),(12,'Paz','Perez',27652717,4,'d',0,'27652717','Paz','1988-07-09','',7,'0249 427652717','Paz_Perez@gmail.com',14),(13,'Paz','Dominguez',41669721,4,'b',0,'41669721','Paz','1976-07-19','',10,'0249 441669721','Paz_Dominguez@gmail.com',15),(14,'Ezequiel','Perez',18523094,2,'c',1,'18523094','Ezequiel','1988-06-16','',13,'0249 418523094','Ezequiel_Perez@gmail.com',16),(15,'Paz','Martinez',18073361,5,'a',1,'18073361','Paz','1991-04-25','',8,'0249 418073361','Paz_Martinez@gmail.com',17),(16,'Paz','Diez',41771544,5,'f',0,'41771544','Paz','1962-05-20','',8,'0249 441771544','Paz_Diez@gmail.com',19),(17,'Leandro','Sanchez',45861960,5,'e',3,'45861960','Leandro','1996-04-05','',5,'0249 445861960','Leandro_Sanchez@gmail.com',20),(18,'Bruno','Lopez',36519170,2,'b',2,'36519170','Bruno','1989-10-06','',16,'0249 436519170','Bruno_Lopez@gmail.com',21),(19,'Mariela','Diez',22652538,3,'b',4,'22652538','Mariela','1982-05-07','',12,'0249 422652538','Mariela_Diez@gmail.com',22),(20,'Leandro','Perez',37135096,3,'e',0,'37135096','Leandro','1985-03-23','',9,'0249 437135096','Leandro_Perez@gmail.com',23),(21,'Paz','Lopez',18673809,5,'b',4,'18673809','Paz','1994-07-10','',8,'0249 418673809','Paz_Lopez@gmail.com',25),(22,'Ezequiel','Dominguez',33920175,6,'c',1,'33920175','Ezequiel','1987-08-24','',4,'0249 433920175','Ezequiel_Dominguez@gmail.com',26),(23,'Mariela','Sanchez',41291124,1,'b',2,'41291124','Mariela','1977-11-06','',7,'0249 441291124','Mariela_Sanchez@gmail.com',27),(24,'Yanina','Martinez',33920189,1,'b',1,'33920189','Yanina','1990-04-21','',5,'0249 433920189','Yanina_Martinez@gmail.com',28),(25,'Sebastian','Sanchez',19491472,2,'b',0,'19491472','Sebastian','1987-12-27','',5,'0249 419491472','Sebastian_Sanchez@gmail.com',29);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_docente`
--

DROP TABLE IF EXISTS `alumnos_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_bloque` varchar(45) NOT NULL,
  `tipoBloquePersistente` int(11) NOT NULL,
  `ruta_sonido` varchar(300) DEFAULT NULL,
  `ruta_imagen` varchar(300) DEFAULT NULL,
  `texto` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloque`
--

LOCK TABLES `bloque` WRITE;
/*!40000 ALTER TABLE `bloque` DISABLE KEYS */;
INSERT INTO `bloque` VALUES (1,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/uno.jpg',NULL),(2,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/uno.jpg',NULL),(3,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dos.jpg',NULL),(4,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dos.jpg',NULL),(5,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tres.jpg',NULL),(6,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tres.jpg',NULL),(7,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cuatro.jpg',NULL),(8,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cuatro.jpg',NULL),(9,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cinco.jpg',NULL),(10,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/cinco.jpg',NULL),(11,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/seis.jpg',NULL),(12,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/seis.jpg',NULL),(13,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/siete.jpg',NULL),(14,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/siete.jpg',NULL),(15,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/ocho.jpg',NULL),(16,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/ocho.jpg',NULL),(17,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dog.jpg',NULL),(18,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/dog.jpg',NULL),(19,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/gatito.jpg',NULL),(20,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/gatito.jpg',NULL),(21,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/serpiente.jpg',NULL),(22,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/serpiente.jpg',NULL),(23,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/leon.jpg',NULL),(24,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/leon.jpg',NULL),(25,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/leopardo.jpg',NULL),(26,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/leopardo.jpg',NULL),(27,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/mono.jpg',NULL),(28,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/mono.jpg',NULL),(29,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/panda.jpg',NULL),(30,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/panda.jpg',NULL),(31,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tigre.jpg',NULL),(32,'bloque_imagen',2,NULL,'Users/pacita/NetBeansProjects/proyecto-111mil/integrados/target/classes/org/integrados/view/imagesMemorama/tigre.jpg',NULL),(33,'bloque_texto',3,NULL,NULL,'cien kilos'),(34,'bloque_texto',3,NULL,NULL,'un kilo'),(35,'bloque_texto',3,NULL,NULL,'mil kilos'),(36,'bloque_texto',3,NULL,NULL,'Por el Norte'),(37,'bloque_texto',3,NULL,NULL,'Por el Oeste'),(38,'bloque_texto',3,NULL,NULL,'Por el Este'),(39,'bloque_texto',3,NULL,NULL,'Red'),(40,'bloque_texto',3,NULL,NULL,'Yellow'),(41,'bloque_texto',3,NULL,NULL,'Blue');
/*!40000 ALTER TABLE `bloque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_1`
--

DROP TABLE IF EXISTS `bloques_plantilla_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `bloques_plantilla_1` VALUES (0,1,1),(1,1,3),(2,1,5),(3,1,7),(4,1,9),(5,1,11),(6,1,13),(7,1,15),(0,2,17),(1,2,19),(2,2,21),(3,2,23),(4,2,25),(5,2,27),(6,2,29),(7,2,31),(0,3,33),(1,3,34),(2,3,35),(0,4,36),(1,4,37),(2,4,38),(0,5,39),(1,5,40),(2,5,41);
/*!40000 ALTER TABLE `bloques_plantilla_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_2`
--

DROP TABLE IF EXISTS `bloques_plantilla_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `bloques_plantilla_2` VALUES (0,1,2),(1,1,4),(2,1,6),(3,1,8),(4,1,10),(5,1,12),(6,1,14),(7,1,16),(0,2,18),(1,2,20),(2,2,22),(3,2,24),(4,2,26),(5,2,28),(6,2,30),(7,2,32);
/*!40000 ALTER TABLE `bloques_plantilla_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_registroactividad`
--

DROP TABLE IF EXISTS `bloques_registroactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `bloques_registroactividad` VALUES (0,1,1),(1,1,3),(2,1,5),(3,1,7),(4,1,9),(5,1,11),(6,1,13),(7,1,15),(0,2,17),(1,2,19),(2,2,21),(3,2,23),(4,2,25),(5,2,27),(6,2,29),(7,2,31);
/*!40000 ALTER TABLE `bloques_registroactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `docente` VALUES (1,'Jacco','Lopez',48759078,'35216561','Paz','0249 448759078','Jacco_Lopez@gmail.com',6),(2,'Ezequiel','Sanchez',35483230,'35483230','Ezequiel','0249 435483230','Ezequiel_Sanchez@gmail.com',12),(3,'Bruno','Perez',30850332,'30850332','Bruno','0249 430850332','Bruno_Perez@gmail.com',18),(4,'Bruno','Lopez',40124945,'40124945','Bruno','0249 440124945','Bruno_Lopez@gmail.com',24),(5,'Leandro','Martinez',36302664,'36302664','Leandro','0249 436302664','Leandro_Martinez@gmail.com',30);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `domicilio` VALUES (1,'Av. Falucho',1195,NULL,NULL),(2,'Av.Santamarina',849,NULL,NULL),(3,'Juan Fugl',653,NULL,NULL),(4,'Juan XXIII',1273,NULL,NULL),(5,'Las Acacias',888,NULL,NULL),(6,'Las Acacias',550,NULL,NULL),(7,'Juan XXIII',131,NULL,NULL),(8,'Las Acacias',1686,NULL,NULL),(9,'25 de Mayo',692,NULL,NULL),(10,'Centinela',216,NULL,NULL),(11,'Albert Schweitzer',1156,NULL,NULL),(12,'25 de Mayo',401,NULL,NULL),(13,'Centinela',1731,NULL,NULL),(14,'Av.Santamarina',1385,NULL,NULL),(15,'Albert Schweitzer',1001,NULL,NULL),(16,'25 de Mayo',566,NULL,NULL),(17,'Centinela',367,NULL,NULL),(18,'Centinela',830,NULL,NULL),(19,'Av.Bolivar',865,NULL,NULL),(20,'Centinela',1414,NULL,NULL),(21,'Juan Fugl',900,NULL,NULL),(22,'Centinela',1737,NULL,NULL),(23,'Av. Falucho',1235,NULL,NULL),(24,'Centinela',347,NULL,NULL),(25,'Av. Falucho',606,NULL,NULL),(26,'Las Acacias',1531,NULL,NULL),(27,'Centinela',176,NULL,NULL),(28,'Av.Bolivar',1114,NULL,NULL),(29,'25 de Mayo',1449,NULL,NULL),(30,'25 de Mayo',1766,NULL,NULL);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plantilla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_plantilla` varchar(45) NOT NULL,
  `enunciado` varchar(1000) NOT NULL,
  `tipoPersistente` varchar(60) NOT NULL,
  `imagen_enunciado` varchar(300) DEFAULT NULL,
  `sonido_enunciado` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantilla`
--

LOCK TABLES `plantilla` WRITE;
/*!40000 ALTER TABLE `plantilla` DISABLE KEYS */;
INSERT INTO `plantilla` VALUES (1,'memoria','Reconocer el par de numeros','Memorama',NULL,NULL),(2,'memoria','Reconocer el par de animales','Memorama',NULL,NULL),(3,'pyr','¿Cuantos kilos son una tonelada?','Preguntas y Respuestas',NULL,NULL),(4,'pyr','¿Por donde sale el sol?','Preguntas y Respuestas',NULL,NULL),(5,'pyr','¿Como se escribe azul en Ingles?','Preguntas y Respuestas',NULL,NULL);
/*!40000 ALTER TABLE `plantilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_actividad`
--

DROP TABLE IF EXISTS `registro_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_actividad`
--

LOCK TABLES `registro_actividad` WRITE;
/*!40000 ALTER TABLE `registro_actividad` DISABLE KEYS */;
INSERT INTO `registro_actividad` VALUES (1,NULL,'',2,3,'Excelente',NULL,1,1,1),(2,NULL,'',1,2,'Bien',NULL,2,1,1),(3,NULL,'',3,1,'Muy bien',NULL,3,1,1),(4,NULL,'',1,3,'Felicitaciones',NULL,4,1,1),(5,NULL,'',4,2,'Sigue Trabajando',NULL,5,1,1),(6,NULL,'\0',NULL,NULL,NULL,NULL,3,1,1),(7,NULL,'\0',NULL,NULL,NULL,NULL,4,1,1),(8,NULL,'\0',NULL,NULL,NULL,NULL,5,1,1);
/*!40000 ALTER TABLE `registro_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solucion`
--

DROP TABLE IF EXISTS `solucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `solucion` VALUES (0,1,1),(1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,1,6),(6,1,7),(7,1,8),(8,1,9),(9,1,10),(10,1,11),(11,1,12),(12,1,13),(13,1,14),(14,1,15),(15,1,16),(0,2,17),(1,2,18),(2,2,19),(3,2,20),(4,2,21),(5,2,22),(6,2,23),(7,2,24),(8,2,25),(9,2,26),(10,2,27),(11,2,28),(12,2,29),(13,2,30),(14,2,31),(15,2,32),(0,3,35),(0,4,38),(0,5,41);
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

-- Dump completed on 2019-04-01  1:46:48

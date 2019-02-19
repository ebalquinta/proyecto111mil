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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
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
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_Alumno_Domicilio1_idx` (`id_Domicilio`),
  CONSTRAINT `fk_Alumno_Domicilio1` FOREIGN KEY (`id_Domicilio`) REFERENCES `domicilio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Pepe','Muleiro',122354,2,'A',1,'alumno','alumno',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_docente`
--

DROP TABLE IF EXISTS `alumnos_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos_docente` (
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
  `tipo_bloque` tinyint(4) NOT NULL,
  `ruta_sonido` varchar(300) DEFAULT NULL,
  `ruta_imagen` varchar(300) DEFAULT NULL,
  `texto` varchar(1000) DEFAULT NULL,
  `id_Bloque1` int(11) DEFAULT NULL,
  `id_Bloque2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Bloque_Bloque1_idx` (`id_Bloque1`),
  KEY `fk_Bloque_Bloque2_idx` (`id_Bloque2`),
  CONSTRAINT `fk_Bloque_Bloque1` FOREIGN KEY (`id_Bloque1`) REFERENCES `bloque` (`id`),
  CONSTRAINT `fk_Bloque_Bloque2` FOREIGN KEY (`id_Bloque2`) REFERENCES `bloque` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloque`
--

LOCK TABLES `bloque` WRITE;
/*!40000 ALTER TABLE `bloque` DISABLE KEYS */;
/*!40000 ALTER TABLE `bloque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_1`
--

DROP TABLE IF EXISTS `bloques_plantilla_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  PRIMARY KEY (`id`),
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
/*!40000 ALTER TABLE `bloques_plantilla_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_2`
--

DROP TABLE IF EXISTS `bloques_plantilla_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  PRIMARY KEY (`id`),
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
/*!40000 ALTER TABLE `bloques_plantilla_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_registroactividad`
--

DROP TABLE IF EXISTS `bloques_registroactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_registroactividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_RegistroActividad` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  PRIMARY KEY (`id`),
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'Maria','Perez',223655,'docente','docente',NULL,NULL,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `institucion` (
  `id` int(11) NOT NULL,
  `nombreInstitucion` varchar(45) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Institucion_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_Institucion_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucion`
--

LOCK TABLES `institucion` WRITE;
/*!40000 ALTER TABLE `institucion` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantilla`
--

DROP TABLE IF EXISTS `plantilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plantilla` (
  `id` int(11) NOT NULL,
  `tipo_plantilla` tinyint(4) NOT NULL,
  `enunciado` varchar(1000) NOT NULL,
  `imagen_enunciado` varchar(300) DEFAULT NULL,
  `sonido_enunciado` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantilla`
--

LOCK TABLES `plantilla` WRITE;
/*!40000 ALTER TABLE `plantilla` DISABLE KEYS */;
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
  `fecha_realizado` date DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_actividad`
--

LOCK TABLES `registro_actividad` WRITE;
/*!40000 ALTER TABLE `registro_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solucion`
--

DROP TABLE IF EXISTS `solucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solucion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_Plantilla` int(11) NOT NULL,
  `id_Bloque` int(11) NOT NULL,
  PRIMARY KEY (`id`),
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

-- Dump completed on 2019-02-14 14:32:06

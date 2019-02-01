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
  `grado` int(11) NOT NULL,
  `maxIntentos` int(11) NOT NULL,
  `id_Nivel` int(11) NOT NULL,
  `id_Dificultad` int(11) NOT NULL,
  `id_Materia` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  `id_Plantilla` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Actividad_Nivel1_idx` (`id_Nivel`),
  KEY `fk_Actividad_Materia1_idx` (`id_Materia`),
  KEY `fk_Actividad_dificultad1_idx` (`id_Dificultad`),
  KEY `fk_Actividad_Plantilla1_idx` (`id_Plantilla`),
  KEY `fk_Actividad_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_Actividad_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_Materia1` FOREIGN KEY (`id_Materia`) REFERENCES `materia` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_Nivel1` FOREIGN KEY (`id_Nivel`) REFERENCES `nivel` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_Plantilla1` FOREIGN KEY (`id_Plantilla`) REFERENCES `plantilla` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Actividad_dificultad1` FOREIGN KEY (`id_Dificultad`) REFERENCES `dificultad` (`id`) ON DELETE CASCADE
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
-- Table structure for table `actividades_docente`
--

DROP TABLE IF EXISTS `actividades_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actividades_docente` (
  `id_Actividad` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  KEY `fk_ListaActividades_Actividad1_idx` (`id_Actividad`),
  KEY `fk_ListaActividades_docente_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_ListaActividades_Actividad1` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ListaActividades_docente_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_docente`
--

LOCK TABLES `actividades_docente` WRITE;
/*!40000 ALTER TABLE `actividades_docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades_docente` ENABLE KEYS */;
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
  `FechaDeNacimiento` date DEFAULT NULL,
  `observaciones` varchar(2000) DEFAULT NULL,
  `edadMadurativa` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `user_Usuario` varchar(45) DEFAULT NULL,
  `id_Domicilio` int(11) DEFAULT NULL,
  `id_Nivel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Alumno_Nivel2_idx` (`id_Nivel`),
  KEY `fk_Alumno_Usuario1_idx` (`user_Usuario`),
  KEY `fk_Alumno_Domicilio1_idx` (`id_Domicilio`),
  CONSTRAINT `fk_Alumno_Domicilio1` FOREIGN KEY (`id_Domicilio`) REFERENCES `domicilio` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Alumno_Nivel2` FOREIGN KEY (`id_Nivel`) REFERENCES `nivel` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Alumno_Usuario1` FOREIGN KEY (`user_Usuario`) REFERENCES `usuario` (`user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
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
-- Table structure for table `alumnos_institucion`
--

DROP TABLE IF EXISTS `alumnos_institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos_institucion` (
  `id_Institucion` int(11) NOT NULL,
  `id_Alumno` int(11) NOT NULL,
  KEY `fk_Alumnos_institucion_Institucion1_idx` (`id_Institucion`),
  KEY `fk_Alumnos_institucion_Alumno1_idx` (`id_Alumno`),
  CONSTRAINT `fk_Alumnos_institucion_Alumno1` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Alumnos_institucion_Institucion1` FOREIGN KEY (`id_Institucion`) REFERENCES `institucion` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_institucion`
--

LOCK TABLES `alumnos_institucion` WRITE;
/*!40000 ALTER TABLE `alumnos_institucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnos_institucion` ENABLE KEYS */;
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
  `ruta_sonido` varchar(45) DEFAULT NULL,
  `ruta_imagen` varchar(45) DEFAULT NULL,
  `texto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
-- Table structure for table `bloque_and`
--

DROP TABLE IF EXISTS `bloque_and`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloque_and` (
  `id` int(11) NOT NULL COMMENT 'el id del bloqueAnd lo tengo que obtener primero como un autoincremental de bloque',
  `id_Bloque1` int(11) DEFAULT NULL,
  `id_Bloque2` int(11) DEFAULT NULL COMMENT 'cada ves que se cree un bloque and tambien hay que agregarlo en la tabla bloque',
  PRIMARY KEY (`id`),
  KEY `fk_Bloque_and_Bloques1_idx` (`id_Bloque2`),
  KEY `fk_Bloque_and_Bloques3_idx` (`id_Bloque1`),
  CONSTRAINT `fk_Bloque_and_Bloques1` FOREIGN KEY (`id_Bloque2`) REFERENCES `bloque` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Bloque_and_Bloques3` FOREIGN KEY (`id_Bloque1`) REFERENCES `bloque` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloque_and`
--

LOCK TABLES `bloque_and` WRITE;
/*!40000 ALTER TABLE `bloque_and` DISABLE KEYS */;
/*!40000 ALTER TABLE `bloque_and` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_1`
--

DROP TABLE IF EXISTS `bloques_plantilla_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_1` (
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
/*!40000 ALTER TABLE `bloques_plantilla_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_plantilla_2`
--

DROP TABLE IF EXISTS `bloques_plantilla_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_plantilla_2` (
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
/*!40000 ALTER TABLE `bloques_plantilla_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloques_registroactividad`
--

DROP TABLE IF EXISTS `bloques_registroactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bloques_registroactividad` (
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
/*!40000 ALTER TABLE `bloques_registroactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dificultad`
--

DROP TABLE IF EXISTS `dificultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dificultad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dificultad`
--

LOCK TABLES `dificultad` WRITE;
/*!40000 ALTER TABLE `dificultad` DISABLE KEYS */;
/*!40000 ALTER TABLE `dificultad` ENABLE KEYS */;
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
  `telefono` int(11) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `Domicilio_id` int(11) DEFAULT NULL,
  `Usuario_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_Docente_Domicilio1_idx` (`Domicilio_id`),
  KEY `fk_Docente_Usuario1_idx` (`Usuario_user`),
  CONSTRAINT `fk_Docente_Domicilio1` FOREIGN KEY (`Domicilio_id`) REFERENCES `domicilio` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Docente_Usuario1` FOREIGN KEY (`Usuario_user`) REFERENCES `usuario` (`user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes_institucion`
--

DROP TABLE IF EXISTS `docentes_institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `docentes_institucion` (
  `id_Institucion` int(11) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  KEY `fk_Docentes_institucion_Institucion1_idx` (`id_Institucion`),
  KEY `fk_Docentes_institucion_Docente1_idx` (`id_Docente`),
  CONSTRAINT `fk_Docentes_institucion_Docente1` FOREIGN KEY (`id_Docente`) REFERENCES `docente` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Docentes_institucion_Institucion1` FOREIGN KEY (`id_Institucion`) REFERENCES `institucion` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes_institucion`
--

LOCK TABLES `docentes_institucion` WRITE;
/*!40000 ALTER TABLE `docentes_institucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `docentes_institucion` ENABLE KEYS */;
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
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nivel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `perfil` (
  `user_Usuario` varchar(45) NOT NULL,
  `id_TipoDeUsuario` int(11) NOT NULL,
  KEY `fk_Lista_perfiles_Usuario1_idx` (`user_Usuario`),
  KEY `fk_Lista_perfiles_TipoDeUsuario1_idx` (`id_TipoDeUsuario`),
  CONSTRAINT `fk_Lista_perfiles_TipoDeUsuario1` FOREIGN KEY (`id_TipoDeUsuario`) REFERENCES `tipodeusuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Lista_perfiles_Usuario1` FOREIGN KEY (`user_Usuario`) REFERENCES `usuario` (`user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantilla`
--

DROP TABLE IF EXISTS `plantilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plantilla` (
  `id` int(11) NOT NULL,
  `tipo_plantilla` varchar(45) NOT NULL,
  `enunciado` varchar(200) NOT NULL,
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
  `finalizo_correctamente` tinyint(4) DEFAULT NULL,
  `fecha_realizado` date DEFAULT NULL,
  `intentos` int(11) DEFAULT NULL,
  `estrella` int(11) DEFAULT NULL,
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
-- Table structure for table `registros_alumno`
--

DROP TABLE IF EXISTS `registros_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registros_alumno` (
  `id_Alumno` int(11) NOT NULL,
  `id_RegistroActividad` int(11) NOT NULL,
  KEY `fk_Registros_alumno_Alumno1_idx` (`id_Alumno`),
  KEY `fk_Registros_alumno_Registro_actividad1_idx` (`id_RegistroActividad`),
  CONSTRAINT `fk_Registros_alumno_Alumno1` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Registros_alumno_Registro_actividad1` FOREIGN KEY (`id_RegistroActividad`) REFERENCES `registro_actividad` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registros_alumno`
--

LOCK TABLES `registros_alumno` WRITE;
/*!40000 ALTER TABLE `registros_alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `registros_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solucion`
--

DROP TABLE IF EXISTS `solucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solucion` (
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
/*!40000 ALTER TABLE `solucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodeusuario`
--

DROP TABLE IF EXISTS `tipodeusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipodeusuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tipo_UNIQUE` (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeusuario`
--

LOCK TABLES `tipodeusuario` WRITE;
/*!40000 ALTER TABLE `tipodeusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipodeusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user`),
  UNIQUE KEY `user_UNIQUE` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-01 20:04:32

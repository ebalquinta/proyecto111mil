-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Bd_proyecto111mil
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Bd_proyecto111mil` ;

-- -----------------------------------------------------
-- Schema Bd_proyecto111mil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Bd_proyecto111mil` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema bd_proyecto111mil
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_proyecto111mil` ;

-- -----------------------------------------------------
-- Schema bd_proyecto111mil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_proyecto111mil` DEFAULT CHARACTER SET utf8 ;
USE `Bd_proyecto111mil` ;

-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`TipoDeUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`TipoDeUsuario` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`TipoDeUsuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Usuario` (
  `user` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `TipoDeUsuario_id` INT NOT NULL,
  PRIMARY KEY (`user`, `TipoDeUsuario_id`),
  UNIQUE INDEX `user_UNIQUE` (`user` ASC) VISIBLE,
  INDEX `fk_Usuario_TipoDeUsuario_idx` (`TipoDeUsuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_TipoDeUsuario`
    FOREIGN KEY (`TipoDeUsuario_id`)
    REFERENCES `Bd_proyecto111mil`.`TipoDeUsuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Docente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Docente` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Docente` (
  `dni` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  CONSTRAINT `fk_Docente_Usuario1`
    FOREIGN KEY (`dni`)
    REFERENCES `Bd_proyecto111mil`.`Usuario` (`user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`CicloLectivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`CicloLectivo` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`CicloLectivo` (
  `id` INT NOT NULL,
  `CicloLectivo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CicloLectivo_UNIQUE` (`CicloLectivo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Materia` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Materia` (
  `id` INT NOT NULL,
  `Materia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Materia_UNIQUE` (`Materia` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Tema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Tema` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Tema` (
  `id` INT NOT NULL,
  `Tema` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Tema_UNIQUE` (`Tema` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Juego`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Juego` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Juego` (
  `id` INT NOT NULL,
  `Descripción` VARCHAR(45) NULL,
  `Creador` INT NOT NULL,
  `CicloLectivo_id` INT NOT NULL,
  `Materia_id` INT NOT NULL,
  `Tema_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Juego_Docente1_idx` (`Creador` ASC) VISIBLE,
  INDEX `fk_Juego_CicloLectivo1_idx` (`CicloLectivo_id` ASC) VISIBLE,
  INDEX `fk_Juego_Materia1_idx` (`Materia_id` ASC) VISIBLE,
  INDEX `fk_Juego_Tema1_idx` (`Tema_id` ASC) VISIBLE,
  CONSTRAINT `fk_Juego_Docente1`
    FOREIGN KEY (`Creador`)
    REFERENCES `Bd_proyecto111mil`.`Docente` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Juego_CicloLectivo1`
    FOREIGN KEY (`CicloLectivo_id`)
    REFERENCES `Bd_proyecto111mil`.`CicloLectivo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Juego_Materia1`
    FOREIGN KEY (`Materia_id`)
    REFERENCES `Bd_proyecto111mil`.`Materia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Juego_Tema1`
    FOREIGN KEY (`Tema_id`)
    REFERENCES `Bd_proyecto111mil`.`Tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bd_proyecto111mil`.`Alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Bd_proyecto111mil`.`Alumno` ;

CREATE TABLE IF NOT EXISTS `Bd_proyecto111mil`.`Alumno` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `FechaDeNacimiento` DATE NOT NULL,
  `Juego_id` INT NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_Alumno_Usuario1_idx` (`dni` ASC) VISIBLE,
  INDEX `fk_Alumno_Juego1_idx` (`Juego_id` ASC) VISIBLE,
  CONSTRAINT `fk_Alumno_Usuario1`
    FOREIGN KEY (`dni`)
    REFERENCES `Bd_proyecto111mil`.`Usuario` (`user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_Juego1`
    FOREIGN KEY (`Juego_id`)
    REFERENCES `Bd_proyecto111mil`.`Juego` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `bd_proyecto111mil` ;

-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`ciclolectivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`ciclolectivo` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`ciclolectivo` (
  `id` INT(11) NOT NULL,
  `CicloLectivo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CicloLectivo_UNIQUE` (`CicloLectivo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`tipodeusuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`tipodeusuario` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`tipodeusuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`usuario` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`usuario` (
  `user` INT(11) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `TipoDeUsuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`user`, `TipoDeUsuario_id`),
  UNIQUE INDEX `user_UNIQUE` (`user` ASC) VISIBLE,
  INDEX `fk_Usuario_TipoDeUsuario_idx` (`TipoDeUsuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_TipoDeUsuario`
    FOREIGN KEY (`TipoDeUsuario_id`)
    REFERENCES `bd_proyecto111mil`.`tipodeusuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`docente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`docente` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`docente` (
  `dni` INT(11) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  CONSTRAINT `fk_Docente_Usuario1`
    FOREIGN KEY (`dni`)
    REFERENCES `bd_proyecto111mil`.`usuario` (`user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`materia` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`materia` (
  `id` INT(11) NOT NULL,
  `Materia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Materia_UNIQUE` (`Materia` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`tema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`tema` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`tema` (
  `id` INT(11) NOT NULL,
  `Tema` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Tema_UNIQUE` (`Tema` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`juego`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`juego` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`juego` (
  `id` INT(11) NOT NULL,
  `Descripción` VARCHAR(45) NULL DEFAULT NULL,
  `Creador` INT(11) NOT NULL,
  `CicloLectivo_id` INT(11) NOT NULL,
  `Materia_id` INT(11) NOT NULL,
  `Tema_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Juego_Docente1_idx` (`Creador` ASC) VISIBLE,
  INDEX `fk_Juego_CicloLectivo1_idx` (`CicloLectivo_id` ASC) VISIBLE,
  INDEX `fk_Juego_Materia1_idx` (`Materia_id` ASC) VISIBLE,
  INDEX `fk_Juego_Tema1_idx` (`Tema_id` ASC) VISIBLE,
  CONSTRAINT `fk_Juego_CicloLectivo1`
    FOREIGN KEY (`CicloLectivo_id`)
    REFERENCES `bd_proyecto111mil`.`ciclolectivo` (`id`),
  CONSTRAINT `fk_Juego_Docente1`
    FOREIGN KEY (`Creador`)
    REFERENCES `bd_proyecto111mil`.`docente` (`dni`),
  CONSTRAINT `fk_Juego_Materia1`
    FOREIGN KEY (`Materia_id`)
    REFERENCES `bd_proyecto111mil`.`materia` (`id`),
  CONSTRAINT `fk_Juego_Tema1`
    FOREIGN KEY (`Tema_id`)
    REFERENCES `bd_proyecto111mil`.`tema` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_proyecto111mil`.`alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proyecto111mil`.`alumno` ;

CREATE TABLE IF NOT EXISTS `bd_proyecto111mil`.`alumno` (
  `dni` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `FechaDeNacimiento` DATE NOT NULL,
  `Juego_id` INT(11) NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_Alumno_Usuario1_idx` (`dni` ASC) VISIBLE,
  INDEX `fk_Alumno_Juego1_idx` (`Juego_id` ASC) VISIBLE,
  CONSTRAINT `fk_Alumno_Juego1`
    FOREIGN KEY (`Juego_id`)
    REFERENCES `bd_proyecto111mil`.`juego` (`id`),
  CONSTRAINT `fk_Alumno_Usuario1`
    FOREIGN KEY (`dni`)
    REFERENCES `bd_proyecto111mil`.`usuario` (`user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

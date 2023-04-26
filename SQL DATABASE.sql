-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema AP
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AP
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AP` DEFAULT CHARACTER SET utf8 ;
USE `AP` ;

-- -----------------------------------------------------
-- Table `AP`.`PERSONA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`PERSONA` (
  `DNI` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `APELLIDO` VARCHAR(45) NOT NULL,
  `NACIMIENTO` DATE NULL,
  `TELEFONO` VARCHAR(15) NULL,
  `CORREO` VARCHAR(45) NULL,
  `SOBRE` VARCHAR(200) NULL,
  `URL_FOTO` VARCHAR(100) NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`TIPO_EMPLEO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`TIPO_EMPLEO` (
  `ID` INT NOT NULL,
  `NOMBRE_TIPO` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`EXPERIENCIA_LABORAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`EXPERIENCIA_LABORAL` (
  `PERSONA_DNI` INT NOT NULL,
  `TIPO_EMPLEO_ID` INT NOT NULL,
  `EMPRESA` VARCHAR(45) NULL,
  `TRABAJO` VARCHAR(45) NULL,
  `DESCRIPCION` VARCHAR(45) NULL,
  `INICIO` DATE NULL,
  `FIN` DATE NULL,
  `TRABAJO_ACTUAL` TINYINT NULL,
  PRIMARY KEY (`PERSONA_DNI`, `TIPO_EMPLEO_ID`),
  INDEX `fk_EXPERIENCIA_LABORAL_TIPO_EMPLEO_idx` (`TIPO_EMPLEO_ID` ASC) VISIBLE,
  INDEX `fk_EXPERIENCIA_LABORAL_PERSONA1_idx` (`PERSONA_DNI` ASC) VISIBLE,
  CONSTRAINT `fk_EXPERIENCIA_LABORAL_TIPO_EMPLEO`
    FOREIGN KEY (`TIPO_EMPLEO_ID`)
    REFERENCES `AP`.`TIPO_EMPLEO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EXPERIENCIA_LABORAL_PERSONA1`
    FOREIGN KEY (`PERSONA_DNI`)
    REFERENCES `AP`.`PERSONA` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`EDUCACION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`EDUCACION` (
  `TITULO` VARCHAR(45) NOT NULL,
  `FECHA` YEAR(4) NOT NULL,
  `PERSONA_DNI` INT NOT NULL,
  PRIMARY KEY (`PERSONA_DNI`),
  CONSTRAINT `fk_EDUCACION_PERSONA1`
    FOREIGN KEY (`PERSONA_DNI`)
    REFERENCES `AP`.`PERSONA` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`PROYECTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`PROYECTOS` (
  `idPROYECTOS` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NULL,
  `DESCRIPCION` VARCHAR(100) NULL,
  PRIMARY KEY (`idPROYECTOS`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`USUARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`USUARIOS` (
  `USUARIO` VARCHAR(45) NOT NULL,
  `PWD` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AP`.`TECNOLOGIAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AP`.`TECNOLOGIAS` (
  `Nombre` VARCHAR(50) NULL,
  `DESCRIPCION` VARCHAR(45) NULL,
  `PERSONA_DNI` INT NOT NULL,
  PRIMARY KEY (`PERSONA_DNI`),
  CONSTRAINT `fk_TECNOLOGIAS_PERSONA1`
    FOREIGN KEY (`PERSONA_DNI`)
    REFERENCES `AP`.`PERSONA` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

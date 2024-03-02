-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdtreino
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdtreino
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdtreino` DEFAULT CHARACTER SET utf8 ;
USE `bdtreino` ;

-- -----------------------------------------------------
-- Table `bdtreino`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtreino`.`tb_usuario` (
  `idtb_usuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipoUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtb_usuario`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bdtreino`.`tb_exercicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtreino`.`tb_exercicios` (
  `idtb_exercicios` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeExercicio` VARCHAR(45) NOT NULL,
  `series` INT(11) NOT NULL,
  `reps` INT(11) NOT NULL,
  `tipoExercicio` VARCHAR(45) NULL DEFAULT NULL,
  `id_treino` INT(11) NOT NULL,
  PRIMARY KEY (`idtb_exercicios`),
  UNIQUE INDEX `idtb_exercicios_UNIQUE` (`idtb_exercicios` ASC),
    CONSTRAINT `fk_tb_treinos_tb_treinos1`
    FOREIGN KEY (`id_treino`)
    REFERENCES `bdtreino`.`tb_treinos` (`idtb_treinos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `bdtreino`.`tb_treinos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtreino`.`tb_treinos` (
  `idtb_treinos` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `nomeTreino` VARCHAR(45) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`idtb_treinos`),
  CONSTRAINT `fk_tb_treinos_tb_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `bdtreino`.`tb_usuario` (`idtb_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


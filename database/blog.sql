SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `blog` ;
CREATE SCHEMA IF NOT EXISTS `blog` DEFAULT CHARACTER SET utf8 ;
USE `blog` ;

-- -----------------------------------------------------
-- Table `blog`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `blog`.`usuario` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellidos` VARCHAR(45) NULL ,
  `correo` VARCHAR(100) NOT NULL ,
  `alias` VARCHAR(45) NOT NULL ,
  `contrasena` VARCHAR(45) NOT NULL ,
  `fecha_de_registro` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) ,
  UNIQUE INDEX `alias_UNIQUE` (`alias` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog`.`entrada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog`.`entrada` ;

CREATE  TABLE IF NOT EXISTS `blog`.`entrada` (
  `entrada` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(100) NOT NULL ,
  `fecha_de_creacion` TIMESTAMP NOT NULL ,
  `fecha_de_modificacion` TIMESTAMP NULL ,
  `estado` SET('visible', 'no:visible', 'bloqueado', 'spam') NOT NULL ,
  `contenido` TEXT NOT NULL ,
  `usuario_id` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`entrada`) ,
  INDEX `fk_entrada_usuario_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_entrada_usuario`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `blog`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO blog.usuario (
  nombre,
  apellidos,
  correo,
  alias,
  contrasena,
  fecha_de_registro
) VALUES (
  'Gerardo',
  'Aquino',
  'java.daba.doo@correo.com',
  'java.daba.doo',
  'contraseña',
  NOW()
);

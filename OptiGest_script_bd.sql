-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema OptiGest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema OptiGest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OptiGest` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema optigest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema optigest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `optigest` DEFAULT CHARACTER SET utf8 ;
USE `OptiGest` ;

-- -----------------------------------------------------
-- Table `OptiGest`.`Documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Documento` (
  `id_documento` INT NOT NULL AUTO_INCREMENT,
  `descripcion_doc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_documento`),
  UNIQUE INDEX `descripcion_doc_UNIQUE` (`descripcion_doc` ) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT,
  `descripcion_roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idroles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Estado_Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Estado_Personal` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `descripcion_estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Personal` (
  `id_personal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `identificacion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NULL,
  `Documento_id_documento` INT NOT NULL,
  `roles_idroles` INT NOT NULL,
  `Estado_Personal_id_estado` INT NOT NULL,
  PRIMARY KEY (`id_personal`),
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ) ,
  INDEX `fk_Personal_Documento1_idx` (`Documento_id_documento` ) ,
  INDEX `fk_Personal_roles1_idx` (`roles_idroles` ) ,
  INDEX `fk_Personal_Estado_Personal1_idx` (`Estado_Personal_id_estado` ) ,
  CONSTRAINT `fk_Personal_Documento1`
    FOREIGN KEY (`Documento_id_documento`)
    REFERENCES `OptiGest`.`Documento` (`id_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personal_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `OptiGest`.`Roles` (`idroles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personal_Estado_Personal1`
    FOREIGN KEY (`Estado_Personal_id_estado`)
    REFERENCES `OptiGest`.`Estado_Personal` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Estado_Activo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Estado_Activo` (
  `idEstado_Activo` INT NOT NULL AUTO_INCREMENT,
  `descripcion_activo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstado_Activo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Categorias` (
  `idCategorias` INT NOT NULL AUTO_INCREMENT,
  `descripcionCategoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Proveedores` (
  `idProveedores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveedores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Activos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Activos` (
  `id_activos` INT NOT NULL AUTO_INCREMENT,
  `codigo_act` VARCHAR(45) NOT NULL,
  `nombre_activos` VARCHAR(45) NOT NULL,
  `valor` VARCHAR(45) NOT NULL,
  `fecha_adquma` VARCHAR(45) NOT NULL,
  `fecha_devolucion` VARCHAR(45) NOT NULL,
  `vida_util` VARCHAR(45) NOT NULL,
  `Estado_Activo_idEstado_Activo` INT NOT NULL,
  `Categorias_idCategorias` INT NOT NULL,
  `Proveedores_idProveedores` INT NOT NULL,
  PRIMARY KEY (`id_activos`),
  UNIQUE INDEX `fecha_adquma_UNIQUE` (`fecha_adquma` ) ,
  UNIQUE INDEX `fecha_devolucion_UNIQUE` (`fecha_devolucion` ) ,
  UNIQUE INDEX `codigo_act_UNIQUE` (`codigo_act` ) ,
  INDEX `fk_Activos_Estado_Activo1_idx` (`Estado_Activo_idEstado_Activo` ) ,
  INDEX `fk_Activos_Categorias1_idx` (`Categorias_idCategorias` ) ,
  INDEX `fk_Activos_Proveedores1_idx` (`Proveedores_idProveedores` ) ,
  CONSTRAINT `fk_Activos_Estado_Activo1`
    FOREIGN KEY (`Estado_Activo_idEstado_Activo`)
    REFERENCES `OptiGest`.`Estado_Activo` (`idEstado_Activo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activos_Categorias1`
    FOREIGN KEY (`Categorias_idCategorias`)
    REFERENCES `OptiGest`.`Categorias` (`idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activos_Proveedores1`
    FOREIGN KEY (`Proveedores_idProveedores`)
    REFERENCES `OptiGest`.`Proveedores` (`idProveedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.` Asignaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Asignaciones` (
  `id_asignaciones` INT NOT NULL,
  `fecha_asignaciones` VARCHAR(45) NOT NULL,
  `fecha_devolucion` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  `Personal_id_personal` INT NOT NULL,
  `Activos_id_activos` INT NOT NULL,
  PRIMARY KEY (`id_asignaciones`),
  UNIQUE INDEX `id Asignaciones_UNIQUE` (`id_asignaciones` ) ,
  UNIQUE INDEX `fecha_asignaciones_UNIQUE` (`fecha_asignaciones` ) ,
  UNIQUE INDEX `fecha_devolucion_UNIQUE` (`fecha_devolucion` ) ,
  UNIQUE INDEX `observaciones_UNIQUE` (`observaciones` ) ,
  INDEX `fk_ Asignaciones_Personal_idx` (`Personal_id_personal` ) ,
  INDEX `fk_ Asignaciones_Activos1_idx` (`Activos_id_activos` ) ,
  CONSTRAINT `fk_ Asignaciones_Personal`
    FOREIGN KEY (`Personal_id_personal`)
    REFERENCES `OptiGest`.`Personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ Asignaciones_Activos1`
    FOREIGN KEY (`Activos_id_activos`)
    REFERENCES `OptiGest`.`Activos` (`id_activos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Mantenimiento` (
  `id_mantenimiento` INT NOT NULL AUTO_INCREMENT,
  `fecha_mante` VARCHAR(45) NOT NULL,
  `costo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `Activos_id_activos` INT NOT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  UNIQUE INDEX `ecffsf_UNIQUE` (`fecha_mante` ) ,
  UNIQUE INDEX `idMantenimiento_UNIQUE` (`id_mantenimiento` ) ,
  UNIQUE INDEX `costo_UNIQUE` (`costo` ) ,
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ) ,
  INDEX `fk_Mantenimiento_Activos1_idx` (`Activos_id_activos` ) ,
  CONSTRAINT `fk_Mantenimiento_Activos1`
    FOREIGN KEY (`Activos_id_activos`)
    REFERENCES `OptiGest`.`Activos` (`id_activos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Horarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Horarios` (
  `id_horarios` INT NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` VARCHAR(45) NOT NULL,
  `fecha_salida` VARCHAR(45) NOT NULL,
  `Horarioscod` INT NOT NULL,
  PRIMARY KEY (`id_horarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Dias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Dias` (
  `idDias` INT NOT NULL AUTO_INCREMENT,
  `descripcionDias` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OptiGest`.`Programacion_Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OptiGest`.`Programacion_Personal` (
  `idProgramacion_Personal` INT NOT NULL AUTO_INCREMENT,
  `descripcion_progracion` VARCHAR(45) NOT NULL,
  `Dias_idDias` INT NOT NULL,
  `Personal_id_personal` INT NOT NULL,
  `Horarios_id_horarios` INT NOT NULL,
  PRIMARY KEY (`idProgramacion_Personal`),
  INDEX `fk_Programacion_Personal_Dias1_idx` (`Dias_idDias` ) ,
  INDEX `fk_Programacion_Personal_Personal1_idx` (`Personal_id_personal` ) ,
  INDEX `fk_Programacion_Personal_Horarios1_idx` (`Horarios_id_horarios` ) ,
  CONSTRAINT `fk_Programacion_Personal_Dias1`
    FOREIGN KEY (`Dias_idDias`)
    REFERENCES `OptiGest`.`Dias` (`idDias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Programacion_Personal_Personal1`
    FOREIGN KEY (`Personal_id_personal`)
    REFERENCES `OptiGest`.`Personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Programacion_Personal_Horarios1`
    FOREIGN KEY (`Horarios_id_horarios`)
    REFERENCES `OptiGest`.`Horarios` (`id_horarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


USE `optigest` ;

-- -----------------------------------------------------
-- Table `optigest`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`categorias` (
  `idCategorias` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcionCategoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`estado_activo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`estado_activo` (
  `idEstado_Activo` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_activo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstado_Activo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`proveedores` (
  `idProveedores` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveedores`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`activos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`activos` (
  `id_activos` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_act` VARCHAR(45) NOT NULL,
  `nombre_activos` VARCHAR(45) NOT NULL,
  `valor` VARCHAR(45) NOT NULL,
  `fecha_adquma` VARCHAR(45) NOT NULL,
  `fecha_devolucion` VARCHAR(45) NOT NULL,
  `Estado_Activo_idEstado_Activo` INT(11) NOT NULL,
  `Categorias_idCategorias` INT(11) NOT NULL,
  `Historial_activos_idHistorial_activos` INT(11) NOT NULL,
  `Proveedores_idProveedores` INT(11) NOT NULL,
  PRIMARY KEY (`id_activos`),
  UNIQUE INDEX `fecha_adquma_UNIQUE` (`fecha_adquma` ) ,
  UNIQUE INDEX `fecha_devolucion_UNIQUE` (`fecha_devolucion` ) ,
  UNIQUE INDEX `codigo_act_UNIQUE` (`codigo_act` ) ,
  INDEX `fk_Activos_Estado_Activo1_idx` (`Estado_Activo_idEstado_Activo` ) ,
  INDEX `fk_Activos_Categorias1_idx` (`Categorias_idCategorias` ) ,
  INDEX `fk_Activos_Historial_activos1_idx` (`Historial_activos_idHistorial_activos` ) ,
  INDEX `fk_Activos_Proveedores1_idx` (`Proveedores_idProveedores` ) ,
  CONSTRAINT `fk_Activos_Categorias1`
    FOREIGN KEY (`Categorias_idCategorias`)
    REFERENCES `optigest`.`categorias` (`idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activos_Estado_Activo1`
    FOREIGN KEY (`Estado_Activo_idEstado_Activo`)
    REFERENCES `optigest`.`estado_activo` (`idEstado_Activo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activos_Historial_activos1`
    FOREIGN KEY (`Historial_activos_idHistorial_activos`)
    REFERENCES `optigest`.`historial_activos` (`idHistorial_activos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activos_Proveedores1`
    FOREIGN KEY (`Proveedores_idProveedores`)
    REFERENCES `optigest`.`proveedores` (`idProveedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`documento` (
  `id_documento` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_doc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_documento`),
  UNIQUE INDEX `descripcion_doc_UNIQUE` (`descripcion_doc` ) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`estado_personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`estado_personal` (
  `id_estado` INT(11) NOT NULL AUTO_INCREMENT,
  `descriipcion_estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`roles` (
  `idroles` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idroles`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`personal` (
  `id_personal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `identificacion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NULL DEFAULT NULL,
  `Documento_id_documento` INT(11) NOT NULL,
  `roles_idroles` INT(11) NOT NULL,
  `Estado_Personal_id_estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_personal`),
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ) ,
  INDEX `fk_Personal_Documento1_idx` (`Documento_id_documento` ) ,
  INDEX `fk_Personal_roles1_idx` (`roles_idroles` ) ,
  INDEX `fk_Personal_Estado_Personal1_idx` (`Estado_Personal_id_estado` ) ,
  CONSTRAINT `fk_Personal_Documento1`
    FOREIGN KEY (`Documento_id_documento`)
    REFERENCES `optigest`.`documento` (`id_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personal_Estado_Personal1`
    FOREIGN KEY (`Estado_Personal_id_estado`)
    REFERENCES `optigest`.`estado_personal` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personal_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `optigest`.`roles` (`idroles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.` asignaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`asignaciones` (
  `id_asignaciones` INT(11) NOT NULL,
  `fecha_asignaciones` VARCHAR(45) NOT NULL,
  `fecha_devolucion` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  `Personal_id_personal` INT(11) NOT NULL,
  `Activos_id_activos` INT(11) NOT NULL,
  PRIMARY KEY (`id_asignaciones`),
  UNIQUE INDEX `id Asignaciones_UNIQUE` (`id_asignaciones` ) ,
  UNIQUE INDEX `fecha_asignaciones_UNIQUE` (`fecha_asignaciones` ) ,
  UNIQUE INDEX `fecha_devolucion_UNIQUE` (`fecha_devolucion` ) ,
  UNIQUE INDEX `observaciones_UNIQUE` (`observaciones` ) ,
  INDEX `fk_ Asignaciones_Personal_idx` (`Personal_id_personal` ) ,
  INDEX `fk_ Asignaciones_Activos1_idx` (`Activos_id_activos` ) ,
  CONSTRAINT `fk_ Asignaciones_Activos1`
    FOREIGN KEY (`Activos_id_activos`)
    REFERENCES `optigest`.`activos` (`id_activos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ Asignaciones_Personal`
    FOREIGN KEY (`Personal_id_personal`)
    REFERENCES `optigest`.`personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`dias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`dias` (
  `idDias` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcionDias` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`horarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`horarios` (
  `id_horarios` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` VARCHAR(45) NOT NULL,
  `fecha_salida` VARCHAR(45) NOT NULL,
  `Horarioscod` INT(11) NOT NULL,
  PRIMARY KEY (`id_horarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`mantenimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`mantenimiento` (
  `id_mantenimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_mante` VARCHAR(45) NOT NULL,
  `costo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `Activos_idActivos` INT(11) NOT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  UNIQUE INDEX `ecffsf_UNIQUE` (`fecha_mante` ) ,
  UNIQUE INDEX `idMantenimiento_UNIQUE` (`id_mantenimiento` ) ,
  UNIQUE INDEX `costo_UNIQUE` (`costo` ) ,
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ) ,
  INDEX `fk_Mantenimiento_Activos1_idx` (`Activos_idActivos` ) ,
  CONSTRAINT `fk_Mantenimiento_Activos1`
    FOREIGN KEY (`Activos_idActivos`)
    REFERENCES `optigest`.`activos` (`id_activos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optigest`.`programacion_personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optigest`.`programacion_personal` (
  `idProgramacion_Personal` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_progracion` VARCHAR(45) NOT NULL,
  `Dias_idDias` INT(11) NOT NULL,
  `Personal_id_personal` INT(11) NOT NULL,
  `Horarios_id_horarios` INT(11) NOT NULL,
  PRIMARY KEY (`idProgramacion_Personal`),
  INDEX `fk_Programacion_Personal_Dias1_idx` (`Dias_idDias` ) ,
  INDEX `fk_Programacion_Personal_Personal1_idx` (`Personal_id_personal` ) ,
  INDEX `fk_Programacion_Personal_Horarios1_idx` (`Horarios_id_horarios` ) ,
  CONSTRAINT `fk_Programacion_Personal_Dias1`
    FOREIGN KEY (`Dias_idDias`)
    REFERENCES `optigest`.`dias` (`idDias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Programacion_Personal_Horarios1`
    FOREIGN KEY (`Horarios_id_horarios`)
    REFERENCES `optigest`.`horarios` (`id_horarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Programacion_Personal_Personal1`
    FOREIGN KEY (`Personal_id_personal`)
    REFERENCES `optigest`.`personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)activos
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




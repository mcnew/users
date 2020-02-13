CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `edad` INT,
  `fecha_de_alta` DATE NOT NULL DEFAULT CURRENT_DATE,
  `estatus` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`));

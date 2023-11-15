/*
SQLyog Community v12.2.5 (32 bit)
MySQL - 5.5.19 : Database - bd_pqrs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bd_pqrs` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bd_pqrs`;

/*Table structure for table `administradores` */

DROP TABLE IF EXISTS `administradores`;

CREATE TABLE `administradores` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `dependencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `administradores` */

/*Table structure for table `ciudadanos` */

DROP TABLE IF EXISTS `ciudadanos`;

CREATE TABLE `ciudadanos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tiposolicitante` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `numerotelefono` int(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ciudadanos` */

/*Table structure for table `secretariosdespacho` */

DROP TABLE IF EXISTS `secretariosdespacho`;

CREATE TABLE `secretariosdespacho` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `dependencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `secretariosdespacho` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `tipoidentificacion` varchar(255) DEFAULT NULL,
  `numeroidentificacion` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__Constrai_usuario` (`usuario`),
  UNIQUE KEY `UQ__Constrai_numidentificacion` (`numeroidentificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

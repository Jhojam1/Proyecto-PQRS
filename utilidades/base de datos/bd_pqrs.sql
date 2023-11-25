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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `administradores` */

insert  into `administradores`(`id`,`correo`,`dependencia`) values 
(2,'JhojamCaraballo@gmail.com','todas');

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `nombre` varchar(255) DEFAULT NULL,
  `dependencia` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `categorias` */

insert  into `categorias`(`nombre`,`dependencia`) values 
('Instituciones educativas (Casco urbano)',1),
('Instituciones educativas (Corregimientos)',1),
('Cultura',1),
('PAE',1),
('Atencion a inmigrantes',1),
('Otros',1),
('Obras públicas en construccion',2),
('Daños en bienes publicos',2),
('Licencias',2),
('Agua potable y saneamiento basico',2),
('Otros',2);

/*Table structure for table `ciudadanos` */

DROP TABLE IF EXISTS `ciudadanos`;

CREATE TABLE `ciudadanos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tiposolicitante` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `numerotelefono` int(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ciudadanos` */

insert  into `ciudadanos`(`id`,`tiposolicitante`,`correo`,`numerotelefono`,`direccion`) values 
(1,'Persona Natural','JhojamCaraballo@gmail.com',32443,'20 de julio');

/*Table structure for table `dependencias` */

DROP TABLE IF EXISTS `dependencias`;

CREATE TABLE `dependencias` (
  `nombre` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `dependencias` */

insert  into `dependencias`(`nombre`,`id`) values 
('Secretaria de educacion',1),
('Secretaria de planeacion',2),
('Secretaria de salud',3),
('Secretaria de gobierno',4);

/*Table structure for table `secretariosdespacho` */

DROP TABLE IF EXISTS `secretariosdespacho`;

CREATE TABLE `secretariosdespacho` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `dependencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `secretariosdespacho` */

/*Table structure for table `solicitudes` */

DROP TABLE IF EXISTS `solicitudes`;

CREATE TABLE `solicitudes` (
  `tipossolicitud` varchar(255) DEFAULT NULL,
  `dependencia` int(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `descripcionsolicitud` varchar(255) DEFAULT NULL,
  `usuariosolicitud` int(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `respuesta` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `radicado` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`radicado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `solicitudes` */

insert  into `solicitudes`(`tipossolicitud`,`dependencia`,`categoria`,`descripcionsolicitud`,`usuariosolicitud`,`fecha`,`respuesta`,`estado`,`radicado`) values 
('Peticion',1,'PAE','los alimentos estaban vencidos',1,'2023-11-20',NULL,'cancelado',1);

/*Table structure for table `tiposdesolicitud` */

DROP TABLE IF EXISTS `tiposdesolicitud`;

CREATE TABLE `tiposdesolicitud` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tiposdesolicitud` */

insert  into `tiposdesolicitud`(`id`,`nombre`) values 
(1,'Peticion'),
(2,'Queja'),
(3,'Reclamo'),
(4,'Sugerencia');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`nombres`,`apellidos`,`tipoidentificacion`,`numeroidentificacion`,`usuario`,`contraseña`,`rol`) values 
(1,'Jhojam Jesus','Caraballo Tapia','CC','12394857484','Jhojam1','Jhojam1','Ciudadano'),
(2,'Jhojam Jesus','Caraballo Tapia','CC','123467890','Jhojam2','Jhojam2','Administrador');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

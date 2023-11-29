/*
SQLyog Community v12.2.5 (32 bit)
MySQL - 5.5.41 : Database - bd_pqrs
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
  PRIMARY KEY (`id`),
  CONSTRAINT `administrador-usuario` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `administradores` */

insert  into `administradores`(`id`,`correo`) values 
(2,'JhojamCaraballo@gmail.com');

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `dependencia` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria-dependencia` (`dependencia`),
  CONSTRAINT `categoria-dependencia` FOREIGN KEY (`dependencia`) REFERENCES `dependencias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `categorias` */

insert  into `categorias`(`id`,`nombre`,`dependencia`) values 
(1,'Instituciones educativas (Casco urbano)',1),
(2,'Instituciones educativas (Corregimientos)',1),
(3,'Cultura',1),
(4,'PAE',1),
(5,'Atencion a inmigrantes',1),
(6,'Otros',1),
(7,'Obras públicas en construccion',2),
(8,'Daños en bienes publicos',2),
(9,'Licencias',2),
(10,'Agua potable y saneamiento basico',2),
(11,'Otros',2);

/*Table structure for table `ciudadanos` */

DROP TABLE IF EXISTS `ciudadanos`;

CREATE TABLE `ciudadanos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tiposolicitante` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `numerotelefono` int(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `ciudadano-usuario` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ciudadanos` */

insert  into `ciudadanos`(`id`,`tiposolicitante`,`correo`,`numerotelefono`,`direccion`) values 
(1,'Persona Natural','JhojamCaraballo@gmail.com',32443,'20 de julio');

/*Table structure for table `dependencias` */

DROP TABLE IF EXISTS `dependencias`;

CREATE TABLE `dependencias` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `dependencias` */

insert  into `dependencias`(`id`,`nombre`) values 
(1,'Secretaria de educacion'),
(2,'Secretaria de planeacion'),
(3,'Secretaria de salud'),
(4,'Secretaria de gobierno');

/*Table structure for table `secretarios` */

DROP TABLE IF EXISTS `secretarios`;

CREATE TABLE `secretarios` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `dependencia` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `secretarios-dependencia` (`dependencia`),
  CONSTRAINT `secretarios-dependencia` FOREIGN KEY (`dependencia`) REFERENCES `dependencias` (`id`),
  CONSTRAINT `secretarios-usuario` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `secretarios` */

insert  into `secretarios`(`id`,`correo`,`dependencia`) values 
(3,'JhojamCaraballo@gmail.com',2),
(6,'JhojamCaraballo@gmail.com',1),
(8,'JhojamCaraballo@gmail.com',1),
(9,'jhojam@gmail.com',4),
(10,'Jhojam@gmail.com',3),
(12,'prueba@gmail.com',1);

/*Table structure for table `solicitudes` */

DROP TABLE IF EXISTS `solicitudes`;

CREATE TABLE `solicitudes` (
  `tiposolicitud` int(255) DEFAULT NULL,
  `dependencia` int(255) DEFAULT NULL,
  `categoria` int(255) DEFAULT NULL,
  `descripcionsolicitud` varchar(255) DEFAULT NULL,
  `usuariosolicitud` int(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `respuesta` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `radicado` int(255) NOT NULL AUTO_INCREMENT,
  `mediorespuesta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`radicado`),
  KEY `solicitudes-tiposolicitud` (`tiposolicitud`),
  KEY `solicitudes-dependencia` (`dependencia`),
  KEY `solicitudes-categoria` (`categoria`),
  KEY `solicitudes-usuario` (`usuariosolicitud`),
  CONSTRAINT `solicitudes-categoria` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `solicitudes-dependencia` FOREIGN KEY (`dependencia`) REFERENCES `dependencias` (`id`),
  CONSTRAINT `solicitudes-tiposolicitud` FOREIGN KEY (`tiposolicitud`) REFERENCES `tiposdesolicitud` (`id`),
  CONSTRAINT `solicitudes-usuario` FOREIGN KEY (`usuariosolicitud`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `solicitudes` */

insert  into `solicitudes`(`tiposolicitud`,`dependencia`,`categoria`,`descripcionsolicitud`,`usuariosolicitud`,`fecha`,`respuesta`,`estado`,`radicado`,`mediorespuesta`) values 
(1,1,4,'prueba',1,'2023-11-25',NULL,'Pendiente',1,'Direccion'),
(1,1,1,'prueba',1,'2023-11-28',NULL,'Cancelada',2,'Direccion'),
(1,1,4,'prueba',1,'2023-11-28',NULL,'Pendiente',3,'Direccion'),
(1,2,7,'asd',1,'2023-11-28',NULL,'Pendiente',4,'Correo Electronico');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`nombres`,`apellidos`,`tipoidentificacion`,`numeroidentificacion`,`usuario`,`contraseña`,`rol`) values 
(1,'Pablito Jose','Perez Perez','CC','12394857484','Jhojam1','Jhojam1','Ciudadano'),
(2,'Jhojam','Caraballo','CC','123467890','Jhojam2','Jhojam2','Administrador'),
(3,'Jhojam Jesus','Caraballo Tapia','CC','847577475','Jhojam3','Jhojam3','Secretario de despacho'),
(5,'Jhojam ','Caraballo','CC','3123123213','Jhojam','Jhojam','Secretario de despacho'),
(6,'Jhojam ','Caraballo','TI','12312332','Jhojam4','Jhojam4','Secretario de despacho'),
(8,'Jhojam ','Caraballo','CC','65756756756','Jhojam6','Jhojam6','Secretario de despacho'),
(9,'pablo','perez','CC','123123123','Jhojam10','Jhojam10','Secretario de despacho'),
(10,'Jhojam','Jhojam','TI','23123123','Jhojam9','Jhojam9','Secretario de despacho'),
(12,'Secretario','Prueba','TI','1234','prueba','prueba','Secretario de despacho');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

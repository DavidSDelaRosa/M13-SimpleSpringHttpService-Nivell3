CREATE DATABASE  IF NOT EXISTS `modulo13itacademy`/*!40100 DEFAULT CHARACTER SET latin1 */;
USE `modulo13itacademy`;


DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) DEFAULT NULL,
  `apellido` varchar(35) DEFAULT NULL,
  `puesto` varchar(35) DEFAULT NULL,
  `salario` decimal(9,2) DEFAULT NULL,   
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


LOCK TABLES `empleados` WRITE;


INSERT INTO `empleados` VALUES 
	(1,'David', 'Serrano','Portador_del_Anillo',100000.5),
	(2,'Sergio','Serrano','Administrador_de_la_llama_de_Anor',80000.75),
	(3,'Victor','Izquierdo','Posadero_en_Hobbiton',10000.5),
	(4,'Nem','Sebastian','Istari_Junior',18000),
	(5,'Diego','Royo','Istari_Senior',35000),
	(6,'Asier','Areizaga','Senescal_de_Gondor',75000.5),
	(7,'Alicia','Felipe','Jinete_de_Rohan',25000.5),
	(8,'Victor','Felipe','Lider_de_los_Nueve',90000.3),
	(9,'Andrea','Sebastian','Lugarteniente_de_Mordor',65000),
	(10,'Dani','Galvan','Lider_de_los_Istari', 80000),
	(11,'Manuel','Lorenzo','Señor_de_Rivendel',57500),
	(12,'Anna','Moreno','Montaraz_a_sueldo', 0);


UNLOCK TABLES;
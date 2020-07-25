BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `car` (
	`id`	INTEGER,
	`manufacturer`	TEXT,
	`model`	TEXT,
	`description`	TEXT,
	`price`	INTEGER,
	`customer`	INTEGER,
	FOREIGN KEY(`customer`) REFERENCES `customer`,
	PRIMARY KEY(`id`)
);
INSERT INTO `car` VALUES (1,'Skoda','Skoda Fabia','OPIS',40,1);
INSERT INTO `car` VALUES (2,'Opel','Opel Mocca','OPIS',60,2);
CREATE TABLE IF NOT EXISTS `customer` (
	`id`	INTEGER,
	`name`	TEXT,
	`email`	TEXT,
	`car`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `customer` VALUES (1,'Elma Trako','elmatrako1@gmail.com',1);
INSERT INTO `customer` VALUES (2,'Belma Trako','belmatrako1@gmail.com',2);
COMMIT;
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `demodata`.`transfer`
(
  `transfer_order_id` INT NOT NULL,
  `transfer_table` INT NOT NULL,
  `transfer_total_order` DOUBLE NOT NULL,
  `transfer_number` INT NOT NULL,
  `transfer_is_service` VARCHAR(5) DEFAULT 'true',
  `transfer_order_text` VARCHAR(350),
  CONSTRAINT `transfer_is_service` CHECK ((`transfer_is_service` in ('true','false'))),
  PRIMARY KEY (`transfer_order_id`)
 );

DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
                        `id` INT NOT NULL,
                        `dishname` varchar(30) NOT NULL,
                        `price` double NOT NULL,
                        `typedish` varchar(15) DEFAULT NULL,
                        `description` varchar(80) DEFAULT NULL,
                        `itemnumber`  INT NOT NULL AUTO_INCREMENT,
                        PRIMARY KEY (`itemnumber`)
);

INSERT INTO `dish` VALUES ('1','EGGS',2.3,'breakfast',NULL, '1'),
                          ('2','CHEESE',3,'breakfast',NULL, '2'),
                          ('3','TOAST',3.2,'breakfast',NULL, '3'),
                          ('4','SCONES',2.5,'breakfast',NULL, '4'),
                          ('1','CREAM SOUP',9.6,'lunch',NULL, '5'),
                          ('2','POTATO SALAD',7.5,'lunch',NULL, '6'),
                          ('3','PIZZA',12.8,'lunch',NULL, '7'),
                          ('4','CAESAR SALAD',14.3,'lunch',NULL, '8'),
                          ('5','RIBES',16.2,'lunch',NULL, '9'),
                          ('6','CHEF SPECIAL',18,'lunch',NULL, '10'),
                          ('7','SPICY WINGS',11.2,'lunch',NULL, '11'),
                          ('8','FRI POTATO',8,'lunch',NULL, '12'),
                          ('1','MET BBQ',15.5,'dinner',NULL, '13'),
                          ('2','FRIED LAMB',17.8,'dinner',NULL, '14'),
                          ('3','MET FISH',15,'dinner',NULL, '15'),
                          ('4','GRILLED SEA',16.8,'dinner',NULL, '16'),
                          ('5','BEEF BURGER',12.5,'dinner',NULL, '17'),
                          ('6','GREEN SPINACH',10,'dinner',NULL, '18'),
                          ('7','SIDES',8.5,'dinner',NULL, '19'),
                          ('8','CHICKEN CURRY',13.5,'dinner',NULL, '20'),
                          ('1','TEA',2,'drinks',NULL, '21'),
                          ('2','COFFEE',3.2,'drinks',NULL, '22'),
                          ('3','PEPSI',3.7,'drinks',NULL, '23'),
                          ('4','WINE',7.5,'drinks',NULL, '24')
;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `demodata`.`orders`
(
  `orders_id` INT NOT NULL,
  `orders_table` INT NOT NULL,
  `orders_dish` VARCHAR(30) NOT NULL,
  `orders_price` DOUBLE NOT NULL,
  `orders_amount` INT NOT NULL,
  `orders_total` DOUBLE NOT NULL,
  `orders_service` VARCHAR(5) DEFAULT 'null',
  `orders_pk` INT NOT NULL AUTO_INCREMENT,
  CONSTRAINT `orders_service` CHECK ((`orders_service` in ('true','false', 'null'))),
  PRIMARY KEY (`orders_pk`)
 );

 DROP TABLE IF EXISTS `report`;
 CREATE TABLE `demodata`.`report`
 (
   `report_id` INT NOT NULL,
   `report_table` INT NOT NULL,
   `report_dish` VARCHAR(30) NOT NULL,
   `report_price` DOUBLE NOT NULL,
   `report_amount` INT NOT NULL,
   `report_total` DOUBLE NOT NULL,
   `report_service` VARCHAR(5) DEFAULT 'null',
   `report_pk` INT NOT NULL AUTO_INCREMENT,
   CONSTRAINT `report_service` CHECK ((`report_service` in ('true','false', 'null'))),
   PRIMARY KEY (`report_pk`)
  );

DROP TABLE IF EXISTS `userdata`;
CREATE TABLE `userdata` (
                            `pin` varchar(4) NOT NULL PRIMARY KEY UNIQUE,
                            `firstname` varchar(25) NOT NULL,
                            `lastname` varchar(25) NOT NULL,
                            `age` tinyint NOT NULL,
                            `gender` varchar(6) NOT NULL DEFAULT 'male',
                            `email` varchar(40) DEFAULT NULL,
                            `phone` varchar(12) NOT NULL,
                            `address` varchar(30) DEFAULT NULL,
                            `city` varchar(20) DEFAULT NULL,
                            `country` varchar(20) DEFAULT NULL,
                            `ismanager` varchar(5) NOT NULL DEFAULT 'false',
                            `pps` varchar(8) NOT NULL UNIQUE,
                            CONSTRAINT `userdata_chk_1` CHECK ((`gender` in ('male','female'))),
                            CONSTRAINT `userdata_chk_2` CHECK ((`ismanager` in ('true','false')))
);


INSERT INTO `userdata` VALUES
('1234','Pilot','Flyer',54,'male','pilotfliyer54@gmail.com','584586558','Journey street 45','Dublin','Ireland','true','123456AB'),
('5678','Pony','Tall',28,'female','pinkywinky555@gmail.com','850450807','Hide Park av. 14','NewYork','USA','false','856756SA');

DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
                         `array_line` VARCHAR(350) NOT NULL,
                         `array_id` SMALLINT  NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY (`array_id`)
);

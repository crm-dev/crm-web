
create database crmdb

use crmdb;
grant all on crmdb.* to 'cag'@'localhost' identified by 'test';

(class)//TODO : Sonra 
create table clientTitle {
	id INT(11) NOT NULL AUTO_INCREMENT,
	titleName VARCHAR(256),
    PRIMARY KEY (`id`)
} ENGINE=InnoDB AUTO_INCREMENT=1

create table clientOrganizationAddress {
	clientOrganizationId INT(11) NOT NULL,
	addressId INT(11) NOT NULL,
	createdAt TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	/*TODO : compositeId*/
} 



(class)
create table address {
	id INT(11) NOT NULL AUTO_INCREMENT,
	createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	/*references : SEMT,İL,İLÇE*/	
    PRIMARY KEY (`id`)
} ENGINE=InnoDB AUTO_INCREMENT=1

/*-------------------------------------------------------------------*/

CREATE TABLE `adminUser` (
	id INT(11) NOT NULL AUTO_INCREMENT,
        userName VARCHAR(256),
	password VARCHAR(256),
        createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;


CREATE TABLE `address` (
	id INT(11) NOT NULL AUTO_INCREMENT,
        organizationId INT(11) NOT NULL DEFAULT 0,
	addressDescription VARCHAR(256),
        createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;


CREATE TABLE `product` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	productName VARCHAR(256),
        price FLOAT(11) NOT NULL DEFAULT 0,
	createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;


CREATE TABLE `clientOrganization` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	organizationName VARCHAR(256),
	title INT(11), /*reference*/
	createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `serviceOrder` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    serviceName VARCHAR(256),
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `productionType` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    typeName VARCHAR(256),
    seniorType INT(11) NOT NULL DEFAULT 0,
    isMainType INT(11) NOT NULL DEFAULT 0,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `orderType` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    typeName VARCHAR(256),
    seniorType INT(11) NOT NULL DEFAULT 0,
    isMainType INT(11) NOT NULL DEFAULT 0,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `orderPot` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    productId INT(11) NOT NULL DEFAULT 0,
    quantity INT(11) NOT NULL DEFAULT 0,
    price FLOAT(11) NOT NULL DEFAULT 0,/*service : MALIYET(Ana Başlık)*/
    clientOrganizationAddressId INT(11) NOT NULL,
    orderTypeId INT(11) NOT NULL DEFAULT 0,
    productionTypeId INT(11) NOT NULL DEFAULT 0,
    isComplete INT(11) NOT NULL DEFAULT 0,
    deliveryAt DATE DEFAULT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `serviceOrderPot` (
    orderPotId INT(11) NOT NULL,
    serviceOrderId INT(11) NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`orderPotId`, `serviceOrderId`)
) ENGINE=InnoDB CHARSET=utf8;
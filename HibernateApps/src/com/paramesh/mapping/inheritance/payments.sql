-- Table per class
CREATE TABLE Payments (
  paymentId int(10) unsigned NOT NULL AUTO_INCREMENT,
  customerName varchar(50),
  paymentAmount varchar(50),
  cashPaymentId varchar(255),
  personName varchar(255),
  chequePaymentId varchar(255),
  chequeType varchar(255),
  chequeHolderName varchar(255),
  type varchar(255),
  PRIMARY KEY (paymentId) 
);

----- End--
-- Table per Concrete class
CREATE TABLE PAYMENTS (
  paymentId int(10) unsigned NOT NULL AUTO_INCREMENT,
  customerName varchar(50),
  paymentAmount varchar(50),
  PRIMARY KEY (paymentId) 
);

CREATE TABLE CASH_PAYMENTS (
  paymentId int(10) unsigned NOT NULL AUTO_INCREMENT,
  customerName varchar(50),
  paymentAmount varchar(50),
  cashPaymentId varchar(50),
  personName varchar(50),
  PRIMARY KEY (paymentId) 
);

CREATE TABLE CHEQUE_PAYMENTS (
  paymentId int(10) unsigned NOT NULL AUTO_INCREMENT,
  customerName varchar(50),
  paymentAmount varchar(50),
  chequePaymentId varchar(50),
  chequeType varchar(50),
  chequeHolderName varchar(50),
  PRIMARY KEY (paymentId) 
);


------- End---
Table per sub class.

CREATE TABLE PAYMENTS (
  paymentId int(10),
  customerName varchar(50),
  paymentAmount varchar(50),
  PRIMARY KEY (paymentId) 
);

CREATE TABLE CASH_PAYMENTS ( 
  paymentId int(10),
  cashPaymentId varchar(50),
  personName varchar(50),
  FOREIGN KEY (paymentId) REFERENCES  PAYMENTS(paymentId)
);

CREATE TABLE CHEQUE_PAYMENTS (
  paymentId int(10),
  chequePaymentId varchar(50),
  chequeType varchar(50),
  chequeHolderName varchar(50),
  FOREIGN KEY (paymentId) REFERENCES  PAYMENTS(paymentId)
);

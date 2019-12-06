
CREATE TABLE customer_address (
  CUST_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  CUST_NAME varchar(10) NOT NULL,
  AGE int(10) unsigned NOT NULL,
  ADDRESS1 varchar(255) NOT NULL,
  ADDRESS2 varchar(255) NOT NULL,
  ADDRESS3 varchar(255) NOT NULL,
  CREATED_DATE date NOT NULL,
  CREATED_BY varchar(10) NOT NULL,
  PRIMARY KEY (CUST_ID) 
);


select * FROM customer_address;
drop TABLE customer_address;
commit;
CREATE DATABASE IF NOT EXISTS `PckgDB`;

USE `PckgDB`;

CREATE TABLE cl(
client_id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
PRIMARY KEY (client_id)
);



CREATE TABLE packages (
  P_ID INT NOT NULL AUTO_INCREMENT,
  client_id INT NOT NULL,
  destX FLOAT,
  destY FLOAT,
  time_origin DATE,
  PRIMARY KEY (P_ID),
  FOREIGN KEY (client_id) REFERENCES cl(client_id)
);
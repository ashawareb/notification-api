CREATE DATABASE Notification_System;
-- _________________________________
CREATE TABLE Notification_Templates(
	subject VARCHAR(100) NOT NULL,
	body VARCHAR(500) NOT NULL,
	id INT NOT NULL UNIQUE
);
-- _________________________________
ALTER TABLE Notification_Templates
    ADD language VARCHAR(100) NOT NULL;
-- _________________________________
create table sms(
    sender varchar(255),
    receiver varchar(255),
    subject varchar(255),
    body varchar(255),
    language varchar(255),
    id int not null,
    status boolean);
--_________________________________
create table mail(
    sender varchar(255),
    receiver varchar(255),
    subject varchar(255),
    body varchar(255),
    language varchar(255),
    id int not null,
    status boolean);

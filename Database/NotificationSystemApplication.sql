CREATE DATABASE Notification_System;

CREATE TABLE Notification_Templates(
	subject VARCHAR(100) NOT NULL,
	body VARCHAR(500) NOT NULL,
	id INT NOT NULL UNIQUE
);
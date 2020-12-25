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

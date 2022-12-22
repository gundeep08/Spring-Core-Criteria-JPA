CREATE USER IF NOT EXISTS 'prospring5'@'localhost' IDENTIFIED BY 'prospring5';

DROP DATABASE IF EXISTS BOOK_PUBLISHING;
CREATE DATABASE BOOK_PUBLISHING;
USE BOOK_PUBLISHING;
GRANT ALL PRIVILEGES ON BOOK_PUBLISHING.* TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';
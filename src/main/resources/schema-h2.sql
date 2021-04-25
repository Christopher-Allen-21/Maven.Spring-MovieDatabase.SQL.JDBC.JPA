-- DROP TABLE IF EXISTS PERSON;
--
-- CREATE TABLE PERSON (
--   ID INT NOT NULL AUTO_INCREMENT,
--   FIRST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   LAST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   MOBILE VARCHAR2(20) NOT NULL DEFAULT '',
--   BIRTHDAY DATE DEFAULT NULL,
--   HOME_ID SMALLINT DEFAULT NULL,
--   PRIMARY KEY (ID));
--
--   ALTER TABLE PERSON
--   ADD FOREIGN KEY (HOME_ID)
--   REFERENCES HOME(ID);
--
--
-- DROP TABLE IF EXISTS HOME;
--
-- CREATE TABLE HOME (
--   ID INT NOT NULL AUTO_INCREMENT,
--   ADDRESS VARCHAR2(255) not null default '',
--   HOMENUMBER varchar2(255) NOT NULL DEFAULT '',
--   PRIMARY KEY (ID)
-- );
--
-- DROP TABLE IF EXISTS movies;
--
-- CREATE TABLE movies (
--   id INT PRIMARY KEY AUTO_INCREMENT,
--   title VARCHAR2(100) NOT NULL UNIQUE,
--   runtime SMALLINT NOT NULL,
--   genre VARCHAR2(50),
--   imdb_score NUMBER(10,1),
--   rating VARCHAR2(10)
-- );
--
-- -- Tables for in-class example
--
-- DROP TABLE IF EXISTS cars;
--
-- CREATE TABLE cars (
--   id INT NOT NULL AUTO_INCREMENT,
--   make VARCHAR2(50) NOT NULL DEFAULT '',
--   model VARCHAR2(50) NOT NULL DEFAULT '',
--   year VARCHAR2(5) NOT NULL DEFAULT '01907',
--   PRIMARY KEY (id),
--   CONSTRAINT unique_make_model_year UNIQUE (make, model, year)
--
-- );
--
-- DROP TABLE IF EXISTS auto_prices;
--
-- CREATE TABLE auto_prices (
--   id INT PRIMARY KEY AUTO_INCREMENT,
--   car_id INT REFERENCES cars(id),
--   package VARCHAR2(15) NOT NULL,
--   price NUMBER(10,2) NOT NULL CHECK(price > 0),
--   CONSTRAINT unique_package_per_car UNIQUE (car_id, package)
--
--
-- );

CREATE TABLE MOVIES (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    runtime INT NOT NULL,
    genre VARCHAR (50) NOT NULL,
    imdbScore DECIMAL NOT NULL,
    rating VARCHAR (20)
);

INSERT INTO MOVIES
VALUES
    (1,'Howard the Duck',110,'Sci-Fi',4.6,'PG'),
    (2,'Lavalantula',83,'Horror',4.7,'TV-14'),
    (3,'Starship Troopers',129,'Sci-Fi',7.2,'PG-13'),
    (4,'Waltz With Bashir',90,'Documentary',8.0,'R'),
    (5,'Spaceballs',96,'Comedy',7.1,'PG'),
    (6,'Monsters Inc',92,'Animation',8.1,'G');

SELECT * FROM MOVIES WHERE genre='Sci-Fi';
SELECT * FROM MOVIES WHERE imdbScore>6.5;
SELECT * FROM MOVIES WHERE (rating='G' OR RATING='PG') AND runtime<100;
SELECT AVG(runtime) FROM MOVIES WHERE imdbScore<7.5 ORDER BY genre;
UPDATE MOVIES SET rating='R' WHERE title='Starship Troopers';
SELECT id,rating FROM MOVIES WHERE genre='Horror' OR genre='Documentary';
SELECT AVG(imdbScore), MAX(imdbScore), MIN(imdbScore) FROM MOVIES WHERE genre='Sci-Fi' HAVING COUNT(*) > 1;
SELECT AVG(imdbScore), MAX(imdbScore), MIN(imdbScore) FROM MOVIES WHERE genre='Horror' HAVING COUNT(*) > 1;
SELECT AVG(imdbScore), MAX(imdbScore), MIN(imdbScore) FROM MOVIES WHERE genre='Documentary' HAVING COUNT(*) > 1;
SELECT AVG(imdbScore), MAX(imdbScore), MIN(imdbScore) FROM MOVIES WHERE genre='Comedy' HAVING COUNT(*) > 1;
SELECT AVG(imdbScore), MAX(imdbScore), MIN(imdbScore) FROM MOVIES WHERE genre='Animation' HAVING COUNT(*) > 1;
DELETE FROM MOVIES WHERE rating='R';


DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;

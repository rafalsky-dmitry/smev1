CREATE DATABASE smev1
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;

CREATE TABLE request (
 id int PRIMARY KEY,
 login varchar(80),
 pas varchar(80),
 last_name varchar(80),
 first_name varchar(80)
);
 
DROP TABLE request;

Select * from request;
 
INSERT INTO request (id, login, pas, last_name, first_name) VALUES (1, 'log1', 'pas1', 'name1', 'name2');

INSERT INTO request (id, login, pas, last_name, first_name) VALUES (2, 'log2', 'pas2', 'Имя1', 'Имя2');

INSERT INTO request (id, login, pas, last_name, first_name) VALUES (3, 'log3', 'pas3', 'Имя3', 'Имя3');
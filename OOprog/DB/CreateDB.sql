
-- DROP DATABASE IF EXISTS personne;

CREATE DATABASE IF NOT EXISTS personnes;
USE personnes;

CREATE TABLE IF NOT EXISTS personne (
nom VARCHAR(20) NOT NULL,
prenom VARCHAR(20) NOT NULL,
age VARCHAR(20) NOT NULL,
telephone VARCHAR(20) NOT NULL,
PRIMARY KEY(nom)
);

insert into PERSONNE (nom,prenom,age,telephone) values ('Ghilain','Jeremy','30','00001111') ;
insert into PERSONNE (nom,prenom,age,telephone) values ('ONyme','Anne','66','01111110') ;
insert into PERSONNE (nom,prenom,age,telephone) values ('Toulemonde','Personne','99','10000001') ;
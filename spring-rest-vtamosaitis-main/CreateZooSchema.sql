CREATE DATABASE IF NOT EXISTS zoo;
USE zoo;

DROP TABLE IF EXISTS specie_enclosure;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS animal_enclosure;
DROP TABLE IF EXISTS enclosure;
DROP TABLE IF EXISTS specie;

CREATE TABLE specie (
	id int NOT NULL auto_increment,
    specie_name VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE enclosure (
	id int NOT NULL auto_increment,
    type VARCHAR (64),
    PRIMARY KEY (id)
);

CREATE TABLE animal_enclosure (
	id int NOT NULL auto_increment,
    enclosure_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (enclosure_id) REFERENCES enclosure (id)
);

CREATE TABLE animal (
	id int NOT NULL auto_increment,
    animal_name VARCHAR(64),
    specie_id int NOT NULL,
    home_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (specie_id) REFERENCES specie (id),
    FOREIGN KEY (home_id) REFERENCES animal_enclosure (id)
);

CREATE TABLE specie_enclosure (
	specie_id int NOT NULL,
    enclosure_id int NOT NULL,
    PRIMARY KEY (specie_id, enclosure_id),
    FOREIGN KEY (specie_id) REFERENCES specie (id),
    FOREIGN KEY (enclosure_id) REFERENCES enclosure (id)
);
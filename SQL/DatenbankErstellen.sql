DROP DATABASE IF EXISTS cubicfish;

CREATE DATABASE cubicfish;

USE cubicfish;

CREATE TABLE water_requirements (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  celsius_min DOUBLE NOT NULL,
  celsius_max DOUBLE NOT NULL,
  gh_min DOUBLE,
  gh_max DOUBLE,
  kh_min DOUBLE,
  kh_max DOUBLE,
  ph_min DOUBLE,
  ph_max DOUBLE
);

CREATE TABLE space_requirements (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  liter DOUBLE NOT NULL,
  width DOUBLE,
  hight DOUBLE,
  group_size_min INT,
  group_size_max INT

);
CREATE TABLE compatibility (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_diet varchar(255) NOT NULL,
  second_diet varchar(255),
  nature varchar(255) NOT NULL,
  behavior varchar(255) NOT NULL,
  region varchar(255) NOT NULL

);
CREATE TABLE resident_data (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  casual_name varchar(255) NOT NULL,
  scientific_name varchar(255) NOT NULL,
  origin varchar(255) NOT NULL,
  age_expectancy varchar(255),
  info VARCHAR(6553),
  group varchar(255) NOT NULL,
  size_min DOUBLE,
  size_max DOUBLE NOT NULL,
  water_requirements_id INT,
  space_requirements_id INT,
  compatibility_id INT,
  FOREIGN KEY (water_requirements_id) REFERENCES water_requirements(id), 
  FOREIGN KEY (compatibility_id) REFERENCES compatibility(id),
  FOREIGN KEY (space_requirements_id) REFERENCES space_requirements(id) 
);

CREATE TABLE blacklist (
  first_resident_id INT,
  second_resident_id INT,
  FOREIGN KEY (first_resident_id) REFERENCES resident_data(id),
  FOREIGN KEY (second_resident_id) REFERENCES resident_data(id)
);
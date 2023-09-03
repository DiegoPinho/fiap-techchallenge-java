--CREATE DATABASE fiap_techchallenge;

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
);

INSERT INTO users (username, password) VALUES ('admin', 'admin');

CREATE TABLE addresses (
  id SERIAL PRIMARY KEY,
  street VARCHAR(255),
  number INTEGER,
  district VARCHAR(255),
  city VARCHAR(255),
  state VARCHAR(255),
  user_id INTEGER,

  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE homeappliances (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  power INTEGER,
  manufacturer VARCHAR(255),
  voltage INTEGER,
  dailyUse INTEGER,
  user_id INTEGER,
  address_id INTEGER,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE person (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  birthDate DATE,
  gender VARCHAR(10),
  relationship VARCHAR(255),
  id_parent INTEGER REFERENCES person(id) ON DELETE SET NULL,
  user_id INTEGER,
  address_id INTEGER,
  
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE relationships (
  id SERIAL PRIMARY KEY,
  person_id INTEGER REFERENCES person(id),
  relative_id INTEGER REFERENCES person(id),
  relation VARCHAR(255),

  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (relative_id) REFERENCES person(id)
);

CREATE INDEX idx_person_id_parent ON person(id_parent);
ALTER TABLE person ADD CONSTRAINT FK_PARENT_person foreign key (id_parent) references person;

CREATE TABLE consumptions(
  id SERIAL PRIMARY KEY,
  dailyuse INTEGER,
  person_id INTEGER,
  homeappliance_id INTEGER,

  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (homeappliance_id) REFERENCES homeappliances(id)
);
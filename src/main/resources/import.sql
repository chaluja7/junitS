-- noinspection SqlNoDataSourceInspectionForFile
TRUNCATE persons CASCADE;
INSERT INTO persons(id, email, name, surname, token) VALUES(1,'jakub.chalupa@mensa.cz', 'Jakub', 'Chalupa','ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb');
INSERT INTO persons(id, email, name, surname, token) VALUES(2,'aa@bb.cz', 'Tomas', 'Fuk','3e23e8160039594a33894f6564e1b1348bbd7a0088d42c4acb73eeaed59c009d');
INSERT INTO persons(id, email, name, surname, token) VALUES(3,'bb@cc.cz', 'Jiri', 'Amend','2e7d2c03a9507ae265ecf5b5356885a53393a2029d241394997265a1a25aefc6');
INSERT INTO persons(id, email, name, surname, token) VALUES(4,'cc@dd.cz', 'Lukas', 'Ignis','18ac3e7343f016890c510e93f935261169d9e3f565436429830faf0934f4f8e4');
INSERT INTO persons(id, email, name, surname, token) VALUES(5,'dd@ee.cz', 'Petr', 'Kuchar','3f79bb7b435b05321651daefd374cdc681dc06faa65e374e38337b88ca046dea');
ALTER SEQUENCE persons_id_seq RESTART WITH 30;

TRUNCATE roles CASCADE;
INSERT INTO roles(type) VALUES ('ADMIN');
INSERT INTO roles(type) VALUES ('USER');

TRUNCATE person_role CASCADE;
INSERT INTO person_role(person_id, role_id) VALUES (1, 'ADMIN');
INSERT INTO person_role(person_id, role_id) VALUES (1, 'USER');
INSERT INTO person_role(person_id, role_id) VALUES (2, 'ADMIN');
INSERT INTO person_role(person_id, role_id) VALUES (3, 'ADMIN');
INSERT INTO person_role(person_id, role_id) VALUES (4, 'USER');
INSERT INTO person_role(person_id, role_id) VALUES (5, 'USER');

TRUNCATE expirations CASCADE;
INSERT INTO expirations (itemtype, expirationdays) VALUES ('ALLIGATOR', 31);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('BACON', 55);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('BEEF', 65);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('CHICKEN', 27);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('CHUCKER', 59);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('CRAB', 79);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('DUCK', 100);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('EELS', 90);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('FISH', 64);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('FRANKFURTERS', 40);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('GOAT', 60);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('GOOSE', 71);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('GROUSE', 45);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('HAM', 50);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('HARE', 66);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('KIDNEY', 41);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('LAMB', 50);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('LOBSTER', 83);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('MUSSELS', 20);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('MUTTON', 52);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('OPOSSUM', 48);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('OYSTERS', 51);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PARTRIDGE', 87);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PEMMICAN', 65);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PHEASANT', 88);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PORK', 95);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PRAWNS', 41);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('PUFFIN', 79);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('RABBIT', 72);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('REINDEER', 46);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SALMON', 52);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SAUSAGE', 49);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SCRAPPLE', 97);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SEAL', 26);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SHARKMEAT', 74);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SHRIMP', 63);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SNAILS', 81);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SQUIRREL', 74);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('SWEETBREADS', 62);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('TURKEY', 80);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('TURTLE', 71);
INSERT INTO expirations (itemtype, expirationdays) VALUES ('VEAL', 21);

TRUNCATE config CASCADE;
INSERT INTO config(id, date) VALUES (1, '2016-04-19 00:00:00.0');


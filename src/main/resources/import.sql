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
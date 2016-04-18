-- noinspection SqlNoDataSourceInspectionForFile
TRUNCATE persons CASCADE;
ALTER SEQUENCE persons_id_seq RESTART WITH 30;

INSERT INTO persons(id, email, name, surname, token) VALUES(1,'jakub.chalupa@mensa.cz', 'Jakub', 'Chalupa','a');
INSERT INTO persons(id, email, name, surname, token) VALUES(2,'aa@bb.cz', 'Tomas', 'Fuk','b');
INSERT INTO persons(id, email, name, surname, token) VALUES(3,'bb@cc.cz', 'Jiri', 'Amend','c');
INSERT INTO persons(id, email, name, surname, token) VALUES(4,'cc@dd.cz', 'Lukas', 'Ignis','d');
INSERT INTO persons(id, email, name, surname, token) VALUES(5,'dd@ee.cz', 'Petr', 'Kuchar','e');


TRUNCATE roles CASCADE;
INSERT INTO roles(id, type) VALUES (1, 'ADMIN');
INSERT INTO roles(id, type) VALUES (2, 'USER');

TRUNCATE person_role CASCADE;
INSERT INTO person_role(person_id, role_id) VALUES (1, 1);
INSERT INTO person_role(person_id, role_id) VALUES (1, 2);
INSERT INTO person_role(person_id, role_id) VALUES (2, 1);
INSERT INTO person_role(person_id, role_id) VALUES (3, 1);
INSERT INTO person_role(person_id, role_id) VALUES (4, 1);
INSERT INTO person_role(person_id, role_id) VALUES (5, 2);
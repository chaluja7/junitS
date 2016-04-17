-- noinspection SqlNoDataSourceInspectionForFile
TRUNCATE persons CASCADE;
ALTER SEQUENCE persons_id_seq RESTART WITH 1;
INSERT INTO persons(email, name, surname) VALUES('jakub.chalupa@mensa.cz', 'Jakub', 'Chalupa');
INSERT INTO persons(email, name, surname) VALUES('aa@bb.cz', 'Tomas', 'Fuk');
INSERT INTO persons(email, name, surname) VALUES('bb@cc.cz', 'Jiri', 'Amend');
INSERT INTO persons(email, name, surname) VALUES('cc@dd.cz', 'Lukas', 'Ignis');
INSERT INTO persons(email, name, surname) VALUES('dd@ee.cz', 'Petr', 'Kuchar');
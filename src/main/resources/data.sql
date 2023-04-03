DROP TABLE IF EXISTS vehicle;

CREATE TABLE vehicle (
    id INTEGER NOT NULL AUTO_INCREMENT,
    model varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO vehicle (id, model) VALUES (1, 'saepe');
INSERT INTO vehicle (id, model) VALUES (2, 'quae');
INSERT INTO vehicle (id, model) VALUES (3, 'harum');
INSERT INTO vehicle (id, model) VALUES (4, 'sit');
INSERT INTO vehicle (id, model) VALUES (5, 'deleniti');

DROP TABLE IF EXISTS client;

CREATE TABLE client (
    id INTEGER NOT NULL AUTO_INCREMENT,
    firstname varchar(100) NOT NULL,
    lastname varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO client (id, firstname, lastname) VALUES (1, 'Filip', 'Nowak');
INSERT INTO client (id, firstname, lastname) VALUES (2, 'Oliwier', 'Kowalski');
INSERT INTO client (id, firstname, lastname) VALUES (3, 'Alex', 'Testowy');
INSERT INTO client (id, firstname, lastname) VALUES (4, 'Sebastian', 'Test');
INSERT INTO client (id, firstname, lastname) VALUES (5, 'Julian', 'Test');

DROP TABLE IF EXISTS client_has_vehicle;

CREATE TABLE client_has_vehicle (
    id INTEGER NOT NULL AUTO_INCREMENT,
    vehicle_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (1, 1, 1);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (2, 2, 2);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (3, 3, 3);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (4, 4, 4);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (5, 5, 5);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (6, 1, 1);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (7, 2, 2);
INSERT INTO client_has_vehicle (id, vehicle_id, client_id) VALUES (8, 3, 3);
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS client_vehicles;

-- Brand --

CREATE TABLE brand (
    uuid UUID NOT NULL DEFAULT uuid(),
    name varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (uuid)
);

INSERT INTO brand (name) VALUES ('VW T-ROC');
INSERT INTO brand (name) VALUES ('Volvo S90');
INSERT INTO brand (name) VALUES ('VW Golf');
INSERT INTO brand (name) VALUES ('Audi A4');
INSERT INTO brand (name) VALUES ('Fiat Tipo');

-- Vehicle --

CREATE TABLE vehicle (
   uuid UUID NOT NULL DEFAULT uuid(),
   brand_id UUID NOT NULL,
   registration_plate varchar(50) NOT NULL,
   FOREIGN KEY (brand_id) REFERENCES brand (uuid),
   PRIMARY KEY (uuid)
);

-- Client --

CREATE TABLE client (
    uuid UUID NOT NULL DEFAULT uuid(),
    firstname varchar(100) NOT NULL,
    lastname varchar(100) NOT NULL,
    PRIMARY KEY (uuid)
);

INSERT INTO client (firstname, lastname) VALUES ('Filip', 'Nowak');
INSERT INTO client (firstname, lastname) VALUES ('Oliwier', 'Kowalski');
INSERT INTO client (firstname, lastname) VALUES ('Alex', 'Testowy');
INSERT INTO client (firstname, lastname) VALUES ('Sebastian', 'Test');
INSERT INTO client (firstname, lastname) VALUES ('Julian', 'Test');

-- Client Vehicles --

CREATE TABLE client_vehicles (
    uuid UUID NOT NULL DEFAULT uuid(),
    vehicle_id UUID NOT NULL,
    client_id UUID NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehicle (uuid),
    FOREIGN KEY (client_id) REFERENCES client (uuid),
    PRIMARY KEY (uuid)
);

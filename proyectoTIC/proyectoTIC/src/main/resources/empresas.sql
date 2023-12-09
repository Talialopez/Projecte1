CREATE TABLE EMPRESAS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOM VARCHAR(255),
    UBICACIO VARCHAR(255),
    CIUTAT VARCHAR(255),
    PAIS VARCHAR(255)
);

INSERT INTO empresas (nom, ubicacio, ciutat, pais) VALUES
('InnovateTech Solutions', 'Carrer Santa Engracia, 13, 08016', 'Barcelona', 'España'),
('Creative Innovations Co.', 'Av/ Rocaseig 29, 08024', 'Barcelona', 'España'),
('Digital Dream Ventures', 'Carrer Trinxant 124, 08042', 'Barcelona', 'España'),
('FutureTech Enterprises', 'Carrer Progres 12', 'Badalona', 'España'),
('Admira Lab', 'Carrer Xifrer 95, 08041', 'Barcelona', 'España'),
('Inspira Ig', 'Avinguda Diputacio 3, 08062', 'Badalona', 'España'),
('Imaginary Innovators Ltd.', 'Carrer Sant Pau Maig 256', 'Sabadell', 'España'),
('TechGenius Innovations', 'Calle Plaza España 12, 28001', 'Madrid', 'España'),
('DreamTech Solutions', 'Avenida De la Paz 126, 46020', 'Valencia', 'España'),
('Infinite Ideas Corporation', 'Calle Industria 169, 28030', 'Madrid', 'España'),
('EuroTech', 'Rue de la République 15, 75001 ', 'Paris', 'Francia'),
('BerlinCode', 'Friedrichstraße 1, 10117 ', 'Berlin', 'Alemania'),
('Virtual Visionaries Inc.', '404 Virtual Drive', 'Berlin', 'Alemania'),
('TechHub Amsterdam', 'Herengracht 1017 EG ', 'Amsterdam', 'Países Bajos'),
('Visionary Ventures Co.', '808 Vision Road', 'Amsterdam', 'Paises Bajos');

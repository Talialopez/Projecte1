CREATE TABLE ofertas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    idiomas VARCHAR(255),
    conocimientos VARCHAR(255),
    estudios VARCHAR(255),
    descripcion VARCHAR(255),
    requisitos VARCHAR(255) DEFAULT NULL,
    empresa_id BIGINT,
    FOREIGN KEY (empresa_id) REFERENCES empresas(id)
);

-- Ofertas para InnovateTech Solutions
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador Web', 'Inglés Básico', 'HTML, CSS, JavaScript', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Desarrolla y mantiene sitios web interactivos', null ,1);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Asistente de Soporte Técnico', 'Español Nativo', 'Redes', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Brinda soporte técnico a usuarios',  null ,1);

-- Ofertas para Creative Innovations Co.
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Diseñador de Interfaz', 'Inglés Intermedio', 'UI/UX principles, Figma', ' CFGS Desenvolupament d’Aplicacions Web', 'Crea interfaces atractivas y funcionales', null ,2);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Analista de Datos', 'Español Nativo', 'Análisis de datos, SQL', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Analiza datos para informar decisiones comerciales', null ,2);

-- Ofertas para Digital Dream Ventures
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador de Aplicaciones Móviles', 'Inglés Básico', 'Android Studio, Kotlin', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Crea aplicaciones móviles innovadoras', null ,3);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Especialista en Realidad Virtual', 'Español Nativo', 'Unity, VR development', 'CFGS Desenvolupament d’Aplicacions Web', 'Desarrolla experiencias inmersivas de realidad virtual', null ,3);

-- Ofertas para FutureTech Enterprises
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de Redes', 'Inglés Intermedio', 'CCNA, Routing, Switching', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Diseña y gestiona redes informáticas', null ,4);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Analista de Seguridad Informática', 'Español Nativo', 'Ciberseguridad, Ethical Hacking', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Protege la infraestructura informática de la empresa', null ,4);

-- Ofertas para Imaginary Innovators Ltd.
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Diseñador de Videojuegos', 'Inglés Básico', 'Unity, Game Design', 'CFGS Desenvolupament d’Aplicacions Web', 'Crea emocionantes experiencias de juego', null ,5);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Artista 3D', 'Español Nativo', 'Blender, Modelado 3D', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Da vida a mundos virtuales en 3D', null ,5);

-- Ofertas para TechGenius Innovations
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador Full Stack', 'Inglés Intermedio', 'Node.js, React, MongoDB', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Construye aplicaciones web completas', null ,6);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de Inteligencia Artificial', 'Español Nativo', 'Machine Learning, Python', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Desarrolla soluciones de IA innovadoras', null ,6);

-- Ofertas para Virtual Visionaries Inc.
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Diseñador de Experiencia de Usuario (UX)', 'Inglés Avanzado', 'Figma, Usabilidad', 'CFGS Desenvolupament d’Aplicacions Web', 'Crea interfaces intuitivas y atractivas', null ,7);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador de Realidad Aumentada', 'Español Nativo', 'ARKit, Unity', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Combina el mundo real con experiencias digitales', null ,7);

-- Ofertas para DreamTech Solutions
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Analista de Datos', 'Inglés Intermedio', 'SQL, Data Analytics', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Analiza y visualiza grandes conjuntos de datos', null ,8);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Especialista en Ciberseguridad', 'Español Nativo', 'Firewall, Ethical Hacking', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Protege la infraestructura digital de la empresa', null ,8);

-- Ofertas para Infinite Ideas Corporation
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador de Aplicaciones Móviles', 'Inglés Básico', 'Android, Kotlin', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Crea aplicaciones móviles innovadoras', null ,9);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Especialista en Big Data', 'Español Intermedio', 'Hadoop, Spark', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Maneja grandes volúmenes de datos de manera eficiente', null ,9);

-- Ofertas para CodeCrafters Limited
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador Full Stack', 'Inglés Avanzado', 'React, Node.js, MongoDB', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Construye aplicaciones web completas', null ,10);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de Software', 'Español Nativo', 'Java, Spring Boot', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Diseña y desarrolla software robusto y eficiente', null ,10);

-- Ofertas para Data Dynamics LLC
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Analista de Datos', 'Inglés Intermedio', 'Python, Data Analytics', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Analiza y interpreta grandes conjuntos de datos', null ,11);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador de Machine Learning', 'Español Nativo', 'TensorFlow, Python', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Aplica algoritmos de aprendizaje automático', null ,11);

-- Ofertas para Quantum Technologies Inc.
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de Hardware', 'Inglés Avanzado', 'Diseño de circuitos, FPGA', 'CFGS Desenvolupament d’Aplicacions Web', 'Diseña y optimiza circuitos electrónicos', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo',12);
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador Embedded', 'Español Nativo', 'C, Microcontroladores', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Programa sistemas embebidos', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo',12);

-- Ofertas para RoboInnovate Robotics
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de Visión por Computadora', 'Inglés Intermedio', 'OpenCV, Python', 'CFGS Desenvolupament d’Aplicacions Multiplataforma', 'Desarrolla sistemas de visión artificial', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo', 13);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Programador de Robots', 'Español Nativo', 'ROS, C++, Robot Programming', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Programa y controla robots autónomos', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo', 13);

-- Ofertas para Smart Systems Solutions
INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Desarrollador de Sistemas Embebidos', 'Inglés Avanzado', 'C, ARM Cortex', 'CFGS Desenvolupament d’Aplicacions Web', 'Diseña y programa sistemas embebidos', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo', 14);

INSERT INTO ofertas (nom, idiomas, conocimientos, estudios, descripcion, requisitos, empresa_id)
VALUES ('Ingeniero de IoT', 'Español Nativo', 'Internet of Things, Sensores', 'CFGS d’Administració de Sistemes Informàtics en Xarxa', 'Desarrolla soluciones para el Internet de las Cosas', 'Ciudadano de la UE,  Disponibilidad horaria para prácticas DUAL, Buena capacidad de organización y gestión del tiempo', 14);

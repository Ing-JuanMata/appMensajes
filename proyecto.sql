DROP DATABASE IF EXISTS mensajes_app;
CREATE DATABASE mensajes_app;
USE mensajes_app;

DROP TABLE IF EXISTS mensajes;
CREATE TABLE IF NOT EXISTS mensajes(
	id INT NOT NULL,
    mensaje VARCHAR(280),
    autor VARCHAR(50),
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT mensajes_id PRIMARY KEY(id)
);

SELECT * FROM mensajes;
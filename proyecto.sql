DROP DATABASE IF EXISTS mensajes_app;
CREATE DATABASE mensajes_app;
USE mensajes_app;

DROP TABLE IF EXISTS mensajes;
CREATE TABLE IF NOT EXISTS mensajes(
	id INT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(280),
    autor VARCHAR(50),
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT mensajes_id PRIMARY KEY(id)
);

SELECT * FROM mensajes;

SELECT COUNT(*) FROM mensajes;

UPDATE mensajes SET autor="Mata" WHERE id=3;
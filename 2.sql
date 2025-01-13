CREATE TABLE users (
	username varchar(50) primary key,
	password varchar(50) NOT NULL,
	enabled tinyint(1) NOT NULL
);
-- enabled=1 significa usuario activo
-- enabled=0 significa usuario no activo, no puede iniciar sesión.


CREATE TABLE authorities (
	username varchar(50) NOT NULL,
	authority varchar(50) NOT NULL,
	UNIQUE KEY authorities_idx_1 (username, authority),
	FOREIGN KEY (username)REFERENCES users (username)
);


INSERT INTO users VALUES ('amelia','{noop}amelia123',1);
INSERT INTO users VALUES ('carmelo','{noop}carmelo123',1);
INSERT INTO users VALUES ('cristina','{noop}cristina123',1);
-- Con {noop} indicamos a Spring Security que nuestra contraseña no está encriptada.




-- Insertamos (asignamos roles) a nuestros usuarios.
INSERT INTO authorities VALUES ('amelia','PROFESOR');
INSERT INTO authorities VALUES ('carmelo','PROFESOR');
INSERT INTO authorities VALUES ('cristina','PROFESOR');
INSERT INTO authorities VALUES ('cristina','JEFE');

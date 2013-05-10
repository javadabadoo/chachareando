CREATE TABLE usuario (
    id serial NOT NULL primary key,
    nombre character varying(45) NOT NULL,
    apellidos character varying(45),
    correo character varying(100) NOT NULL,
    alias character varying(45) NOT NULL,
    contrasena character varying(45) NOT NULL,
    fecha_de_registro timestamp without time zone NOT NULL
);


CREATE TABLE entrada (
    id serial NOT NULL primary key,
    titulo character varying(100) NOT NULL,
    fecha_de_creacion timestamp without time zone NOT NULL,
    fecha_de_modificacion timestamp without time zone,
    estado character varying(20),
    contenido text NOT NULL,
    usuario_id integer references usuario(id)
);


CREATE TABLE rol (
    id serial NOT NULL primary key,
    clave character varying(15) NOT NULL,
    descripcion text
);


CREATE TABLE usuario_rol (
    id serial NOT NULL primary key,
    id_usuario integer references usuario(id),
    id_rol integer references rol(id)
);


CREATE TABLE imagen
(
  id serial NOT NULL,
  nombre character varying(30) NOT NULL,
  comentario text,
  imagen bytea NOT NULL,
  CONSTRAINT imagen_pkey PRIMARY KEY (id)
);




CREATE TABLE usuario_imagen
(
	id serial NOT NULL,
	id_usuario integer NOT NULL,
	id_imagen integer NOT NULL,
	CONSTRAINT usrimg_pkey PRIMARY KEY (id),
	CONSTRAINT usrimg_usuario_id_fkey FOREIGN KEY (id_usuario) REFERENCES usuario (id),
	CONSTRAINT usrimg_imagen_id_fkey FOREIGN KEY (id_imagen) REFERENCES imagen (id)
);





INSERT INTO usuario (
  nombre,
  apellidos,
  correo,
  alias,
  contrasena,
  fecha_de_registro
) VALUES (
  'Gerardo',
  'Aquino',
  'java.daba.doo@correo.com',
  'java.daba.doo',
  'contraseña',
  NOW()
);


INSERT INTO usuario (
  nombre,
  apellidos,
  correo,
  alias,
  contrasena,
  fecha_de_registro
) VALUES (
  'Jerry',
  'Boy',
  'gerardo.aquino@correo.com',
  'javadabadoo',
  'contraseña',
  NOW()
);





insert into rol (clave, descripcion) values ('ROLE_ADMIN', 'Rol del usuario administrador de la aplicacion');
insert into rol (clave, descripcion) values ('ROLE_USER', 'Rol del usuario estandar de la aplicacion');





insert into usuario_rol (id_usuario, id_rol) values (1, 1);
insert into usuario_rol (id_usuario, id_rol) values (1, 2);
insert into usuario_rol (id_usuario, id_rol) values (2, 2);

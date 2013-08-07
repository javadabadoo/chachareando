CREATE TABLE usuario (
    id serial NOT NULL primary key,
    nombre character varying(45) NOT NULL,
    apellidos character varying(45),
    correo character varying(100) NOT NULL,
    alias character varying(45) NOT NULL,
    contrasena character varying(45) NOT NULL,
    fecha_de_registro timestamp without time zone NOT NULL
);



-- SE ALMACENAN LAS ENTRADAS DE LOS USUARIOS, PUEDEN SER DESDEPUBLICACIONES A
-- BLOG, FOROS, O COMENTARIO SOBRE ALGUNO DE LOS ANTERIORES
--
--  tipo :
--      Indica el tipo de publicacion, se establece el valor
--        'p' -> publicación de blog o foro
--        'c' -> comentario a publicación
--  en_respuesta_de :
--      En caso de ser un comentario a una publicación, se define
--      el ID de la entrada a la que se está comentanto
CREATE TABLE entrada (
    id serial NOT NULL primary key,
    titulo character varying(100) NOT NULL,
    fecha_de_creacion timestamp without time zone NOT NULL,
    fecha_de_modificacion timestamp without time zone,
    estado character varying(20),
    contenido text NOT NULL,
    usuario_id integer references usuario(id),
    tipo character varying(1) default null
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




CREATE TABLE comentarios
(
  id_entrada integer NOT NULL references entrada(id),
  id_comentario integer not null references entrada(id),
  id_comentario_respuesta integer default NULL
);





º




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







insert into entrada(
  titulo,
  fecha_de_creacion,
  fecha_de_modificacion,
  estado,
  contenido,
  usuario_id,
  tipo
) values(
  'Tengo una pregunta',
  now(),
  null,
  'vigente',
  'este es el contenido de mi comentario',
  2,
  'c'
);


insert into entrada(
  titulo,
  fecha_de_creacion,
  fecha_de_modificacion,
  estado,
  contenido,
  usuario_id,
  tipo
) values(
  'Pos esta es la respuesta',
  now(),
  null,
  'vigente',
  'blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah ',
  1,
  'c'
);





insert into tag (nombre) values ('Java');
insert into tag (nombre) values ('Spring');
insert into tag (nombre) values ('Hibernate');
insert into tag (nombre) values ('Groovy');
insert into tag (nombre) values ('Scala');
insert into tag (nombre) values ('JEE');
insert into tag (nombre) values ('JSE');
insert into tag (nombre) values ('JME');
insert into tag (nombre) values ('JSP');
insert into tag (nombre) values ('Servlet');
insert into tag (nombre) values ('Spring-MVC');
insert into tag (nombre) values ('Spring-Roo');
insert into tag (nombre) values ('Spring-Batch');
insert into tag (nombre) values ('Spring-Security');




insert into entrada_tag (entrada_id, tag_id) values (1, 1);
insert into entrada_tag (entrada_id, tag_id) values (1, 4);
insert into entrada_tag (entrada_id, tag_id) values (1, 7);
insert into entrada_tag (entrada_id, tag_id) values (1, 8);
insert into entrada_tag (entrada_id, tag_id) values (2, 2);
insert into entrada_tag (entrada_id, tag_id) values (2, 3);
insert into entrada_tag (entrada_id, tag_id) values (2, 4);
insert into entrada_tag (entrada_id, tag_id) values (2, 9);
insert into entrada_tag (entrada_id, tag_id) values (3, 1);
insert into entrada_tag (entrada_id, tag_id) values (3, 2);
insert into entrada_tag (entrada_id, tag_id) values (3, 3);
insert into entrada_tag (entrada_id, tag_id) values (3, 4);
insert into entrada_tag (entrada_id, tag_id) values (3, 5);
insert into entrada_tag (entrada_id, tag_id) values (3, 10);
insert into entrada_tag (entrada_id, tag_id) values (3, 11);
insert into entrada_tag (entrada_id, tag_id) values (3, 12);
create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table moto (
 id int(11) not null auto_increment,
 precio double not null,
 cc int not null,
 marca varchar(100) not null,
 estado varchar(1) not null,
 descuento int not null,
 nombre_imagen varchar(200) not null,
 nombre_moto varchar(100) not null,

 primary key (id)
);

create table compra (
 id int(11) not null auto_increment,
 id_moto int(11) not null,
 cedula varchar(100) not null,
 nombre_completo varchar(100) not null,
 celular int not null,
 fecha datetime null,
 valor double not null,
 estado varchar(1) not null,
 descuento int not null,

 primary key (id)
);

INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (1, 24500, 1299, 'KTM', 'A', 10, 'super-duke.png', 'Super Duke 1290');
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (2, 22000, 999, 'YAMAHA', 'A', 8, 'r1.png', 'YZF-R1');
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (3, 21000, 999, 'HONDA', 'I', 0, 'cbr.png', 'CBR 1000RR');
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (4, 25000, 1099, 'DUCATI', 'A', 12, 'ducati.png', '1098 Sport');
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (5, 24300, 1199, 'APRILIA', 'A', 15, 'aprilia.png', 'Rsv4');
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto) VALUES (6, 17000, 599, 'YAMAHA', 'A', 9, 'r6.png', 'YZF-R6');
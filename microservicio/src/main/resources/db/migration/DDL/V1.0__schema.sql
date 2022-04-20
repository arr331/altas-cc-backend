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
 cantidad int not null,

 primary key (id)
);

create table compra (
 id int(11) not null auto_increment,
 id_moto int(11) not null,
 cedula varchar(100) not null,
 nombre_completo varchar(100) not null,
 fecha datetime null,
 valor_total double not null,
 abono double not null,
 codigo varchar(10) not null,
 estado varchar(1) not null,

 primary key (id)
);

INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (1, 24500, 1299, 'KTM', 'A', 10, 'super-duke.png', 'Super Duke 1290', 3);
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (2, 22000, 999, 'YAMAHA', 'A', 8, 'r1.png', 'YZF-R1', 2);
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (3, 21000, 999, 'HONDA', 'I', 0, 'cbr.png', 'CBR 1000RR', 1);
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (4, 25000, 1099, 'DUCATI', 'A', 12, 'ducati.png', '1098 Sport', 2);
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (5, 24300, 1199, 'APRILIA', 'A', 15, 'aprilia.png', 'Rsv4', 0);
INSERT INTO moto (id, precio, cc, marca, estado, descuento, nombre_imagen, nombre_moto, cantidad) VALUES (6, 17000, 599, 'YAMAHA', 'A', 9, 'r6.png', 'YZF-R6', 2);

INSERT INTO compra (id, id_moto, cedula, nombre_completo, fecha, valor_total, abono, codigo, estado) VALUES (1, 1, '1040048300', 'Adrian Ramírez', null, 22050, 22050, '2022-1', 'C');
INSERT INTO compra (id, id_moto, cedula, nombre_completo, fecha, valor_total, abono, codigo, estado) VALUES (2, 6, '1040046200', 'Andres Hernández', null, 15470, 15470, '2022-2', 'C');
INSERT INTO compra (id, id_moto, cedula, nombre_completo, fecha, valor_total, abono, codigo, estado) VALUES (3, 3, '39189986', 'Beatriz Osorio', null, 21000, 10500, '2022-3', 'I');
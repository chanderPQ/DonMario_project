create database donmario;
use donmario;
create table distrito(
distrito_id varchar(5) primary key,
nombre varchar(50) not null
);
create table empleado(
empleado_id varchar(5) primary key,
rol enum ('portero','mesero','cocinero','cajero','administrador'),
correo varchar(80) unique not null,
nombre varchar(40) not null,
apellido varchar(40) not null,
clave varchar(40) not null,
distrito_id varchar(5) not null,
foreign key (distrito_id) references distrito(distrito_id)
);
create table mesa(
mesa_id varchar(5)  primary key,
capacidad int not null,
estado enum ('ocupado','libre'),
empleado_id varchar(5) not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table pedido(
pedido_id varchar(5)  primary key,
estado enum('en preparacion','pedido listo'),
empleado_id varchar(5)  not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table menu(
menu_id varchar(5)  primary key,
nombre varchar(80) not null unique,
costo double not null,
empleado_id varchar(5)  not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table menu_pedido(
menu_id varchar(5)  not null,
pedido_id varchar(5)  not null,
cantidad int not null,
foreign key(menu_id) references menu(menu_id),
foreign key(pedido_id) references pedido(pedido_id)
);

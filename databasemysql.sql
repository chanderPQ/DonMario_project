create database donmario;
use donmario;
create table distrito(
distrito_id varchar(10) primary key,
nombre varchar(50) not null
);
create table empleado(
empleado_id varchar(10) primary key,
rol enum ('portero','mesero','cocinero','cajero','administrador'),
correo varchar(80) unique not null,
nombre varchar(40) not null,
apellido varchar(40) not null,
clave varchar(40) not null,
distrito_id varchar(10) not null,
foreign key (distrito_id) references distrito(distrito_id)
);
create table mesa(
mesa_id varchar(10)  primary key,
capacidad int not null,
estado enum ('ocupado','libre'),
empleado_id varchar(10) not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table pedido(
pedido_id varchar(10)  primary key,
estado enum('en preparacion','pedido listo'),
empleado_id varchar(10)  not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table menu(
menu_id varchar(10)  primary key,
nombre varchar(80) not null unique,
costo double not null,
empleado_id varchar(10)  not null,
foreign key(empleado_id) references empleado(empleado_id)
);
create table menu_pedido(
menu_id varchar(10)  not null,
pedido_id varchar(10)  not null,
cantidad int not null,
foreign key(menu_id) references menu(menu_id),
foreign key(pedido_id) references pedido(pedido_id)
);
-- Insertar 9 registros en distrito
INSERT INTO distrito VALUES
('DIS001', 'Miraflores'),
('DIS002', 'San Isidro'),
('DIS003', 'Barranco'),
('DIS004', 'Surco'),
('DIS005', 'La Molina'),
('DIS006', 'San Miguel'),
('DIS007', 'Callao'),
('DIS008', 'Chorrillos'),
('DIS009', 'Pueblo Libre');

-- Insertar 9 registros en empleado
INSERT INTO empleado VALUES
('EMP001', 'portero', 'juan.perez@donmario.com', 'Juan', 'Pérez', 'juan2023', 'DIS001'),
('EMP002', 'mesero', 'luis.gomez@donmario.com', 'Luis', 'Gómez', 'luis1234', 'DIS002'),
('EMP003', 'cocinero', 'ana.lopez@donmario.com', 'Ana', 'Lopez', 'ana4567', 'DIS003'),
('EMP004', 'cajero', 'carlos.sanchez@donmario.com', 'Carlos', 'Sánchez', 'carlos789', 'DIS004'),
('EMP005', 'administrador', 'laura.ramirez@donmario.com', 'Laura', 'Ramirez', 'laura2024', 'DIS005'),
('EMP006', 'mesero', 'pedro.torres@donmario.com', 'Pedro', 'Torres', 'pedro321', 'DIS006'),
('EMP007', 'cocinero', 'lucia.vargas@donmario.com', 'Lucía', 'Vargas', 'lucia567', 'DIS007'),
('EMP008', 'cajero', 'diego.fernandez@donmario.com', 'Diego', 'Fernández', 'diego890', 'DIS008'),
('EMP009', 'portero', 'sofia.rojas@donmario.com', 'Sofía', 'Rojas', 'sofia111', 'DIS009');

-- Insertar 9 registros en mesa
INSERT INTO mesa VALUES
('MES001', 4, 'libre', 'EMP002'),
('MES002', 2, 'ocupado', 'EMP006'),
('MES003', 6, 'libre', 'EMP002'),
('MES004', 4, 'ocupado', 'EMP006'),
('MES005', 2, 'libre', 'EMP002'),
('MES006', 4, 'ocupado', 'EMP006'),
('MES007', 6, 'libre', 'EMP002'),
('MES008', 4, 'ocupado', 'EMP006'),
('MES009', 2, 'libre', 'EMP002');

-- Insertar 9 registros en pedido
INSERT INTO pedido VALUES
('PED001', 'en preparacion', 'EMP003'),
('PED002', 'pedido listo', 'EMP007'),
('PED003', 'en preparacion', 'EMP003'),
('PED004', 'pedido listo', 'EMP007'),
('PED005', 'en preparacion', 'EMP003'),
('PED006', 'pedido listo', 'EMP007'),
('PED007', 'en preparacion', 'EMP003'),
('PED008', 'pedido listo', 'EMP007'),
('PED009', 'en preparacion', 'EMP003');

-- Insertar 9 registros en menu
INSERT INTO menu VALUES
('MEN001', 'Ceviche de pescado', 25.00, 'EMP005'),
('MEN002', 'Lomo saltado', 22.00, 'EMP005'),
('MEN003', 'Ají de gallina', 20.00, 'EMP005'),
('MEN004', 'Arroz con pollo', 18.00, 'EMP005'),
('MEN005', 'Anticuchos', 19.50, 'EMP005'),
('MEN006', 'Seco de cordero', 24.00, 'EMP005'),
('MEN007', 'Papa a la huancaína', 12.00, 'EMP005'),
('MEN008', 'Tacu tacu con lomo', 23.00, 'EMP005'),
('MEN009', 'Chicha morada', 6.00, 'EMP005');

-- Insertar 9 registros en menu_pedido
INSERT INTO menu_pedido VALUES
('MEN001', 'PED001', 2),
('MEN002', 'PED002', 1),
('MEN003', 'PED003', 2),
('MEN004', 'PED004', 1),
('MEN005', 'PED005', 2),
('MEN006', 'PED006', 1),
('MEN007', 'PED007', 3),
('MEN008', 'PED008', 1),
('MEN009', 'PED009', 2);


INSERT INTO TIPOPLAN
(tipo)
VALUES
('N/A');

INSERT INTO TIPOPLAN
(tipo)
VALUES
('PROMOCION_PARTICULAR');

INSERT INTO TIPOPLAN
(tipo)
VALUES
('LARGA_ESTADIA');


INSERT INTO TIPOPLAN
(tipo)
VALUES
('TIEMPO_COMPARTIDO');

INSERT INTO TIPOPLAN
(tipo)
VALUES
('TODO_INCLUIDO');

INSERT INTO TIPODOCUMENTO
(tipo)
VALUES
('CC');

INSERT INTO TIPODOCUMENTO
(tipo)
VALUES
('TI');

INSERT INTO TIPODOCUMENTO
(tipo)
VALUES
('TE');

INSERT INTO TIPOSERVICIO (TIPO) VALUES ('TIENDA');
INSERT INTO TIPOSERVICIO (TIPO) VALUES ('SUPERMERCADO');
INSERT INTO TIPOSERVICIO (TIPO) VALUES ('RESTAURANTE');
INSERT INTO TIPOSERVICIO (TIPO) VALUES ('BAR');
INSERT INTO TIPOSERVICIO (TIPO) VALUES ('SERVICIOSSPA');

INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('CLIENTE');

INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('RECEPCIONISTA');
INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('EMPLEADO');
INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('ADMINISTRADOR');
INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('GERENTE');

INSERT INTO TIPOUSUARIO
(TIPO)
VALUES
('ORGANIZADOR');


INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('SOYADMIN',1000827182,2,2,4,'ADMIN','hello');

INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('CLIENTE',100082719352,2,2,1,'CLIENTE','hello');

INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('RECEPCIONISTA',10002347182,2,2,2,'RECEPCIONISTA','hello');
INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('EMPLEADO',11052347182,2,2,3,'EMPLEADO','hello');
INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('GERENTE',11052347182,2,2,5,'GERENTE','hello');

INSERT INTO USUARIO
(nombre,documento,tipoplan, tipodocumento,tipousuario,login,contrasena)
VALUES
('SOYORGANIZA',1000827182,2,2,6,'ORGANIZADOR','hello');

INSERT INTO TIPOHABITACION
(TIPO, PRECIO, DESCRIPCION)
VALUES
('SUITEPRESIDENCIAL',12341,'caracteristicas:....');

INSERT INTO TIPOHABITACION
(TIPO, PRECIO, DESCRIPCION)
VALUES
('SUITE',123,'caracteristicas:....');

INSERT INTO TIPOHABITACION
(TIPO, PRECIO, DESCRIPCION)
VALUES
('FAMILIAR',123,'caracteristicas:....');

INSERT INTO TIPOHABITACION
(TIPO, PRECIO, DESCRIPCION)
VALUES
('DOBLE',123,'caracteristicas:....');

INSERT INTO TIPOHABITACION
(TIPO, PRECIO, DESCRIPCION)
VALUES
('SIMPLE',123,'caracteristicas:....');
INSERT INTO CADENAHOTELERA
(NOMBRE)
VALUES
('MARRIOT');
INSERT INTO HOTEL
(NOMBRE, ESTRELLAS,CADENAHOTELERA)
VALUES
('BELLAVISTA', 4, 1);
INSERT INTO HABITACION
(TIPO, HOTEL,numeroHabitacion,valorAPagar, enuso)
VALUES
(1,1,765,0,0);
INSERT INTO HABITACION
(TIPO, HOTEL,numeroHabitacion,valorAPagar, enuso)
VALUES
(1,1,763,0,0);

INSERT INTO PERSONASHABITACION
(IDHABITACION, FECHAENTRADA, FECHASALIDA,USO)
VALUES
(1,TO_TIMESTAMP('2014-07-02 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'),TO_TIMESTAMP('2014-07-02 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'),1);


--visaje habitacional


INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,1,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,2,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,3,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,4,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,5,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,6,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,7,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,8,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,9,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,10,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,11,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,12,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,13,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,14,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,15,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,16,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,17,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,18,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,19,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,20,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,21,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,22,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,23,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,24,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,25,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,26,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,27,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,28,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,29,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,30,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,31,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,32,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,33,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,34,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,35,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,36,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,37,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,38,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,39,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,40,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,41,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,42,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,43,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,44,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,45,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,46,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,47,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,48,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,49,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,50,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,51,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,52,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,53,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,54,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,55,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,56,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,57,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,58,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,59,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,60,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,61,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,62,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,63,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,64,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,65,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,66,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,67,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,68,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,69,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,70,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,71,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,72,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,73,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,74,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,75,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,76,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,77,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,78,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,79,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,80,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,81,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,82,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,83,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,84,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,85,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,86,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,87,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,88,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,89,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,90,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,91,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,92,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,93,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,94,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,95,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,96,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,97,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,98,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,99,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,100,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,101,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,102,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,103,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,104,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,105,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,106,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,107,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,108,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,109,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,110,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,111,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,112,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,113,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,114,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,115,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,116,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,117,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,118,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,119,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,120,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,121,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,122,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,123,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,124,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,125,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,126,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,127,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,128,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,129,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,130,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,131,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,132,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,133,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,134,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,135,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,136,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,137,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,138,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,139,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,140,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,141,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,142,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,143,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,144,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,145,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,146,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,147,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,148,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,149,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,150,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,151,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,152,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,153,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,154,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,155,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,156,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,157,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,158,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,159,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,160,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,161,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,162,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,163,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,164,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,165,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,166,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,167,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,168,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,169,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,170,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,171,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,172,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,173,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,174,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,175,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,176,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,177,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,178,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,179,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,180,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,181,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,182,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,183,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,184,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,185,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,186,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,187,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,188,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,189,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,190,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,191,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,192,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,193,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,194,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,195,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,196,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,197,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,198,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (1,1,199,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,200,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,201,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,202,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,203,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,204,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,205,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,206,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,207,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,208,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,209,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,210,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,211,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,212,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,213,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,214,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,215,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,216,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,217,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,218,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,219,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,220,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,221,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,222,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,223,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,224,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,225,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,226,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,227,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,228,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,229,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,230,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,231,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,232,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,233,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,234,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,235,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,236,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,237,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,238,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,239,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,240,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,241,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,242,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,243,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,244,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,245,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,246,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,247,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,248,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,249,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,250,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,251,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,252,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,253,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,254,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,255,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,256,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,257,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,258,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,259,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,260,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,261,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,262,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,263,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,264,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,265,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,266,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,267,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,268,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,269,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,270,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,271,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,272,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,273,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,274,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,275,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,276,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,277,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,278,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,279,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,280,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,281,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,282,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,283,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,284,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,285,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,286,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,287,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,288,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,289,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,290,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,291,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,292,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,293,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,294,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,295,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,296,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,297,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,298,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,299,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,300,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,301,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,302,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,303,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,304,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,305,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,306,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,307,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,308,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,309,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,310,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,311,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,312,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,313,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,314,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,315,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,316,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,317,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,318,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,319,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,320,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,321,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,322,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,323,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,324,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,325,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,326,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,327,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,328,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,329,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,330,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,331,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,332,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,333,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,334,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,335,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,336,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,337,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,338,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,339,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,340,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,341,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,342,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,343,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,344,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,345,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,346,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,347,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,348,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,349,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,350,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,351,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,352,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,353,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,354,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,355,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,356,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,357,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,358,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,359,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,360,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,361,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,362,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,363,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,364,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,365,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,366,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,367,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,368,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,369,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,370,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,371,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,372,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,373,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,374,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,375,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,376,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,377,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,378,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,379,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,380,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,381,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,382,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,383,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,384,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,385,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,386,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,387,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,388,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,389,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,390,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,391,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,392,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,393,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,394,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,395,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,396,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,397,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (2,1,398,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,399,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,400,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,401,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,402,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,403,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,404,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,405,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,406,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,407,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,408,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,409,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,410,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,411,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,412,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,413,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,414,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,415,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,416,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,417,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,418,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,419,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,420,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,421,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,422,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,423,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,424,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,425,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,426,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,427,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,428,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,429,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,430,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,431,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,432,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,433,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,434,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,435,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,436,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,437,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,438,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,439,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,440,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,441,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,442,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,443,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,444,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,445,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,446,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,447,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,448,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,449,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,450,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,451,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,452,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,453,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,454,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,455,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,456,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,457,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,458,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,459,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,460,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,461,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,462,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,463,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,464,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,465,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,466,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,467,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,468,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,469,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,470,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,471,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,472,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,473,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,474,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,475,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,476,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,477,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,478,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,479,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,480,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,481,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,482,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,483,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,484,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,485,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,486,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,487,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,488,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,489,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,490,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,491,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,492,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,493,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,494,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,495,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,496,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,497,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,498,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,499,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,500,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,501,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,502,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,503,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,504,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,505,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,506,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,507,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,508,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,509,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,510,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,511,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,512,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,513,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,514,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,515,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,516,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,517,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,518,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,519,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,520,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,521,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,522,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,523,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,524,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,525,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,526,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,527,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,528,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,529,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,530,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,531,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,532,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,533,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,534,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,535,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,536,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,537,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,538,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,539,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,540,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,541,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,542,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,543,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,544,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,545,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,546,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,547,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,548,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,549,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,550,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,551,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,552,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,553,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,554,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,555,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,556,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,557,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,558,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,559,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,560,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,561,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,562,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,563,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,564,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,565,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,566,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,567,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,568,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,569,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,570,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,571,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,572,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,573,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,574,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,575,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,576,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,577,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,578,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,579,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,580,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,581,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,582,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,583,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,584,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,585,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,586,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,587,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,588,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,589,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,590,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,591,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,592,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,593,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,594,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,595,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,596,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (3,1,597,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,598,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,599,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,600,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,601,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,602,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,603,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,604,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,605,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,606,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,607,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,608,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,609,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,610,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,611,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,612,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,613,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,614,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,615,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,616,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,617,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,618,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,619,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,620,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,621,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,622,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,623,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,624,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,625,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,626,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,627,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,628,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,629,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,630,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,631,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,632,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,633,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,634,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,635,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,636,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,637,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,638,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,639,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,640,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,641,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,642,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,643,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,644,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,645,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,646,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,647,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,648,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,649,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,650,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,651,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,652,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,653,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,654,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,655,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,656,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,657,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,658,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,659,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,660,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,661,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,662,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,663,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,664,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,665,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,666,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,667,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,668,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,669,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,670,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,671,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,672,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,673,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,674,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,675,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,676,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,677,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,678,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,679,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,680,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,681,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,682,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,683,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,684,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,685,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,686,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,687,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,688,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,689,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,690,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,691,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,692,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,693,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,694,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,695,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,696,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,697,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,698,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,699,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,700,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,701,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,702,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,703,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,704,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,705,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,706,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,707,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,708,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,709,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,710,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,711,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,712,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,713,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,714,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,715,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,716,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,717,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,718,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,719,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,720,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,721,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,722,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,723,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,724,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,725,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,726,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,727,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,728,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,729,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,730,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,731,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,732,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,733,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,734,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,735,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,736,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,737,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,738,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,739,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,740,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,741,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,742,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,743,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,744,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,745,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,746,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,747,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,748,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,749,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,750,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,751,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,752,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,753,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,754,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,755,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,756,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,757,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,758,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,759,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,760,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,761,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,762,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,763,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,764,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,765,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,766,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,767,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,768,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,769,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,770,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,771,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,772,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,773,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,774,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,775,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,776,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,777,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,778,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,779,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,780,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,781,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,782,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,783,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,784,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,785,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,786,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,787,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,788,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,789,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,790,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,791,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,792,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,793,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,794,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,795,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (4,1,796,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,797,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,798,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,799,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,800,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,801,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,802,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,803,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,804,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,805,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,806,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,807,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,808,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,809,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,810,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,811,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,812,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,813,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,814,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,815,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,816,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,817,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,818,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,819,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,820,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,821,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,822,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,823,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,824,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,825,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,826,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,827,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,828,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,829,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,830,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,831,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,832,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,833,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,834,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,835,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,836,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,837,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,838,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,839,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,840,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,841,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,842,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,843,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,844,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,845,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,846,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,847,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,848,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,849,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,850,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,851,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,852,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,853,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,854,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,855,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,856,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,857,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,858,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,859,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,860,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,861,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,862,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,863,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,864,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,865,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,866,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,867,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,868,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,869,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,870,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,871,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,872,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,873,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,874,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,875,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,876,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,877,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,878,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,879,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,880,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,881,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,882,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,883,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,884,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,885,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,886,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,887,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,888,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,889,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,890,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,891,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,892,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,893,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,894,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,895,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,896,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,897,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,898,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,899,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,900,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,901,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,902,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,903,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,904,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,905,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,906,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,907,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,908,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,909,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,910,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,911,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,912,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,913,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,914,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,915,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,916,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,917,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,918,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,919,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,920,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,921,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,922,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,923,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,924,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,925,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,926,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,927,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,928,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,929,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,930,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,931,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,932,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,933,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,934,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,935,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,936,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,937,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,938,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,939,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,940,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,941,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,942,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,943,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,944,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,945,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,946,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,947,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,948,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,949,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,950,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,951,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,952,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,953,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,954,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,955,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,956,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,957,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,958,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,959,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,960,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,961,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,962,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,963,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,964,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,965,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,966,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,967,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,968,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,969,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,970,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,971,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,972,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,973,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,974,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,975,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,976,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,977,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,978,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,979,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,980,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,981,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,982,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,983,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,984,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,985,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,986,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,987,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,988,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,989,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,990,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,991,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,992,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,993,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,994,0,0);
INSERT INTO HABITACION (TIPO, HOTEL,numeroHabitacion,valorAPagar,enuso) VALUES (5,1,995,0,0);
-- fin habitacion
--inicio servicio

INSERT INTO SERVICIO ( NOMBRE,TIPOSERVICIO,DESCUENTOTC) VALUES ('bono',1,0);
INSERT INTO SERVICIO ( NOMBRE,TIPOSERVICIO,DESCUENTOTC) VALUES ('bono',2,0);
INSERT INTO SERVICIO ( NOMBRE,TIPOSERVICIO,DESCUENTOTC) VALUES ('bono',3,0);
INSERT INTO SERVICIO ( NOMBRE,TIPOSERVICIO,DESCUENTOTC) VALUES ('bono',4,0);
INSERT INTO SERVICIO ( NOMBRE,TIPOSERVICIO,DESCUENTOTC) VALUES ('bono',5,0);--fin servicio

-- fin servicio

INSERT INTO REGISTROSERVICIO (IDHABITACION, LUGARCONSUMO, NOMBRECLIENTE,COSTOTOTAL,SERVICIO,FECHA) VALUES (1, 'L1', 'LUIGI', 0, 1, '01/01/2020');
INSERT INTO REGISTROSERVICIO (IDHABITACION, LUGARCONSUMO, NOMBRECLIENTE,COSTOTOTAL,SERVICIO,FECHA) VALUES (1, 'L1', 'LUIGI', 0, 2, '01/01/2020');

COMMIT;



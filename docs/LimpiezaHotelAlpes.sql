DROP TABLE CadenaHotelera CASCADE CONSTRAINTS;

DROP TABLE Hotel CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoHabitacion CASCADE CONSTRAINTS;

DROP TABLE Habitacion CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoUsuario CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoProducto CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoServicio CASCADE CONSTRAINTS;

--ENUM
DROP TABLE EstiloRestaurante CASCADE CONSTRAINTS;

--ENUM
DROP TABLE EstiloBar CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoTienda CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoSalon CASCADE CONSTRAINTS;

--ENUM
DROP TABLE Condicion CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoServicioEspecifico CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TipoDocumento CASCADE CONSTRAINTS;

--ENUM
DROP TABLE TIPOPLAN CASCADE CONSTRAINTS;

DROP TABLE Usuario CASCADE CONSTRAINTS;


DROP TABLE Reserva CASCADE CONSTRAINTS;

DROP TABLE PersonasHabitacion CASCADE CONSTRAINTS;

DROP TABLE PromocionesParticulares CASCADE CONSTRAINTS;

DROP TABLE Producto CASCADE CONSTRAINTS;

DROP TABLE Servicio CASCADE CONSTRAINTS;

DROP TABLE RegistroServicio CASCADE CONSTRAINTS;

DROP TABLE Restaurante CASCADE CONSTRAINTS;

DROP TABLE ProductoServicio CASCADE CONSTRAINTS;

DROP TABLE Bar CASCADE CONSTRAINTS;

DROP TABLE Tienda CASCADE CONSTRAINTS;

DROP TABLE SPA CASCADE CONSTRAINTS;

DROP TABLE SalonReunion CASCADE CONSTRAINTS;


DROP TABLE HorarioReunion CASCADE CONSTRAINTS;

DROP TABLE Supermercado CASCADE CONSTRAINTS;

DROP TABLE ServicioSpa CASCADE CONSTRAINTS;

DROP TABLE Internet CASCADE CONSTRAINTS;

DROP TABLE Utencillio CASCADE CONSTRAINTS;

DROP TABLE PrestamosUtencilios CASCADE CONSTRAINTS;


DROP TABLE PeticionPrenda CASCADE CONSTRAINTS;

DROP TABLE Piscina CASCADE CONSTRAINTS;

DROP TABLE Gym CASCADE CONSTRAINTS;

DROP TABLE ServicioEspecifico CASCADE CONSTRAINTS;

DROP TABLE usoUsuario CASCADE CONSTRAINTS;

DROP TABLE ReservaServicio CASCADE CONSTRAINTS;
COMMIT;

--ELIMINAR LOS VALORES DE LA BASE DE DATOS
DELETE FROM  Usuario ;
DELETE FROM  Hotel ;

DELETE FROM  CadenaHotelera ;

DELETE FROM  Habitacion ;

DELETE FROM  Reserva ;

DELETE FROM  PersonasHabitacion ;

DELETE FROM  PromocionesParticulares ;

DELETE FROM  Producto ;

DELETE FROM  Servicio ;

DELETE FROM  RegistroServicio ;

DELETE FROM  Restaurante ;

DELETE FROM  ProductoServicio ;

DELETE FROM  Bar ;

DELETE FROM  Tienda ;

DELETE FROM  SPA ;

DELETE FROM  SalonReunion ;

DELETE FROM  HorarioReunion ;

DELETE FROM  Supermercado ;

DELETE FROM  ServicioSpa ;

DELETE FROM  Internet ;

DELETE FROM  Utencillio ;

DELETE FROM  PrestamosUtencilios ;

DELETE FROM  PeticionPrenda ;

DELETE FROM  Piscina ;

DELETE FROM  Gym ;

DELETE FROM  ServicioEspecifico ;

DELETE FROM  usoUsuario ;

--ENUM
DELETE FROM  TipoUsuario ;

--ENUM
DELETE FROM  TipoProducto ;

--ENUM
DELETE FROM  TipoServicio ;

--ENUM
DELETE FROM  EstiloRestaurante ;

--ENUM
DELETE FROM  EstiloBar ;

--ENUM
DELETE FROM  TipoTienda ;

--ENUM
DELETE FROM  TipoSalon ;

--ENUM
DELETE FROM  Condicion ;

--ENUM
DELETE FROM  TipoServicioEspecifico ;

--ENUM
DELETE FROM  TipoDocumento ;

--ENUM
DELETE FROM  TIPOPLAN ;
--ENUM
DELETE FROM  TipoHabitacion ;
COMMIT;
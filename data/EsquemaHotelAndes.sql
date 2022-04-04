CREATE TABLE CadenaHotelera(
                               id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                               nombre VARCHAR2(255),

                               CONSTRAINT CadenaHotelera_PK PRIMARY KEY (id)
);

CREATE TABLE Hotel(
                      id NUMBER  GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                      nombre VARCHAR2(255),
                      estrellas NUMBER CHECK(estrellas BETWEEN 1 AND 5),
                      cadenaHotelera NUMBER REFERENCES CadenaHotelera(id),

                      CONSTRAINT hotelPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoHabitacion(
                               id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                               tipo VARCHAR2(255) NOT NULL,
                               precio NUMBER NOT NULL,
                               descripcion VARCHAR2(255) NOT NULL,

                               CONSTRAINT tipoHabitacionPk PRIMARY KEY (id)
);

CREATE TABLE Habitacion(
                           id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                           tipo NUMBER REFERENCES TipoHabitacion(id),
                           hotel NUMBER REFERENCES Hotel(id),
                           numeroHabitacion NUMBER NOT NULL,
                           valorAPagar NUMBER NOT NULL,

                           CONSTRAINT habitacionPk PRIMARY KEY(id)
);
Alter table  Habitacion ADD constraint HOTEL_HAB_UNIQUE UNIQUE (hotel,numeroHabitacion) ENABLE;
--ENUM
CREATE TABLE TipoUsuario(
                            id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                            tipo VARCHAR2(255) NOT NULL UNIQUE,

                            CONSTRAINT tipoUsuarioPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoProducto(
                             id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                             tipo VARCHAR2(255) NOT NULL UNIQUE,

                             CONSTRAINT tipoProductoPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoServicio(
                             id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                             tipo VARCHAR2(255) NOT NULL UNIQUE,

                             CONSTRAINT tipoServicioPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE EstiloRestaurante(
                                  id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                  estilo VARCHAR2(255) NOT NULL UNIQUE,

                                  CONSTRAINT estiloRestaurantePk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE EstiloBar(
                          id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                          estilo VARCHAR2(255) NOT NULL UNIQUE,

                          CONSTRAINT estiloBarPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoTienda(
                           id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                           tipo VARCHAR2(255) NOT NULL UNIQUE,

                           CONSTRAINT tipoTiendaPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoSalon(
                          id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                          tipo VARCHAR2(255) NOT NULL UNIQUE,

                          CONSTRAINT tipoSalonPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE Condicion(
                          id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                          tipo VARCHAR2(255) NOT NULL UNIQUE,

                          CONSTRAINT condicionesPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoServicioEspecifico(
                                       id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                       tipo VARCHAR2(255) NOT NULL UNIQUE,

                                       CONSTRAINT tipoServicioEspecificoPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoDocumento(
                              id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                              tipo VARCHAR2(255) NOT NULL UNIQUE,

                              CONSTRAINT tipoDocumentoPk PRIMARY KEY (id)
);

--ENUM
CREATE TABLE TipoPlan(
                         id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                         tipo VARCHAR2(255) NOT NULL UNIQUE,

                         CONSTRAINT tipoPlanPk PRIMARY KEY (id)
);

CREATE TABLE Usuario(
                        id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        nombre VARCHAR2(255) NOT NULL,
                        documento NUMBER,
                        tipoPlan NUMBER REFERENCES TipoPlan(id) NOT NULL,
                        tipoDocumento NUMBER REFERENCES TipoDocumento(id) NOT NULL,
                        tipoUsuario NUMBER REFERENCES TipoUsuario(id) NOT NULL,
                        login VARCHAR2(255) NOT NULL,
                        contrasena VARCHAR2(255) NOT NULL,
                        email VARCHAR2(255),
                        CONSTRAINT usuarioPk PRIMARY KEY (id)
);
Alter table  usuario ADD constraint LOGIN_ND UNIQUE (login) ENABLE;

CREATE TABLE Reserva(
                        id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        horaInicio TIMESTAMP,
                        horaFin TIMESTAMP,
                        idUsuario NUMBER REFERENCES Usuario(id) NOT NULL,

                        CONSTRAINT reservaPk PRIMARY KEY (id)
);

CREATE TABLE PersonasHabitacion(
                                   idHabitacion REFERENCES HABITACION(id),
                                   fechaEntrada TIMESTAMP NOT NULL,
                                   fechaSalida TIMESTAMP NOT NULL,
                                   idUso NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                   Uso NUMBER NOT NULL,

                                   CONSTRAINT personasHabitacionPK PRIMARY KEY (idUso)
);
ALTER TABLE PersonasHabitacion
ADD CONSTRAINT CKUso
CHECK (Uso=0 OR Uso=1);
CREATE TABLE PromocionesParticulares(
                                        idUser NUMBER REFERENCES Usuario(id) NOT NULL,
                                        descuentoHospedaje NUMBER CHECK (descuentoHospedaje BETWEEN 0 AND 1) NOT NULL,
                                        restaurantesCompleto NUMBER CHECK (restaurantesCompleto BETWEEN 0 AND 1) NOT NULL,
                                        alojamientoCompleto NUMBER CHECK (alojamientoCompleto BETWEEN 0 AND 1) NOT NULL,
                                        descuentoRestaurantes NUMBER CHECK (descuentoRestaurantes BETWEEN 0 AND 1) NOT NULL
);

CREATE TABLE Producto(
                         id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                         nombre VARCHAR2(255) NOT NULL,
                         tipoProducto NUMBER REFERENCES TipoProducto(id) NOT NULL,
                         precio NUMBER NOT NULL,

                         CONSTRAINT productoPk PRIMARY KEY (id)
);

CREATE TABLE Servicio(
                         id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                         nombre VARCHAR2(255) NOT NULL,
                         tipoServicio NUMBER REFERENCES TipoServicio(id) NOT NULL,
                         descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),

                         CONSTRAINT servicioPk PRIMARY KEY (id)
);

CREATE TABLE RegistroServicio(
                                 id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                 idHabitacion NUMBER REFERENCES HABITACION(id),
                                 lugarConsumo VARCHAR2(255) NOT NULL,
                                 nombreCliente VARCHAR2(255) NOT NULL,
                                 costoTotal NUMBER NOT NULL,
                                 habitacion NUMBER REFERENCES HABITACION(id),
                                 servicio NUMBER REFERENCES SERVICIO(id),

                                 CONSTRAINT registroServicioPk PRIMARY KEY (id)
);

CREATE TABLE Restaurante(
                            idServicio NUMBER REFERENCES SERVICIO(id),
                            capacidad NUMBER NOT NULL,
                            estilo NUMBER REFERENCES EstiloRestaurante(id) NOT NULL,

                            CONSTRAINT restaurantePk PRIMARY KEY (idServicio)
);

CREATE TABLE ProductoServicio(
                                 idServicio NUMBER REFERENCES SERVICIO(id),
                                 idProducto NUMBER REFERENCES PRODUCTO(id),
                                 cantidad NUMBER NOT NULL,

                                 CONSTRAINT productoServicioPk PRIMARY KEY (idServicio, idProducto)
);

CREATE TABLE Bar(
                    idServicio NUMBER REFERENCES SERVICIO(id),
                    capacidad NUMBER NOT NULL,
                    estilo NUMBER REFERENCES EstiloBar(id) NOT NULL,

                    CONSTRAINT barPk PRIMARY KEY (idServicio)
);

CREATE TABLE Tienda(
                       idServicio NUMBER REFERENCES SERVICIO(id),
                       tipo NUMBER REFERENCES TipoTienda(id) NOT NULL,
                       capacidad NUMBER NOT NULL,

                       CONSTRAINT tiendaPk PRIMARY KEY (idServicio)
);

CREATE TABLE SPA(
                    id NUMBER,
                    tipo NUMBER REFERENCES TipoSalon(id) NOT NULL,
                    capacidad NUMBER NOT NULL,

                    CONSTRAINT spaPk PRIMARY KEY (id)
);

CREATE TABLE SalonReunion(
                             id NUMBER,
                             descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),
                             costo NUMBER NOT NULL,
                             capacidad NUMBER NOT NULL,
                             nombre VARCHAR2(255) NOT NULL,
                             esperaReunion NUMBER NOT NULL,
                             costoEquipos NUMBER,
                             tipo NUMBER REFERENCES TipoSalon(id) NOT NULL,

                             CONSTRAINT salonReunionPk PRIMARY KEY (id)
);


CREATE TABLE HorarioReunion(
                               idUsuario NUMBER REFERENCES Usuario(id),
                               idSalon NUMBER REFERENCES SalonReunion(id),
                               horaInicio TIMESTAMP NOT NULL,
                               duracionMinutos NUMBER NOT NULL
);

CREATE TABLE Supermercado(
                             idServicio NUMBER REFERENCES SERVICIO(id),
                             capacidad NUMBER NOT NULL,
                             costoServicio NUMBER NOT NULL,

                             CONSTRAINT supermercadoPk PRIMARY KEY (idServicio)
);

CREATE TABLE ServicioSpa(
                            idServicio NUMBER REFERENCES SERVICIO(id),
                            idSpa NUMBER REFERENCES SPA(id),
                            costo NUMBER NOT NULL,
                            duracion NUMBER NOT NULL CHECK(duracion > 0),

                            CONSTRAINT servicioSpaPk PRIMARY KEY (idServicio, idSpa)
);

CREATE TABLE Internet(
                         id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                         descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),
                         costo NUMBER NOT NULL CHECK(costo >= 0),
                         capacidad NUMBER NOT NULL CHECK(capacidad > 0),

                         CONSTRAINT internetPk PRIMARY KEY (id)
);

CREATE TABLE Utencillio(
                           id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                           nombre VARCHAR2(40) NOT NULL,

                           CONSTRAINT utencillioPk PRIMARY KEY (id)
);

CREATE TABLE PrestamosUtencilios(
                                    idPrestamo NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                    valor NUMBER NOT NULL CHECK(valor >= 0),
                                    estado REFERENCES CONDICION(id),
                                    idUtencillo NUMBER REFERENCES Utencillio(id),
                                    idHabitacion NUMBER REFERENCES Habitacion(id),

                                    CONSTRAINT prestamosUtenciliosPk PRIMARY KEY (idPrestamo)
);


CREATE TABLE PeticionPrenda(
                               id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                               idHabitacion NUMBER REFERENCES HABITACION(id),
                               numeroPrendas NUMBER NOT NULL CHECK(numeroPrendas > 0),
                               costo NUMBER NOT NULL CHECK(costo >= 0),
                               estado REFERENCES CONDICION(id),

                               CONSTRAINT peticionPrendaPk PRIMARY KEY (id)
);

CREATE TABLE Piscina(
                        id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),
                        nombre VARCHAR2(255) NOT NULL,
                        capacidad NUMBER NOT NULL CHECK(capacidad > 0),
                        costo NUMBER NOT NULL CHECK(costo >= 0),
                        profundidad NUMBER NOT NULL CHECK(profundidad > 0.2),
                        horaInicio NUMBER NOT NULL CHECK(horaInicio BETWEEN 0 AND 23),
                        horaFin NUMBER NOT NULL CHECK(horaFin BETWEEN 0 AND 23),

                        CONSTRAINT piscinaPk PRIMARY KEY (id)
);

CREATE TABLE Gym (
                     id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                     descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),
                     nombre VARCHAR2(255) NOT NULL,
                     costo NUMBER NOT NULL CHECK(costo >= 0),
                     capacidad NUMBER NOT NULL CHECK(capacidad > 0),
                     maquinas VARCHAR2(255) NOT NULL,
                     horaInicio NUMBER NOT NULL CHECK(horaInicio BETWEEN 0 AND 23),
                     horaFin NUMBER NOT NULL CHECK(horaFin BETWEEN 0 AND 23),
                     idHotel NUMBER REFERENCES Hotel(id),

                     CONSTRAINT gymPk PRIMARY KEY (id)
);

CREATE TABLE ServicioEspecifico(
                                   id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                   descuentoTC NUMBER NOT NULL CHECK(descuentoTC BETWEEN 0 AND 1),
                                   costo NUMBER NOT NULL CHECK(costo >= 0),
                                   tipo NUMBER REFERENCES TipoServicioEspecifico(id) NOT NULL,

                                   CONSTRAINT servicioEspecificoPk PRIMARY KEY (id)
);

CREATE TABLE usoUsuario(
                           idUso NUMBER REFERENCES PersonasHabitacion(idUso),
                           idUsuario NUMBER REFERENCES Usuario(id)
);
COMMIT;
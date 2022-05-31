from datetime import datetime
import json
from logging.handlers import RotatingFileHandler
from pprint import pprint
from random import choice, randint
from faker.providers import lorem
from faker.providers import company
import faker
import cx_Oracle
import logging

class Populator:
    connectionURL: str
    connectionDriverName: str
    connectionUserName: str
    connectionPassword: str
    logger = logging.getLogger(__name__)
    configPath = 'config.json'
    fake = faker.Faker("es_ES")
    
    
    def __init__(self):
        cx_Oracle.init_oracle_client(lib_dir=r".\instantclient_21_3")
        self.logger.setLevel(logging.DEBUG)
        self.logger.addHandler(logging.StreamHandler())
        rotatingFileHandler = RotatingFileHandler('populator.log', maxBytes=1000000, backupCount=5)
        self.logger.addHandler(rotatingFileHandler)
        self.logger.info('Logging started.')
        configLoaded = self.loadJsonConfig()
        if configLoaded:
            self.logger.info('Config loaded. Ready to operate.')
        else:
            self.logger.error('Config not loaded.')
    
    def loadJsonConfig(self):
        try:
            with open(self.configPath) as json_file:
                config = json.load(json_file)
                self.connectionURL = config['connectionURL']
                self.connectionDriverName = config['connectionDriverName']
                self.connectionUserName = config['connectionUserName']
                self.connectionPassword = config['connectionPassword']            
                self.logger.info('Connection URL: ' + self.connectionURL)
                return True
        except Exception as e:
            import traceback
            traceback.print_exc()
            return False
        
    def populateTableTipoServicio(self):
        connection = self.getConnection()
        cursor = connection.cursor()
        insertados = []
        for i in range(0, 15000):
            try:
                word = self.fake.bs()
                cursor.execute("INSERT INTO TIPOSERVICIO (TIPO) VALUES ('" + word + "')")
                insertados.append(word)
            except Exception as e:
                self.logger.error(e)
        self.logger.info('Tipos de servicio insertados: ' + str(len(insertados)))
        connection.commit()
        connection.close()
        return insertados
    
    def populateTableServicio(self):
        connection = self.getConnection()
        cursor = connection.cursor()
        tiposServicios = cursor.execute("SELECT * FROM TIPOSERVICIO").fetchall()
        for i in range(0,15000):
            try:
                nombre = self.fake.word()
                tipoServicio = choice(tiposServicios)[0]
                descuentoTC= randint(0,1)
                cursor.execute("INSERT INTO SERVICIO (NOMBRE, TIPOSERVICIO, DESCUENTOTC) VALUES ('" + nombre + "', " + str(tipoServicio) + ", " + str(descuentoTC) + ")")
                self.logger.info('Servicio insertado: ' + str(i) + ' - ' + nombre)
            except Exception as e:
                self.logger.error(e)
        connection.commit()
        connection.close()
        
    def populateRegistroServicioTable(self):
        connection = self.getConnection()
        cursor = connection.cursor()
        servicios = cursor.execute("SELECT ID FROM SERVICIO").fetchall()
        habitaciones = cursor.execute("SELECT ID FROM HABITACION").fetchall()
        usuarios = cursor.execute("SELECT NOMBRE FROM USUARIO").fetchall()
        trange = 1000
        for i in range (0, trange):
            try:
                idHabitacion = choice(habitaciones)[0]
                nombreCliente = choice(usuarios)[0]
                lugarConsumo = self.fake.company()
                servicio = choice(servicios)[0]
                fecha = self.fake.date_time_between(start_date="-5y", end_date=datetime.now())
                costoTotal = randint(0,100000)
                fecha = fecha.strftime("%d/%m/%Y %H:%M:%S")
                insertStatement = "INSERT INTO REGISTROSERVICIO (IDHABITACION, NOMBRECLIENTE, LUGARCONSUMO, SERVICIO, COSTOTOTAL, FECHA) VALUES (" + str(idHabitacion) + ", '" + nombreCliente + "', '" + lugarConsumo + "', " + str(servicio) + ", " + str(costoTotal) + ", TO_DATE('" + fecha + "', 'DD/MM/YYYY HH24:MI:SS'))"
                cursor.execute(insertStatement)
                print(i)
            except Exception as e:
                self.logger.error(e)
        connection.commit()
        connection.close()

    def registerUserInRegistroServicio(self):
        connection = self.getConnection()
        cursor = connection.cursor()
        usernames = cursor.execute("SELECT NOMBRECLIENTE FROM REGISTROSERVICIO WHERE NOMBRECLIENTE NOT IN (SELECT NOMBRE FROM USUARIO GROUP BY NOMBRE) Group by NOMBRECLIENTE").fetchall()
        tipoDocumentos = cursor.execute("SELECT ID FROM TIPODOCUMENTO").fetchall()
        tipoPlanes = cursor.execute("SELECT ID FROM TIPOPLAN").fetchall()
        insertados = 0
        for user in usernames:
            nombre = user[0]
            documento = str(self.fake.random_int(min=1, max=99999999))
            tipoDocumento = choice(tipoDocumentos)[0]
            login = self.fake.user_name()
            contrasena = self.fake.password()
            email = self.fake.email()
            tipoPlan = choice(tipoPlanes)[0]
            tipoUsuario = 1
            insertStatement = "INSERT INTO USUARIO (NOMBRE, DOCUMENTO, TIPODOCUMENTO, LOGIN, CONTRASENA, EMAIL, TIPOPLAN, TIPOUSUARIO) VALUES ('" + nombre + "', " + documento + ", " + str(tipoDocumento) + ", '" + login + "', '" + contrasena + "', '" + email + "', " + str(tipoPlan) + ", " + str(tipoUsuario) + ")"
            try:
                cursor.execute(insertStatement)
                connection.commit()
                print('usuario insertado: ' + nombre)
                insertados+=1
            except Exception as e:
                print('usuario no insertado: ' + nombre)
                self.logger.error(e)
            print(str(insertados)+'/'+str(len(usernames)))
        connection.close()
    
    def getConnection(self):
        return cx_Oracle.connect(user=self.connectionUserName, password=self.connectionPassword, dsn=self.connectionURL)
    
populator = Populator()
populator.populateRegistroServicioTable()
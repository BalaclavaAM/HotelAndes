package uniandes.isis2304.hotelandes.persistencia;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.*;
import uniandes.isis2304.parranderos.negocio.TipoBebida;

import javax.jdo.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class PersistenciaHotelAndes {
    private static Logger theLogger = Logger.getLogger(PersistenciaHotelAndes.class.getName());

    public static final String SQL = "javax.jdo.query.SQL";
    public static final String PMF_NAME = "HotelAndes";
    private static PersistenciaHotelAndes instance;
    private PersistenceManagerFactory pmf;
    private List<String> tablas;
    private SQLTipoHabitacion sqlTipoHabitacion;
    private SQLUtil sqlUtil;
    private SQLUsuario sqlUsuario;
    private SQLHabitacion sqlHabitacion;
    private SQLReserva sqlReserva;
    private SQLTipoUsuario sqlTUsuario;
    private SQLPersonasHabitacion sqlPersonasHabitacion;
    private Logger logger;


    private PersistenciaHotelAndes() {
        pmf = JDOHelper.getPersistenceManagerFactory(PMF_NAME);
        tablas = new LinkedList<>();
        tablas.add("CadenaHotelera"); //0
        tablas.add("Hotel"); //1
        tablas.add("TipoHabitacion"); //2
        tablas.add("Habitacion"); //3
        tablas.add("TipoUsuario"); //4
        tablas.add("TipoProducto"); //5
        tablas.add("TipoServicio"); //6
        tablas.add("EstiloRestaurante"); //7
        tablas.add("EstiloBar"); //8
        tablas.add("TipoTienda"); //9
        tablas.add("TipoSalon"); //10
        tablas.add("Condicion"); //11
        tablas.add("TipoServicioEspecifico"); //12
        tablas.add("TipoDocumento"); //13
        tablas.add("TipoPlan"); //14
        tablas.add("Usuario"); //15
        tablas.add("Reserva"); //16
        tablas.add("PersonasHabitacion"); //17
        tablas.add("PromocionesParticulares"); //18
        tablas.add("Producto"); //19
        tablas.add("Servicio"); //20
        tablas.add("RegistroServicio"); //21
        tablas.add("Restaurante"); //22
        tablas.add("ProductoServicio"); //23
        tablas.add("Bar"); //24
        tablas.add("Tienda"); //25
        tablas.add("SPA"); //26
        tablas.add("SalonReunion"); //27
        tablas.add("HorarioReunion"); //28
        tablas.add("Supermercado"); //29
        tablas.add("ServicioSpa"); //30
        tablas.add("Internet"); //31
        tablas.add("Utencillio"); //32
        tablas.add("PrestamosUtencilios"); //33
        tablas.add("PeticionPrenda"); //34
        tablas.add("Piscina");  //35
        tablas.add("Gym"); //36
        tablas.add("ServicioEspecifico"); //37
        tablas.add("usoUsuario"); //38
    }

    private PersistenciaHotelAndes (JsonObject tableConfig){
        crearClasesSQL();
        //TODO Crear clases SQL
        tablas = leerNombresTablas (tableConfig);

        String unidadPersistencia = tableConfig.get("persistencia").getAsString();
        theLogger.trace("Accediendo unidad de persistencia " + unidadPersistencia);
        pmf = JDOHelper.getPersistenceManagerFactory(unidadPersistencia);
    }
    private void crearClasesSQL ()
    {
        sqlTipoHabitacion = new SQLTipoHabitacion(this);
        sqlUtil= new SQLUtil(this);
        sqlUsuario= new SQLUsuario(this);
        sqlHabitacion= new SQLHabitacion(this);
        sqlReserva = new SQLReserva(this);
        sqlTUsuario = new SQLTipoUsuario(this);
        sqlPersonasHabitacion = new SQLPersonasHabitacion(this);

    }

    private List <String> leerNombresTablas (JsonObject tableConfig){
        JsonArray nombres = tableConfig.getAsJsonArray("tablas");
        List <String> resp = new LinkedList <String> ();
        for (JsonElement nom : nombres){
            resp.add(nom.getAsString());
        }
        return resp;
    }
    public TipoHabitacion adicionarTipoHabitacion(String tipo, Float precio, String descripcion)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        int id=0; //toca hacer una consulta para averiguar cual es la id de este tipo
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pm, tipo, precio, descripcion);
            tx.commit();

            theLogger.trace ("Inserción de tipo habitacion: " + tipo + ": " + tuplasInsertadas + " tuplas insertadas");

            return new TipoHabitacion(id,tipo,precio, descripcion);


        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    public TipoUsuario adicionarTipoUsuario(String name){
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = SQLTipoUsuario.insertTipoUsuario(pm, name);
            tx.commit();
            return new TipoUsuario(id,name);
        }
        catch (Exception e)
        {
            logger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally{
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }

    public Habitacion adicionarHabitacion(long tipo, long hotel, long numberoHabitacion)
    {
        System.out.println("entro a persistencia");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        int id=0; //toca hacer una consulta para averiguar cual es la id de este tipo
        try
        {
            System.out.println("entro al try");
            tx.begin();
            System.out.println("tx begin");
            long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, tipo, hotel, numberoHabitacion);
            tx.commit();
            System.out.println("salio del sql");
            theLogger.trace ("Inserción de tipo habitacion: " + tipo + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Habitacion(id,tipo,hotel, numberoHabitacion,0);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }

    private String darDetalleException(Exception e)
    {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
        {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions() [0].getMessage();
        }
        return resp;
    }

    public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
    {
        if (instance == null)
        {
            instance = new PersistenciaHotelAndes (tableConfig);
        }
        return instance;
    }
    public List<Usuario> darUsuarioPorLogin (String login)
    {
        System.out.println("llego a PERSISTENCIAHOTELANDES");

        return sqlUsuario.darUsuarioPorLogin (pmf.getPersistenceManager(), login);


    }

    public String obtenerTablaBar(){
        return tablas.get(24);
    }

    public String obtenerTablaTipoUsuario(){
        return tablas.get(4);
    }

    public String obtenerTablaTipoHabitacion(){
        return tablas.get(2);
    }
    public String obtenerTablaHabitacion(){
        return tablas.get(3);
    }

    public String obtenerTablaHotel(){
        return tablas.get(1);
    }

    public String obtenerTablaCadenaHotelera(){
        return tablas.get(0);
    }

    public void cerrarUnidadPersistencia ()
    {
        pmf.close ();
        instance = null;
    }
    public String darTablaUsuario ()
    {
        return tablas.get (15);
    }
    public String darTablaTipoUsuario ()
    {
        return tablas.get (4);
    }
    public String obtenerTablaReserva() {
        return tablas.get (16);
    }
    public String obtenerTablaPersonasHabitacion() {
        return tablas.get (17);
    }

    public Reserva registrarReserva(Timestamp fechaentrada, Timestamp fechasalida, long idUsuario) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        int id=0; //toca hacer una consulta para averiguar cual es la id de este tipo
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlReserva.registrarReserva(pm, fechaentrada, fechasalida, idUsuario);
            tx.commit();

            theLogger.trace ("Inserción de Reserva iniciando: " + fechaentrada + " terminando: " + fechasalida+"añadidas:"+ tuplasInsertadas + " tuplas insertadas");

            return new Reserva(id, fechaentrada,fechasalida, idUsuario);


        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }


    public List<PersonasHabitacion> obtenerPersonasHabitacion (long idHabitacion)
    {
        return sqlPersonasHabitacion.obtenerPersonasHabitacion(pmf.getPersistenceManager(), idHabitacion);
    }

    public List<Habitacion> obtenerHabitacion(long idHabitacion) {
        return sqlHabitacion.obtenerHabitacion(pmf.getPersistenceManager(), idHabitacion);
    }

    public long cambiarEstadoUso(long idHabitacion) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPersonasHabitacion.cambiarEstadoUso(pmf.getPersistenceManager(),idHabitacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

    }
}

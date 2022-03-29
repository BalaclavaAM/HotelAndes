package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import oracle.sql.SQLUtil;
import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;
import uniandes.isis2304.hotelandes.persistencia.SQLTipoHabitacion;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

public class PersistenciaHotelAndes {
    private static Logger theLogger = Logger.getLogger(PersistenciaHotelAndes.class.getName());

    public static final String SQL = "javax.jdo.query.SQL";
    public static final String PMF_NAME = "HotelAndes";
    private static PersistenciaHotelAndes instance;
    private PersistenceManagerFactory pmf;
    private List<String> tablas;
    private SQLTipoHabitacion sqlTipoHabitacion;
    private SQLUtil sqlUtil;

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
        //TODO Crear clases SQL
        tablas = leerNombresTablas (tableConfig);

        String unidadPersistencia = tableConfig.get("unidadPersistencia").getAsString();
        theLogger.trace("Accediendo unidad de persistencia " + unidadPersistencia);
        pmf = JDOHelper.getPersistenceManagerFactory(unidadPersistencia);
    }
    private void crearClasesSQL ()
    {
        sqlTipoHabitacion = new SQLTipoHabitacion(this);

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

            theLogger.trace ("Inserción de tipo de bebida: " + tipo + ": " + tuplasInsertadas + " tuplas insertadas");

            return new TipoHabitacion (id,tipo,precio, descripcion);


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

    public String obtenerTablaBar(){
        return tablas.get(24);
    }

    public String obtenerTablaHabitacion(){
        return tablas.get(4);
    }

    public String obtenerTablaTipoHabitacion(){
        return tablas.get(2);
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


}

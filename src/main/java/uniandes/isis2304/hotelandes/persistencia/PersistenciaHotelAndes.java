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
    private SQLServicio sqlServicio;
    private SQLPersonasHabitacion sqlPersonasHabitacion;
    private SQLRegistroServicio sqlRegistroServicio;
    private SQLTipoServicio sqlTipoServicio;
    private SQLTipoPlan sqlTipoPlan;
    private SQLReservaServicio sqlReservaServicio;
    private SQLHotel sqlHotel;
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
        tablas.add("reservaServicio"); //39
        tablas.add("registroServicio"); //40
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
        sqlServicio = new SQLServicio(this);
        sqlRegistroServicio= new SQLRegistroServicio(this);
        sqlTipoServicio = new SQLTipoServicio(this);
        sqlTipoPlan = new SQLTipoPlan(this);
        sqlReservaServicio = new SQLReservaServicio(this);
        sqlHotel = new SQLHotel(this);

    }

    private List <String> leerNombresTablas (JsonObject tableConfig){
        JsonArray nombres = tableConfig.getAsJsonArray("tablas");
        List <String> resp = new LinkedList <String> ();
        for (JsonElement nom : nombres){
            resp.add(nom.getAsString());
        }
        return resp;
    }
    public String darTablaTipoDocumento(){
        return tablas.get(13);
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

    public List obtenerTiposPlanes(){
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            List<TipoPlan> tipos = SQLTipoPlan.getTiposPlanes(pm);
            return tipos;
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

            return new Habitacion(id,tipo,hotel, numberoHabitacion,0,0);
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

    public List<TipoDocumento> getDocumentTypes()
    {
        return SQLTipoDocumento.getDocumentTypes(pmf.getPersistenceManager());
    }

    public long adicionarUsuario( String nombre, String documento, int tipoPlan, int tipoUsuario, int tipoDocumento, String login, String contrasena, String email){
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, nombre, documento, tipoPlan, tipoUsuario, tipoDocumento, login, contrasena, email);
            tx.commit();
            return tuplasInsertadas;
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return 0;
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

    public List<TipoUsuario> getUserTypes()
    {
        return SQLTipoUsuario.getUserTypes(pmf.getPersistenceManager());
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
    public String obtenerTablaReservaServicio() {
        return tablas.get (39);
    }
    public String obtenerRegistroServicio() {
        return tablas.get (40);
    }
    public String obtenerTablaPersonasHabitacion() {
        return tablas.get (17);
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



    public long registrarReserva(String fechaentrada, String fechasalida, long idUsuario,long idHabitacion) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        int id=0; //toca hacer una consulta para averiguar cual es la id de este tipo
        try
        {
            try {
                tx.begin();
                long tuplasInsertadas = sqlReserva.registrarReserva(pm, fechaentrada, fechasalida, idUsuario, idHabitacion);
                tx.commit();

                theLogger.trace ("Inserción de Reserva iniciando: " + fechaentrada + " terminando: " + fechasalida+"añadidas:"+ tuplasInsertadas + " tuplas insertadas");

                return 1;
            }catch (Exception e){
                theLogger.error ("Fallo registro reserva");
                return 0;
            }


        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return 0;
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
    public List<Habitacion> obtenerHabitacionesSinOcuparConTipo(long tipo, long hotel,long cantidad) {
        return sqlHabitacion.obtenerHabitacionesSinOcuparConTipo(pmf.getPersistenceManager(), tipo, hotel, cantidad);
    }


    public List<Habitacion> obtenerHabitacionConNumero(long numeroHabitacion) {
        return sqlHabitacion.obtenerHabitacionConNumero(pmf.getPersistenceManager(), numeroHabitacion);
    }

    public List<Reserva> obtenerReservaActivaConUsuario( long usuario) {
        return sqlReserva.obtenerReservaActivaConUsuario(pmf.getPersistenceManager(), usuario);
    }
    public long reservaCambiarEstadoConUsuario(long idusuario){
        return sqlReserva.reservaCambiarEstadoConUsuario(pmf.getPersistenceManager(),idusuario);
    }

    public long reservaCambiarEstado(long id) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.reservaCambiarEstado(pmf.getPersistenceManager(),id);
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

    public long adicionarPersonasHabitacion(long id, Timestamp horaInicio, Timestamp horaFinal, int uso) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        int ida=0; //toca hacer una consulta para averiguar cual es la id de este tipo
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlPersonasHabitacion.adicionarPersonasHabitacion(pm, id, horaInicio, horaFinal, uso);
            tx.commit();

            theLogger.trace ("Inserción de PERSONAS HABITACION: " + horaInicio + " terminando: " + horaFinal+"añadidas:"+ tuplasInsertadas + " tuplas insertadas");

            return tuplasInsertadas;


        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            theLogger.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return 0;
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

    public List<Servicio> veinteServiciosPopulares(String inicio, String finals) {
        return sqlServicio.veinteServiciosPopulares(pmf.getPersistenceManager(),inicio, finals);
    }

    public List<DineroPorHabitacion> dineroPorHabitacion(String inicio, String finals) {
        return sqlHabitacion.dineroServiciosPorHabitacion(pmf.getPersistenceManager(),inicio, finals);
    }

    public long agregarConsumoServicio(long idHabitacion, String lugarConsumo, String nombreCliente, long costoTotal, long idservicio, String fecha) {
        return sqlRegistroServicio.agregarConsumoServicio(pmf.getPersistenceManager(),idHabitacion, lugarConsumo, nombreCliente,  costoTotal, idservicio, fecha);
    }

    public long adicionarTipoServicio(String nombreTipo) {
        return sqlServicio.agregarTipoServicio(pmf.getPersistenceManager(),nombreTipo);
    }

    public List<TipoServicio> gTipoServicios() {
        return sqlTipoServicio.getTiposServicios(pmf.getPersistenceManager());
    }

    public long adicionarServicio(String nombreServicio, long idTipoServicio, boolean tipoServicio) {
        return sqlServicio.agregarServicio(pmf.getPersistenceManager(),nombreServicio, idTipoServicio, tipoServicio);
    }

    public long adicionarTipoPlan(String nombreTipoPlan) {
        return sqlTipoPlan.agregarTIpoPlan(pmf.getPersistenceManager(),nombreTipoPlan);
    }

    public long addReservaServicioHotel(long idusuario, long idhotel, long idhabitacion, long idservicio) {
        return 0;
    }

    public List<Habitacion> obtenerHabitacionesSinOcupar(long hotel, long tipohabitacion, long cantidad) {
        return sqlHabitacion.obtenerHabitacionesSinOcuparConTipo(pmf.getPersistenceManager(),hotel, tipohabitacion, cantidad);
    }
    public long registrarReservaServicio(long idusuario, String fechaInicio, String fechafinal, long idservicio) {
        return sqlReservaServicio.registrarReservaServicio(pmf.getPersistenceManager(), fechaInicio, fechafinal, idusuario,idservicio);
    }
    public long reservaServicioCambiarEstadoConUsuario(long id) {
        return sqlReservaServicio.reservaServicioCambiarEstadoConUsuario(pmf.getPersistenceManager(),id);
    }
    public List<RegistroServicio> darRegistrosServicioPorUsuario( String nombreCliente, String fechaInicio,String fechaFin) {
        return sqlRegistroServicio.darRegistrosServicio(pmf.getPersistenceManager(), nombreCliente, fechaInicio, fechaFin);
    }

    public List<Habitacion> obtenerHabitaciones(long hotel){
        return sqlHabitacion.obtenerHabitaciones(pmf.getPersistenceManager(),hotel);
    }

    public List<Hotel> obtenerHoteles() {
        return sqlHotel.getAllHoteles(pmf.getPersistenceManager());
    }

    public List<Servicio> obtenerServicios() {
        return sqlServicio.obtenerServicios(pmf.getPersistenceManager());
    }

    public List<Usuario> getUsersWConvenciones() {
        return sqlUsuario.getUsersWConvenciones(pmf.getPersistenceManager());
    }

    public long terminarConvencion(Timestamp horaInicio, Timestamp horaFin, long idUsuario) {
        return sqlReserva.terminarConvencion(pmf.getPersistenceManager(),horaInicio, horaFin, idUsuario);
    }

    public List<TipoHabitacion> gTiposHabitacion() {
        return sqlTipoHabitacion.gTipoHabitacion(pmf.getPersistenceManager());
    }


}

package uniandes.isis2304.hotelandes.negocio;

import com.google.gson.JsonObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;
import uniandes.isis2304.hotelandes.negocio.*;
import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;
import uniandes.isis2304.parranderos.negocio.TipoBebida;

import uniandes.isis2304.parranderos.negocio.VOTipoBebida;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("serial")
public class HotelAndes {
    private static Logger log = Logger.getLogger(HotelAndes.class.getName());

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * El manejador de persistencia
     */
    private PersistenciaHotelAndes pp;

    /*
    public HotelAndes ()
    {
        pp = PersistenciaHotelAndes.getInstance ();
    }
    El contructor por defecto tiene problemas*/
    public HotelAndes(JsonObject tableConfig) {
        pp = PersistenciaHotelAndes.getInstance(tableConfig);
        BasicConfigurator.configure();
    }

    public void cerrarUnidadPersistencia() {
        pp.cerrarUnidadPersistencia();
    }

    public TipoHabitacion adicionarTipoHabitacion(String tipo, Float precio, String descripcion) {
        log.info("Adicionando Tipo de Habitacion: " + tipo);
        TipoHabitacion tipoHabitacion = pp.adicionarTipoHabitacion(tipo, precio, descripcion);
        log.info("Adicionando Tipo de Habitacion: " + tipoHabitacion);
        return tipoHabitacion;
    }

    public Usuario darUsuarioPorLogin(String login) {
        System.out.println("llego a hotelandes");
        log.info("Buscando Usuario por login : " + login);
        List<Usuario> tb = pp.darUsuarioPorLogin(login);
        return !tb.isEmpty() ? tb.get(0) : null;
    }

    public VOHabitacion adicionarHabitacion(long tipo, long hotel, long numberoHabitacion) {
        System.out.println("entro a hotelandes");
        log.info("Adicionando Habitacion: " + tipo);
        Habitacion Habitacion = pp.adicionarHabitacion(tipo, hotel, numberoHabitacion);
        log.info("Adicionando Habitacion: " + Habitacion);

        return Habitacion;
    }

    public long registrarReserva(String fechaentrada, String fechasalida, long idUsuario, long idHabitacion) {
        System.out.println("entro a hotelandes");
        log.info("Adicionando Habitacion: " + fechaentrada);
        long reserva = pp.registrarReserva(fechaentrada, fechasalida, idUsuario, idHabitacion);
        log.info("Adicionando Habitacion: " + reserva);

        return reserva;
    }

    public TipoUsuario adicionaTipoUsuario(String name) {
        log.info("Adicionando Tipo de Usuario: ");
        TipoUsuario tipoUsuario = pp.adicionarTipoUsuario(name);
        log.info("Adicionando Tipo de Usuario: " + tipoUsuario);
        return tipoUsuario;
    }

    public PersonasHabitacion obtenerPersonasHabitacion(long idHabitacion) {
        log.info("Buscando Tipo de bebida por idHabitacion: " + idHabitacion);
        List<PersonasHabitacion> tb = pp.obtenerPersonasHabitacion(idHabitacion);
        return !tb.isEmpty() ? tb.get(0) : null;
    }

    public VOHabitacion obtenerHabitacion(long idHabitacion) {
        log.info("Buscando Tipo de bebida por idHabitacion: " + idHabitacion);
        List<Habitacion> tb = pp.obtenerHabitacion(idHabitacion);
        return !tb.isEmpty() ? tb.get(0) : null;
    }


    public long cambiarEstadoUso(long idHabitacion) {
        log.info("Buscando Tipo de bebida por idHabitacion: " + idHabitacion);
        long tb = pp.cambiarEstadoUso(idHabitacion);
        log.info("Eliminando bebida por id: " + idHabitacion + " tuplas eliminadas");
        return tb;

    }

    public List obtenerTiposPlanes() {
        log.info("Obteniendo Tipos de Planes: ");
        List<TipoPlan> tipoPlan = pp.obtenerTiposPlanes();
        log.info("Obteniendo Tipos de Planes: " + tipoPlan);
        return tipoPlan;
    }

    public List getUserTypes() {
        log.info("Obteniendo Tipos de Usuarios: ");
        List tiposUsuarios = pp.getUserTypes();
        log.info("Obteniendo Tipos de Usuarios: " + tiposUsuarios);
        return tiposUsuarios;
    }

    public List<TipoDocumento> getDocumentTypes() {
        log.info("Obteniendo Tipos de Documentos: ");
        List<TipoDocumento> tiposDocumentos = pp.getDocumentTypes();
        log.info("Obteniendo Tipos de Documentos: " + tiposDocumentos);
        return tiposDocumentos;
    }

    public List<Habitacion> obtenerHabitacionesSinOcuparConTipo(long tipo, long hotel, long cantidad) {
        log.info("Obteniendo Tipos de Documentos: ");
        List<Habitacion> habitaciones = pp.obtenerHabitacionesSinOcuparConTipo(tipo, hotel, cantidad);
        log.info("Obteniendo Tipos de Documentos: " + habitaciones);
        return habitaciones;
    }

    public long adicionarUsuario(String nombre, String documento, int tipoPlan, int tipoDocumento, int tipoUsuario, String login, String contrasena, String email) {
        log.info("Adicionando Usuario: " + nombre);
        long usuarioId = pp.adicionarUsuario(nombre, documento, tipoPlan, tipoDocumento, tipoUsuario, login, contrasena, email);
        log.info("Adicionando Usuario: " + usuarioId);
        return usuarioId;
    }

    public Habitacion obtenerHabitacionConNumero(long numeroHabitacion) {
        log.info("Buscando Tipo de bebida por idHabitacion: " + numeroHabitacion);
        List<Habitacion> tb = pp.obtenerHabitacionConNumero(numeroHabitacion);
        return !tb.isEmpty() ? tb.get(0) : null;
    }

    public Reserva obtenerReservaActivaConUsuario(long usuario) {
        log.info("Buscando Reserva con id de habitacion: " + usuario);
        List<Reserva> tb = pp.obtenerReservaActivaConUsuario(usuario);
        return !tb.isEmpty() ? tb.get(0) : null;
    }

    public List<Reserva> obtenerReservasActivaConUsuario(long usuario) {
        log.info("Buscando Reserva con id de habitacion: " + usuario);
        List<Reserva> tb = pp.obtenerReservaActivaConUsuario(usuario);
        return !tb.isEmpty() ? tb : null;
    }

    public long reservaCambiarEstado(long id) {
        log.info("Buscando Tipo de bebida por idHabitacion: " + id);
        long tb = pp.reservaCambiarEstado(id);
        log.info("Eliminando bebida por id: " + id + " tuplas eliminadas");
        return tb;
    }

    public long crearPersonasHabitacion(long id, Timestamp horaInicio, Timestamp horaFinal, int uso) {
        log.info("Adicionando PersonasHabitacion con idHabitacion: " + id);
        long tb = pp.adicionarPersonasHabitacion(id, horaInicio, horaFinal, uso);
        log.info("Adicionando PersonasHabitacion con idHabitacion: " + id);
        return tb;
    }

    public List<Servicio> veinteServiciosPopulares(String inicio, String finals) {
        log.info("20 servicios más populares: ");
        List<Servicio> tb = pp.veinteServiciosPopulares(inicio, finals);
        log.info("20 servicios más populares:");
        return tb;
    }

    public List<DineroPorHabitacion> dineroPorHabitacion(String inicio, String finals) {
        log.info("20 servicios más populares: ");
        List<DineroPorHabitacion> tb = pp.dineroPorHabitacion(inicio, finals);
        log.info("20 servicios más populares:");
        return tb;
    }

    public long agregarConsumoServicio(long idHabitacion, String lugarConsumo, String nombreCliente, long costoTotal, long idservicio, String fecha) {
        log.info("agregarConsumoServicio: ");
        long tb = pp.agregarConsumoServicio(idHabitacion, lugarConsumo, nombreCliente, costoTotal, idservicio, fecha);
        log.info("agregarConsumoServicio:");
        return tb;
    }

    public long adicionarTipoServicio(String nombreTipo) {
        log.info("Adicionando Tipo de Servicio: " + nombreTipo);
        long tb = pp.adicionarTipoServicio(nombreTipo);
        log.info("Adicionando Tipo de Servicio: " + tb);
        return tb;
    }

    public List<TipoServicio> gTipoServicios() {
        log.info("Obteniendo Tipos de Servicios: ");
        List<TipoServicio> tb = pp.gTipoServicios();
        log.info("Obteniendo Tipos de Servicios: " + tb);
        return tb;
    }

    public long adicionarServicio(String nombreServicio, long idTipoServicio, boolean tipoServicio) {
        log.info("Adicionando Servicio: " + nombreServicio);
        long tb = pp.adicionarServicio(nombreServicio, idTipoServicio, tipoServicio);
        log.info("Adicionando Servicio: " + tb);
        return tb;
    }

    public long adicionarTipoPlan(String nombreTipoPlan) {
        log.info("Adicionando Tipo de Plan: " + nombreTipoPlan);
        long tb = pp.adicionarTipoPlan(nombreTipoPlan);
        log.info("Adicionando Tipo de Plan: " + tb);
        return tb;
    }

    public long addReservaServicioHotel(long idusuario, long idhotel, long idhabitacion, long idservicio) {
        log.info("Agregando ReservaServicioHotel: ");
        long tb = pp.addReservaServicioHotel(idusuario, idhotel, idhabitacion, idservicio);
        log.info("Agregando ReservaServicioHotel: " + tb);
        return tb;
    }

    public List<VOHabitacion> obtenerHabitacionesSinOcupar(long hotel, long tipohabitacion, long cantidad) {
        log.info("Agregando ReservaServicioHotel: ");
        List<VOHabitacion> voH = new LinkedList<VOHabitacion>(pp.obtenerHabitacionesSinOcupar(hotel, tipohabitacion, cantidad));
        //List<Habitacion> tb = pp.obtenerHabitacionesSinOcupar(hotel, tipohabitacion, cantidad);
        log.info("Agregando ReservaServicioHotel: " + voH.size());
        return voH;

    }

    public long reservaCambiarEstadoConUsuario(long idusuario) {
        log.info("Agregando ReservaServicioHotel: ");
        long tb = pp.reservaCambiarEstadoConUsuario(idusuario);
        log.info("Agregando ReservaServicioHotel: " + tb);
        return tb;
    }

    public long registrarReservaServicio(long idusuario, String fechaInicio, String fechafinal, long idservicio) {

        log.info("Agregando ReservaServicio: ");
        long tb = pp.registrarReservaServicio(idusuario, fechaInicio, fechafinal, idservicio);
        log.info("Agregando ReservaServicio: " + tb);
        return tb;
    }

    public long reservaServicioCambiarEstadoConUsuario(long id) {
        log.info("Agregando ReservaServicio: ");
        long tb = pp.reservaServicioCambiarEstadoConUsuario(id);
        log.info("Agregando ReservaServicio: " + tb);
        return tb;
    }

    public List<RegistroServicio> darRegistrosServicioPorUsuario(String nombreCliente, String fechaInicio, String fechaFin) {
        log.info("Agregando ReservaServicio: ");
        List<RegistroServicio> tb = pp.darRegistrosServicioPorUsuario(nombreCliente, fechaInicio, fechaFin);
        log.info("Agregando ReservaServicio: " + tb);
        return tb;
    }
}

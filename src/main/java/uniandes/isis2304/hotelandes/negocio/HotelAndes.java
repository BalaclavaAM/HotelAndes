package uniandes.isis2304.hotelandes.negocio;

import com.google.gson.JsonObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;
import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;
import uniandes.isis2304.parranderos.negocio.TipoBebida;

import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import java.util.List;

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
    public HotelAndes (JsonObject tableConfig)
    {
        pp = PersistenciaHotelAndes.getInstance (tableConfig);
        BasicConfigurator.configure();
    }
    public void cerrarUnidadPersistencia ()
    {
        pp.cerrarUnidadPersistencia ();
    }
    public TipoHabitacion adicionarTipoHabitacion(String tipo, Float precio, String descripcion){
        log.info ("Adicionando Tipo de Habitacion: " + tipo);
        TipoHabitacion tipoHabitacion = pp.adicionarTipoHabitacion (tipo,precio, descripcion);
        log.info ("Adicionando Tipo de Habitacion: " + tipoHabitacion);
        return tipoHabitacion;
    }
    public Usuario darUsuarioPorLogin(String login)
    {
        System.out.println("llego a hotelandes");
        log.info ("Buscando Usuario por login : " + login);
        List<Usuario> tb = pp.darUsuarioPorLogin(login);
        return !tb.isEmpty () ? tb.get (0) : null;
    }

    public VOHabitacion adicionarHabitacion(long tipo, long hotel, long numberoHabitacion) {
        System.out.println("entro a hotelandes");
        log.info ("Adicionando Habitacion: " + tipo);
        Habitacion Habitacion = pp.adicionarHabitacion (tipo,hotel, numberoHabitacion);
        log.info ("Adicionando Habitacion: " + Habitacion);

        return Habitacion;
    }

    public TipoUsuario adicionaTipoUsuario(String name){
        log.info ("Adicionando Tipo de Usuario: ");
        TipoUsuario tipoUsuario = pp.adicionarTipoUsuario(name);
        log.info ("Adicionando Tipo de Usuario: " + tipoUsuario);
        return tipoUsuario;
    }
}

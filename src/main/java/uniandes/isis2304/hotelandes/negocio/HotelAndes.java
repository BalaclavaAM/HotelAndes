package uniandes.isis2304.hotelandes.negocio;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

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
    }
    public void cerrarUnidadPersistencia ()
    {
        pp.cerrarUnidadPersistencia ();
    }
    public TipoHabitacion adicionarTipoHabitacion(String tipo, Float precio, String descripcion){
        log.info ("Adicionando Tipo de bebida: " + tipo);
        TipoHabitacion tipoHabitacion = pp.adicionarTipoHabitacion (tipo,precio, descripcion);
        log.info ("Adicionando Tipo de bebida: " + tipoHabitacion);
        return tipoHabitacion;
    }
}

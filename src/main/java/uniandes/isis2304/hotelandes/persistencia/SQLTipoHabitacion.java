package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;

public class SQLTipoHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLTipoHabitacion(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long adicionarTipoHabitacion(PersistenceManager pm, String tipo, Float precio, String descripcion) {

        String sql = "INSERT INTO " + pHotelAndes.obtenerTablaTipoHabitacion() + " (tipo, precio, descripcion) VALUES (?, ?, ?)";
        Query q=pm.newQuery(SQL, sql);
        q.setParameters(tipo, precio, descripcion);
        return (long) q.executeUnique();
    }

    public List<TipoHabitacion> gTipoHabitacion(PersistenceManager pm) {
        List <TipoHabitacion> tipoHabitacion = null;
        try {
            String sql = "SELECT * FROM " + pHotelAndes.obtenerTablaTipoHabitacion();
            Query q = pm.newQuery(SQL, sql);
            q.setResultClass(TipoHabitacion.class);
            tipoHabitacion = (List<TipoHabitacion>) q.executeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoHabitacion;
    }
}

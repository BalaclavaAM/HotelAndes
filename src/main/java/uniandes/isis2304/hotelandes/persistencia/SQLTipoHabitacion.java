package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
}

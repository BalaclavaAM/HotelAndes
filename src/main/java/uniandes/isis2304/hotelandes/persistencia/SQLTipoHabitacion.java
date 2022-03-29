package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;

public class SQLTipoHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLTipoHabitacion(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long adicionarTipoHabitacion(PersistenceManager pm, Integer tipo, Float precio, String descripcion) {
        long id = 0;
        try {
            String sql = "INSERT INTO " + pHotelAndes.obtenerTablaTipoHabitacion() + " (tipo, precio, descripcion) VALUES (?, ?, ?)";
            id = (long) pm.newQuery(sql).execute(tipo, precio, descripcion);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}

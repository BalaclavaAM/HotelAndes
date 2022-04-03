package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLHabitacion(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }
    public long adicionarHabitacion(PersistenceManager pm, long tipo, long hotel, long numberoHabitacion)
    {
        System.out.println("entro al sql");
        Query q = pm.newQuery(SQL, "INSERT INTO " + pHotelAndes.obtenerTablaHabitacion() + "(tipo, hotel, numeroHabitacion) values (?, ?, ?)");
        q.setParameters(tipo,hotel, numberoHabitacion);
        return (long) q.executeUnique();
    }

}

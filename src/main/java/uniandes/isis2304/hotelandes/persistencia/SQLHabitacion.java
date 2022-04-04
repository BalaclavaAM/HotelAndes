package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;

    private PersistenciaHotelAndes pHotelAndes;
    public SQLHabitacion(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }


    public long adicionarHabitacion(PersistenceManager pm, long tipo, long hotel, long numberoHabitacion) {
        long id = 0;
        try {
            String sqlQuery = "INSERT INTO "+ pHotelAndes.obtenerTablaHabitacion() +" (TIPO, HOTEL, NUMEROHABITACION,valorAPagar) VALUES (?, ?, ?, ?)";
            Query q = pm.newQuery(SQL, sqlQuery);
            q.setResultClass(Habitacion.class);
            q.setParameters(tipo, hotel, numberoHabitacion, 0);
            return (long) q.executeUnique();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<Habitacion> obtenerHabitacion(PersistenceManager pm, long idHabitacion) {
        String query="SELECT * FROM "+ pHotelAndes.obtenerTablaHabitacion() +" WHERE ID = ? ; ";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Habitacion.class);
        q.setParameters(idHabitacion);
        return (List<Habitacion>) q.executeList();
    }
}

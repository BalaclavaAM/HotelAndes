package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.DineroPorHabitacion;
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
        String query="SELECT * FROM "+ pHotelAndes.obtenerTablaHabitacion() +" WHERE ID = ? ";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Habitacion.class);
        q.setParameters(idHabitacion);
        return (List<Habitacion>) q.executeList();
    }

    public List<Habitacion> obtenerHabitacionConNumero(PersistenceManager pm, long numeroHabitacion) {
        String query="SELECT * FROM "+ pHotelAndes.obtenerTablaHabitacion() +" WHERE numeroHabitacion = ? ";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Habitacion.class);
        q.setParameters(numeroHabitacion);
        return (List<Habitacion>) q.executeList();
    }
    public List<DineroPorHabitacion> dineroServiciosPorHabitacion(PersistenceManager pm, String inicio, String finals) {
        String query ="SELECT REGISTROSERVICIO.HABITACION as numHabitacion, SUM(COSTOTOTAL) as dinero FROM REGISTROSERVICIO WHERE REGISTROSERVICIO.fecha> to_timestamp('"+inicio+"', 'dd-mm-yyyy hh24:mi:ss') and REGISTROSERVICIO.fecha< to_timestamp('"+finals+"', 'dd-mm-yyyy hh24:mi:ss') GROUP BY REGISTROSERVICIO.HABITACION";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(DineroPorHabitacion.class);
        return (List<DineroPorHabitacion>) q.executeList();
    }


}

package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.DineroPorHabitacion;
import uniandes.isis2304.hotelandes.negocio.RegistroServicio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLRegistroServicio {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLRegistroServicio(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long agregarConsumoServicio(PersistenceManager pm, long idHabitacion, String lugarConsumo, String nombreCliente, long costoTotal, long idservicio, String fecha) {
        String query="INSERT INTO REGISTROSERVICIO (idHabitacion,lugarConsumo,nombreCliente,costoTotal,servicio,fecha) VALUES (?,?,?,?,?,TO_TIMESTAMP('?', 'YYYY-MM-DD HH24:MI:SS.FF'))";
        Query q=pm.newQuery(SQL, query);
        q.setParameters(idHabitacion, lugarConsumo, nombreCliente, costoTotal, idservicio, fecha);
        return (long) q.executeUnique();
    }
}
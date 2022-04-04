package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.PersonasHabitacion;
import uniandes.isis2304.hotelandes.negocio.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLPersonasHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLPersonasHabitacion(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public List<PersonasHabitacion> obtenerPersonasHabitacion(PersistenceManager pm, long idHabitacion) {
        Query q = pm.newQuery(SQL, "select * from" + pHotelAndes.obtenerTablaPersonasHabitacion() + " WHERE IDHABITACION=? AND USO=?;");
        q.setResultClass(PersonasHabitacion.class);
        q.setParameters(idHabitacion, 1);
        return (List<PersonasHabitacion>) q.executeList();
    }

    public long cambiarEstadoUso(PersistenceManager pm, long idHabitacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pHotelAndes.obtenerTablaPersonasHabitacion() + " USO = 0 WHERE" + " USO=1 AND IDHABITACION=?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();
    }

}

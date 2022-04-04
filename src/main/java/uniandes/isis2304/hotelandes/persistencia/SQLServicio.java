package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.PersonasHabitacion;
import uniandes.isis2304.hotelandes.negocio.Servicio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLServicio {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pp;

    public SQLServicio(PersistenciaHotelAndes pp) {
        this.pp = pp;
    }

    public List<Servicio> veinteServiciosPopulares(PersistenceManager pm, String inicio, String finals ) {
        String query="WITH TABLA_MARCADORES AS (SELECT * FROM( SELECT REGISTROSERVICIO.SERVICIO AS ID,SERVICIO.NOMBRE, COUNT(*) FROM REGISTROSERVICIO  INNER JOIN SERVICIO ON SERVICIO.ID=REGISTROSERVICIO.SERVICIO WHERE REGISTROSERVICIO.fecha> to_timestamp('"+inicio+"', 'dd-mm-yyyy hh24:mi:ss') and REGISTROSERVICIO.fecha< to_timestamp('"+finals+"', 'dd-mm-yyyy hh24:mi:ss') GROUP BY REGISTROSERVICIO.SERVICIO , SERVICIO.NOMBRE ORDER BY COUNT(*) DESC) WHERE ROWNUM<21), SERVICIOS_REALLY AS (SELECT  SERVICIO.ID, SERVICIO.NOMBRE,  SERVICIO.TIPOSERVICIO, SERVICIO.DESCUENTOTC FROM TABLA_MARCADORES INNER JOIN SERVICIO ON SERVICIO.ID = TABLA_MARCADORES.ID) SELECT * FROM SERVICIOS_REALLY";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Servicio.class);
        return (List<Servicio>) q.executeList();
    }
}

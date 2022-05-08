package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.*;

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
        String query="WITH TABLA_MARCADORES AS (SELECT * FROM( SELECT REGISTROSERVICIO.SERVICIO AS ID,SERVICIO.NOMBRE, COUNT(*) FROM REGISTROSERVICIO  INNER JOIN SERVICIO ON SERVICIO.ID=REGISTROSERVICIO.SERVICIO WHERE REGISTROSERVICIO.fecha> to_timestamp('"+inicio+"', 'dd-mm-yyyy hh24:mi:ss') and REGISTROSERVICIO.fecha< to_timestamp('"+finals+"', 'dd-mm-yyyy hh24:mi:ss') GROUP BY REGISTROSERVICIO.SERVICIO , SERVICIO.NOMBRE ORDER BY COUNT(*) DESC) WHERE ROWNUM<21), SERVICIOS_REALLY AS (SELECT  SERVICIO.ID, SERVICIO.NOMBRE,  SERVICIO.TIPOSERVICIO, SERVICIO.DESCUENTOTC FROM TABLA_MARCADORES INNER JOIN SERVICIO ON SERVICIO.ID = TABLA_MARCADORES.ID) SELECT SERVICIOS_REALLY.id as Id, SERVICIOS_REALLY.nombre as nombre, servicios_really.tiposervicio as tipoServicio, servicios_really.descuentotc as descuentoTC FROM SERVICIOS_REALLY";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Servicio.class);
        return (List<Servicio>) q.execute();
    }

    public long agregarTipoServicio(PersistenceManager persistenceManager, String nombreTipo) {
        Query q = persistenceManager.newQuery(SQL, "INSERT INTO TipoServicio (TIPO) values (?)");
        q.setParameters(nombreTipo);
        return (long) q.executeUnique();
    }

    public long agregarServicio(PersistenceManager persistenceManager, String nombreServicio, long idTipoServicio,
            boolean desc) {
        int descuentoTCN = 0;
        if (desc){
            descuentoTCN = 1;
        }
        Query q = persistenceManager.newQuery(SQL, "INSERT INTO Servicio (NOMBRE, TIPOSERVICIO, DESCUENTOTC) values (?, ?, ?)");
        q.setParameters(nombreServicio, idTipoServicio, descuentoTCN);
        return (long) q.executeUnique();
    }

}

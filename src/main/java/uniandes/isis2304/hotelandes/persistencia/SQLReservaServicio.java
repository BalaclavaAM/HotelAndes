package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.ReservaServicio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLReservaServicio {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLReservaServicio(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long registrarReservaServicio(PersistenceManager pm, String fechaentrada, String fechasalida, long idUsuario, long idServicio) {
        String sql = "INSERT INTO " + pHotelAndes.obtenerTablaReservaServicio() + " (horaInicio, horaFin, idUsuario,ACTIVO, idServicio ) VALUES (TO_TIMESTAMP ('"+fechaentrada+"', 'YYYY-MM-DD HH24:MI:SS.FF'),TO_TIMESTAMP ('"+fechasalida+"', 'YYYY-MM-DD HH24:MI:SS.FF'), ?,1,?)";
        Query q=pm.newQuery(SQL, sql);
        q.setParameters(idUsuario, idServicio);
        return (long) q.executeUnique();
    }

    public List<Reserva> obtenerReservaActivaConUsuario(PersistenceManager pm, long id) {
        String query="SELECT * FROM "+ pHotelAndes.obtenerTablaReservaServicio() +" WHERE idUsuario = ? AND  activo=?";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(ReservaServicio.class);
        q.setParameters(id,1);
        return (List<Reserva>) q.executeList();
    }

    public long reservaCambiarEstado(PersistenceManager pm, long id) {
        Query q = pm.newQuery(SQL, "UPDATE " + pHotelAndes.obtenerTablaReservaServicio()  + " SET ACTIVO = 0 WHERE" + " ACTIVO=1 AND IDHABITACION=?");
        q.setParameters(id);
        return (long) q.executeUnique();
    }
    public long reservaServicioCambiarEstadoConUsuario(PersistenceManager pm, long id) {
        Query q = pm.newQuery(SQL, "UPDATE " + pHotelAndes.obtenerTablaReservaServicio()  + " SET ACTIVO = 0 WHERE ACTIVO=1 AND idusuario=?");
        q.setParameters(id);
        return (long) q.executeUnique();
    }

}

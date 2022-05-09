package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.Servicio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.sql.Timestamp;
import java.util.List;

public class SQLReserva {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLReserva(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long registrarReserva(PersistenceManager pm, String fechaentrada, String fechasalida, long idUsuario,long idHabitacion) {
        String sql = "INSERT INTO " + pHotelAndes.obtenerTablaReserva() + " (horaInicio, horaFin, idUsuario,ACTIVO, idHabitacion ) VALUES (TO_TIMESTAMP ('"+fechaentrada+"', 'YYYY-MM-DD HH24:MI:SS.FF'),TO_TIMESTAMP ('"+fechasalida+"', 'YYYY-MM-DD HH24:MI:SS.FF'), ?,1,?)";
        Query q=pm.newQuery(SQL, sql);
        q.setParameters(idUsuario, idHabitacion);
        return (long) q.executeUnique();
    }

    public List<Reserva> obtenerReservaActivaConUsuario(PersistenceManager pm, long id) {
        String query="SELECT * FROM "+ pHotelAndes.obtenerTablaReserva() +" WHERE idUsuario = ? AND  activo=?";
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(Reserva.class);
        q.setParameters(id,1);
        return (List<Reserva>) q.executeList();
    }

    public long reservaCambiarEstado(PersistenceManager pm, long id) {
        Query q = pm.newQuery(SQL, "UPDATE " + pHotelAndes.obtenerTablaReserva() + " SET ACTIVO = 0 WHERE" + " ACTIVO=1 AND IDHABITACION=?");
        q.setParameters(id);
        return (long) q.executeUnique();
    }
    public long reservaCambiarEstadoConUsuario(PersistenceManager pm, long id) {
        Query q = pm.newQuery(SQL, "UPDATE " + pHotelAndes.obtenerTablaReserva() + " SET ACTIVO = 0 WHERE ACTIVO=1 AND idusuario=?");
        q.setParameters(id);
        return (long) q.executeUnique();
    }

    public long terminarConvencion(PersistenceManager persistenceManager, Timestamp horaInicio, Timestamp horaFin,
            long idUsuario) {
        long filasEditadas = 0;
        try {
            String sql = "UPDATE " + pHotelAndes.obtenerTablaReserva() + " SET ACTIVO = 0 WHERE" + " ACTIVO=1 AND idUsuario=? AND horaInicio=? AND horaFin=?";
            Query q = persistenceManager.newQuery(SQL, sql);
            q.setParameters(idUsuario, horaInicio, horaFin);
            filasEditadas = (long) q.executeUnique();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filasEditadas;
    }



}

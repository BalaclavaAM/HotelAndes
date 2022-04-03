package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.sql.Timestamp;

public class SQLReserva {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLReserva(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long registrarReserva(PersistenceManager pm, Timestamp fechaentrada, Timestamp fechasalida, long idUsuario) {
        String sql = "INSERT INTO " + pHotelAndes.obtenerTablaReserva() + " (horaInicio, horaFin, idUsuario) VALUES (?, ?, ?)";
        System.out.println("SSSSSSSSSSSS");
        Query q=pm.newQuery(SQL, sql);
        q.setParameters(fechaentrada, fechasalida, idUsuario);
        return (long) q.executeUnique();
    }

}

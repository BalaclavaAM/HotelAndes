package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.DineroPorHabitacion;
import uniandes.isis2304.hotelandes.negocio.RegistroServicio;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SQLRegistroServicio {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLRegistroServicio(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    static Timestamp convertStringToTimestamp(String strDate) {
        return Optional.ofNullable(strDate) // wrap the String into an Optional
                       .map(str -> LocalDate.parse(str).atStartOfDay()) // convert into a LocalDate and fix the hour:minute:sec to 00:00:00
                       .map(Timestamp::valueOf) // convert to Timestamp
                       .orElse(null); // if no value is present, return null
    }

    public long agregarConsumoServicio(PersistenceManager pm, long idHabitacion, String lugarConsumo, String nombreCliente, long costoTotal, long idservicio, String fecha) {
        long resultado = 0;
        try{
            //date in yyyy-mm-dd to timestamp
            Timestamp timestamp = convertStringToTimestamp(fecha);
            System.out.println("PARÁMETROS: " + idHabitacion + " " + lugarConsumo + " " + nombreCliente + " " + costoTotal + " " + idservicio + " " + timestamp);
            String query="INSERT INTO "+pHotelAndes.obtenerRegistroServicio()+" (idHabitacion,lugarConsumo,nombreCliente,costoTotal,servicio,fecha) VALUES (?,?,?,?,?,?)";
            Query q=pm.newQuery(SQL, query);
            q.setParameters(idHabitacion, lugarConsumo, nombreCliente, costoTotal, idservicio, timestamp);
            resultado=(long)q.executeUnique();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    public List<RegistroServicio> darRegistrosServicio(PersistenceManager pm, String nombreCliente, String fechaInicio,String fechaFin) {
        Query q = pm.newQuery(SQL, "Select *" +
                " From "+pHotelAndes.obtenerRegistroServicio() +
                " WHERE NOMBRECLIENTE =?" +
                " AND FECHA < TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF') AND" +
                " FECHA>TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF')");
        q.setParameters( nombreCliente, fechaFin,fechaInicio);
        q.setResultClass(RegistroServicio.class);
        return (List<RegistroServicio>) q.executeList();
    }


}

package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.DineroPorHabitacion;
import uniandes.isis2304.hotelandes.negocio.RegistroServicio;
import uniandes.isis2304.hotelandes.negocio.ResponseRegistroServicioStatistics;
import uniandes.isis2304.hotelandes.negocio.enums.FilterAnalisisType;
import uniandes.isis2304.hotelandes.negocio.enums.FilterTimeType;

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

    public List<ResponseRegistroServicioStatistics> darRegistroServicioTop(PersistenceManager pm, FilterAnalisisType filtro, boolean top, long filterParameter, String dateType, boolean count) {
        String query = "SELECT Actividad.Veces as Quantity, to_char(Actividad.Dia) as Tiempo, Actividad.Filter as Filter FROM "+
        "(SELECT @AGGREGATEFUNC Veces, to_char(RS.FECHA, '@DATETYPE') as Dia, @FILTROSELECT as Filter "+
        "FROM REGISTROSERVICIO RS "+
        
        "@INNER1 "+
        "@INNER2 "+
        
        "WHERE @FILTERWHERE "+
        "GROUP BY to_char(RS.FECHA, '@DATETYPE'), @FILTROSELECT ORDER BY Veces @ORDER) Actividad WHERE ROWNUM <= 10" ;
        if (top){
            query = query.replace("@ORDER", "DESC");
        } else {
            query = query.replace("@ORDER", "ASC");
        }
        if (count){
            query = query.replace("@AGGREGATEFUNC", "COUNT(RS.ID)");
        } else {
            query = query.replace("@AGGREGATEFUNC", "SUM(RS.COSTOTOTAL)");
        }
        switch (filtro) {
            case TIPOHABITACION:
                query = query.replace("@FILTROSELECT", "TH.TIPO");
                query = query.replace("@INNER1", "INNER JOIN Habitacion H on IDHABITACION=h.ID");
                query = query.replace("@INNER2", "INNER JOIN TipoHabitacion TH on H.TIPO = TH.ID");
                query = query.replace("@FILTERWHERE", "TH.ID = '"+filterParameter+"'");
                break;
            case SERVICIO:
                query = query.replace("@FILTROSELECT", "S.NOMBRE");
                query = query.replace("@INNER1", "INNER JOIN SERVICIO S on RS.SERVICIO=S.ID");
                query = query.replace("@INNER2", "");
                query = query.replace("@FILTERWHERE", "RS.SERVICIO = '"+filterParameter+"'");
                break;
        }
        if (dateType.equals("Semana")){
            query = query.replace("@DATETYPE", "WW");
        } else if (dateType.equals("Mes")){
            query = query.replace("@DATETYPE", "MM");
        } else if (dateType.equals("Año")){
            query = query.replace("@DATETYPE", "YYYY");
        } else if (dateType.equals("Día")) {
            query = query.replace("@DATETYPE", "DD-MON-YYYY");
        } else {
            query = query.replace("@DATETYPE", "DD-MON-YYYY");
        }
        Query q = pm.newQuery(SQL, query);
        q.setResultClass(ResponseRegistroServicioStatistics.class);
        return (List<ResponseRegistroServicioStatistics>) q.executeList();
    }

}

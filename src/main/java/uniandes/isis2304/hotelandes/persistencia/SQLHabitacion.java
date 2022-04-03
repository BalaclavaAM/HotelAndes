package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;

public class SQLHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;

    public SQLHabitacion(PersistenciaHotelAndes pHotelAndes) {
    }


    public long adicionarHabitacion(PersistenceManager pm, long tipo, long hotel, long numberoHabitacion) {
        long id = -1;
        try {
            String sqlQuery = "INSERT INTO HABITACION (ID, TIPO, HOTEL, NUMEROHABITACION) VALUES (?, ?, ?, ?)";
            id = (long) pm.newQuery(sqlQuery).execute(tipo, hotel, numberoHabitacion);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}

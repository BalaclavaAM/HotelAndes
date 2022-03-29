package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;

public class SQLBar {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLBar(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long createBar(PersistenceManager pm, long id, Integer capacidad, Integer estiloBar){
        long idBar = 0;
        try {
            idBar = (long) pm.newQuery(SQL, "INSERT INTO "+pHotelAndes.obtenerTablaBar()+" (ID, CAPACIDAD, ESTILO) VALUES (?, ?, ?)").execute(id, capacidad, estiloBar);
        }
        catch (Exception e) {
            System.out.println("Error al crear el bar: " + e.getMessage());
        }
        return idBar;
    }
}

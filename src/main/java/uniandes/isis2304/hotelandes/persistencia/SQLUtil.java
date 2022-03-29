package uniandes.isis2304.hotelandes.persistencia;

public class SQLUtil {
    private final static String SQL = PersistenciaHotelAndes.SQL;

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * El manejador de persistencia general de la aplicación
     */
    private PersistenciaHotelAndes pp;

    public SQLUtil  (PersistenciaHotelAndes pp)
    {
        this.pp = pp;
    }


}

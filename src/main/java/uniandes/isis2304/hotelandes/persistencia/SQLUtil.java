package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.parranderos.interfazApp.PersistenciaHotelAndes;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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

    public long nextval (PersistenceManager pm)
    {
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqParranderos () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
    }
}

package uniandes.isis2304.parranderos.persistenciaHotel;

import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTipoHabitacion {
    private final static String SQL = PersistenciaHotelAndes.SQL;

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * El manejador de persistencia general de la aplicación
     */
    private PersistenciaHotelAndes pp;

    public SQLTipoHabitacion (PersistenciaHotelAndes pp)
    {
        this.pp = pp;
    }
    public long adicionarTipoHabitacion (PersistenceManager pm, long idTipoHabitacion, String nombre, long precio, String descripcion)
    {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTipoHabitacion() + "(id, nombre, precio) values (?, ?, ?, ?)");
        q.setParameters(idTipoHabitacion, nombre, precio, descripcion); // aca hay que ver que pasa con los enums
        return (long) q.executeUnique();
    }
}

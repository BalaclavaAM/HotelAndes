package uniandes.isis2304.parranderos.persistenciaHotel;

import org.apache.log4j.Logger;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.negocioHotel.TipoHabitacion;
import uniandes.isis2304.parranderos.persistencia.*;

import javax.jdo.*;
import java.util.LinkedList;
import java.util.List;

public class PersistenciaHotelAndes {
    private static Logger log = Logger.getLogger(PersistenciaParranderos.class.getName());

    public final static String SQL = "javax.jdo.query.SQL";

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
     */
    private static PersistenciaHotelAndes instance;

    private PersistenceManagerFactory pmf;

    private List<String> tablas;

    private SQLTipoHabitacion sqlTipoHabitacion;

    private SQLUtil sqlUtil;

    private PersistenciaHotelAndes ()
    {
        pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");
        crearClasesSQL ();

        // Define los nombres por defecto de las tablas de la base de datos
        tablas = new LinkedList<String>();
        tablas.add ("Parranderos_sequence");
        tablas.add ("TIPOHABITACION");

    }
    private void crearClasesSQL ()
    {
        sqlTipoHabitacion = new SQLTipoHabitacion(this);

    }
    public String darSeqParranderos ()
    {
        return tablas.get (0);
    }

    /**
     * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
     */
    public String darTablaTipoHabitacion ()
    {
        return tablas.get (1);
    }
    public TipoHabitacion adicionarTipoHabitacion(String tipo, long precio, String descripcion)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idH = nextval ();
            long tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pm,  idH, tipo, precio, descripcion);
            tx.commit();

            log.trace ("Inserción de tipo de bebida: " + tipo + ": " + tuplasInsertadas + " tuplas insertadas");

            return new TipoHabitacion (idH, tipo,precio, descripcion);


        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    private long nextval ()
    {
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
    private String darDetalleException(Exception e)
    {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
        {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions() [0].getMessage();
        }
        return resp;
    }

}

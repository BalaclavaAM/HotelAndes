package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLUsuario {
    private final static String SQL = PersistenciaHotelAndes.SQL;

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * El manejador de persistencia general de la aplicación
     */
    private PersistenciaHotelAndes pp;

    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * Constructor
     * @param pp - El Manejador de persistencia de la aplicación
     */
    public SQLUsuario (PersistenciaHotelAndes pp)
    {
        this.pp = pp;
    }

    public List<Usuario> darUsuarioPorLogin(PersistenceManager pm, String login) {

        System.out.println("llego a SQLUSUARIO");
        String select= "SELECT " + pp.darTablaUsuario()+ ".id ,"+ pp.darTablaUsuario()+ ".nombre, "+ pp.darTablaUsuario()+ ".documento, "+ pp.darTablaUsuario()+ ".tipoPlan, "+ pp.darTablaUsuario()+ ".tipoUsuario, "+ pp.darTablaUsuario()+ ".tipoDocumento, "+ pp.darTablaUsuario()+ ".login, "+ pp.darTablaUsuario()+ ".contrasena, "+  pp.darTablaTipoUsuario()+ ".tipo as nombreTipoUsuario ";
        String from = "FROM " + pp.darTablaUsuario() +" INNER JOIN "+pp.darTablaTipoUsuario()+" ON " + pp.darTablaUsuario() +"."+pp.darTablaTipoUsuario()+" = "+pp.darTablaTipoUsuario()+".ID ";
        String where = "WHERE USUARIO.LOGIN= ?";
        System.out.println(select+from+where);
        Query q = pm.newQuery(SQL, select+from+where);

        q.setResultClass(Usuario.class);
        q.setParameters(login);
        return (List<Usuario>) q.executeList();
    }


}

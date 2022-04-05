package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoUsuario;

public class SQLTipoUsuario {
    public final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pHotelAndes;

    SQLTipoUsuario(PersistenciaHotelAndes pHotelAndes) {
        SQLTipoUsuario.pHotelAndes = pHotelAndes;
    }

    public static long insertTipoUsuario(PersistenceManager pm, String tipo){
        long id = 0;
        try{
            id = (long)pm.newQuery(SQL, "INSERT INTO TipoUsuario (tipo) VALUES (?)").execute(tipo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public static List getUserTypes(PersistenceManager pm){
        List tiposUsuarios = null;
        try{
            Query q = pm.newQuery(SQL, "SELECT ID, TIPO FROM TipoUsuario");
            q.setResultClass(TipoUsuario.class);
            tiposUsuarios = (List) q.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposUsuarios;
    }
}

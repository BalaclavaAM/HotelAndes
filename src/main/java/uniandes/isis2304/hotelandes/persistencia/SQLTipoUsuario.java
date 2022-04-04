package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;

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
            tiposUsuarios = (List)pm.newQuery(SQL, "SELECT * FROM TipoUsuario").execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposUsuarios;
    }
}

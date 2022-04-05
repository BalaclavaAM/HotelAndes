package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoDocumento;

public class SQLTipoDocumento {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pp;

    public SQLTipoDocumento(PersistenciaHotelAndes pp) {
        this.pp = pp;
    }

    public static List getDocumentTypes(PersistenceManager pm){
        List tiposDocumento = null;
        try{
            Query q = pm.newQuery(SQL, "SELECT ID, TIPO FROM TipoDocumento");
            q.setResultClass(TipoDocumento.class);
            tiposDocumento = (List) q.executeList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposDocumento;
    }
}

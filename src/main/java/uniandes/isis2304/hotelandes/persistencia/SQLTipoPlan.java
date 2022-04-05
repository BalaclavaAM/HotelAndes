package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoPlan;

public class SQLTipoPlan {
    public final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pHotelAndes;
    

    SQLTipoPlan(PersistenciaHotelAndes pHotelAndes) {
        SQLTipoPlan.pHotelAndes = pHotelAndes;
    }

    public static List getTiposPlanes(PersistenceManager pm){
        List tiposPlanes = null;
        try{
            Query q = pm.newQuery(SQL, "SELECT ID, TIPO FROM TipoPlan");
            q.setResultClass(TipoPlan.class);
            tiposPlanes = (List) q.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposPlanes;
    }
}

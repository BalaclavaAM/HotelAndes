package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;

public class SQLTipoPlan {
    public final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pHotelAndes;
    

    SQLTipoPlan(PersistenciaHotelAndes pHotelAndes) {
        SQLTipoPlan.pHotelAndes = pHotelAndes;
    }

    public static List getTiposPlanes(PersistenceManager pm){
        List tiposPlanes = null;
        try{
            tiposPlanes = (List)pm.newQuery(SQL, "SELECT * FROM TipoPlan").execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposPlanes;
    }
}

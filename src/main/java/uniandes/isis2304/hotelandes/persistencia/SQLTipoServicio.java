package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoServicio;

public class SQLTipoServicio {
    public final static String SQL = PersistenciaHotelAndes.SQL;
    private static PersistenciaHotelAndes pHotelAndes;

    public SQLTipoServicio(PersistenciaHotelAndes pHotelAndes) {
        SQLTipoServicio.pHotelAndes = pHotelAndes;
    }

    public List getTiposServicios(PersistenceManager pm) {
        List tiposServicios = null;
        try {
            Query q = pm.newQuery(SQL, "SELECT ID, TIPO FROM TipoServicio");
            q.setResultClass(TipoServicio.class);
            tiposServicios = (List) q.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiposServicios;
    }
}

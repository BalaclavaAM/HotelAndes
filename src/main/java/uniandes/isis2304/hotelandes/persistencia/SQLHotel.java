package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Hotel;

public class SQLHotel {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;
    public SQLHotel(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }
    public long createHotel(PersistenceManager pm, String nombre, Integer estrellas, Integer cadenaHotelera){
        long idHotel = 0;
        try{
            idHotel = (long) pm.newQuery(SQL, "INSERT INTO "+pHotelAndes.obtenerTablaHotel()+" (NOMBRE, ESTRELLAS, CADENAHOTELERA) VALUES (?, ?, ?)").execute(nombre, estrellas, cadenaHotelera);
        }catch(Exception e){
            e.printStackTrace();
        }
        return idHotel;
    }

    public long getIdHotel(PersistenceManager pm, String nombre){
        long idHotel = 0;
        try{
            idHotel = (long) pm.newQuery(SQL, "SELECT ID FROM "+pHotelAndes.obtenerTablaHotel()+" WHERE NOMBRE = ?").execute(nombre);
        }catch(Exception e){
            e.printStackTrace();
        }
        return idHotel;
    }
    public List getAllHoteles(PersistenceManager persistenceManager) {
        List hoteles = null;
        try{
            String query = "SELECT\n" +
                    "    ID,\n" +
                    "    NOMBRE,\n" +
                    "    ESTRELLAS,\n" +
                    "    CADENAHOTELERA\n" +
                    "FROM\n" +
                    "    HOTEL";
            System.out.println("QUERY A UTILIZAR: "+query);
            Query q = persistenceManager.newQuery(SQL, query);
            q.setResultClass(Hotel.class);
            hoteles = (List) q.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return hoteles;
    }
}

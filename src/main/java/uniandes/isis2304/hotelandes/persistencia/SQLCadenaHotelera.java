package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;

public class SQLCadenaHotelera {
    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pHotelAndes;

    public SQLCadenaHotelera(PersistenciaHotelAndes pHotelAndes) {
        this.pHotelAndes = pHotelAndes;
    }

    public long insertarCadenaHotelera(PersistenceManager pm, String nombre){
        long id = 0;
        try{
            id = (long) pm.newQuery(SQL, "INSERT INTO "+pHotelAndes.obtenerTablaCadenaHotelera()+" (NOMBRE) VALUES (?);").execute(nombre);
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public long getIdCadenaHotelera(PersistenceManager pm, String nombre){
        long id = 0;
        try{
            id = (long) pm.newQuery(SQL, "SELECT ID FROM "+pHotelAndes.obtenerTablaCadenaHotelera()+" WHERE NOMBRE = ?;").execute(nombre);
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public String getNameCadenaHotelera(PersistenceManager pm, long id){
        String nombre = "";
        try{
            nombre = (String) pm.newQuery(SQL, "SELECT NOMBRE FROM "+pHotelAndes.obtenerTablaCadenaHotelera()+" WHERE ID = ?;").execute(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return nombre;
    }
}

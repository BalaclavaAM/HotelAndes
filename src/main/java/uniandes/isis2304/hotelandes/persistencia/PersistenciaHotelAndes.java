package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import oracle.sql.SQLUtil;
import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PersistenciaHotelAndes {
    private static Logger theLogger = Logger.getLogger(PersistenciaHotelAndes.class.getName());

    private static final String SQL = "javax.jdo.query.SQL";
    public static final String PMF_NAME = "HotelAndes";
    private static PersistenciaHotelAndes instance;
    private PersistenceManagerFactory pmf;
    private List<String> tablas;
    private SQLUtil sqlUtil;

    private PersistenciaHotelAndes() {
        pmf = JDOHelper.getPersistenceManagerFactory(PMF_NAME);
        tablas = new LinkedList<>();
        tablas.add("hotel");
        tablas.add("habitacion");
        tablas.add("reserva");
        tablas.add("usuario");
        tablas.add("tipoHabitacion");
        tablas.add("cadenaHotelera");
        tablas.add("tipoDocumento");
        tablas.add("cuentaHabitacion");
        tablas.add("usoActual");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL_HOTEL");
        tablas.add("HOTEL_HOTEL_HOTEL_HOTEL_HOT");
    }
}

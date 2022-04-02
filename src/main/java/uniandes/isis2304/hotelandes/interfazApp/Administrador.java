package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.parranderos.interfazApp.InterfazParranderosApp;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.swing.*;

public class Administrador extends JFrame {
    private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigAdministrador.json";

    /**
     * Ruta al archivo de configuración de los nombres de tablas de la base de datos
     */
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_HotelAndes.json";

    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;

    /**
     * Asociación a la clase principal del negocio.
     */
    private HotelAndes hotelAndes;

    /* ****************************************************************
     * 			Atributos de interfaz
     *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;

    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;

    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;
}

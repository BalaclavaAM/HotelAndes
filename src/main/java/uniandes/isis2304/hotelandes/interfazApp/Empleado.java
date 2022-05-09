package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Hotel;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import uniandes.isis2304.hotelandes.negocio.VOHabitacion;
import uniandes.isis2304.hotelandes.negocio.VOReserva;
import uniandes.isis2304.hotelandes.negocio.VOUsuario;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.jdo.JDODataStoreException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

public class Empleado extends JFrame implements ActionListener {
    private static Logger log = Logger.getLogger(Administrador.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigEmpleado.json";

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

    public Empleado() {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);

        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame();
        if (guiConfig != null) {
            crearMenu(guiConfig.getAsJsonArray("menuBar"));
        }

        tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
        hotelAndes = new HotelAndes(tableConfig);

        String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos();

        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
    }

    private JsonObject openConfig(String tipo, String archConfig) {
        JsonObject config = null;
        try {
            Gson gson = new Gson();
            FileReader file = new FileReader(archConfig);
            JsonReader reader = new JsonReader(file);
            config = gson.fromJson(reader, JsonObject.class);
            log.info("Se encontró un archivo de configuración válido: " + tipo);
        } catch (Exception e) {
//			e.printStackTrace ();
            log.info("NO se encontró un archivo de configuración válido");
            JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
        }
        return config;
    }

    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame() {
        int alto = 0;
        int ancho = 0;
        String titulo = "";

        if (guiConfig == null) {
            log.info("Se aplica configuración por defecto");
            titulo = "ADMIN";
            alto = 300;
            ancho = 500;
        } else {
            log.info("Se aplica configuración indicada en el archivo de configuración");
            titulo = guiConfig.get("title").getAsString();
            alto = guiConfig.get("frameH").getAsInt();
            ancho = guiConfig.get("frameW").getAsInt();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 50);
        setResizable(true);
        setBackground(Color.WHITE);

        setTitle(titulo);
        setSize(ancho, alto);
    }
    public void agregarConsumoServicio() {
        System.out.println("entro en la interfaz");
        try {
            List<Hotel> hoteles = hotelAndes.darHoteles();
            if (hoteles.get(0) == null) {
                JOptionPane.showMessageDialog(null, "No hay hoteles", "HotelAndes", JOptionPane.ERROR_MESSAGE);
                throw new Exception("No hay hoteles");
            }
            int posHotel = JOptionPane.showOptionDialog(this, "Seleccione el hotel", "Seleccion de Hotel", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, hoteles.toArray(), null);
            long idHotel = hoteles.get(posHotel).getId();

            List<Habitacion> habitaciones = hotelAndes.darHabitacionesPorHotel(idHotel);
            if(habitaciones.get(0) == null){
                JOptionPane.showMessageDialog(this, "No hay habitaciones", "HotelAndes", JOptionPane.ERROR_MESSAGE);
                throw new Exception("No hay habitaciones");
            }
            JComboBox jcd = new JComboBox(habitaciones.toArray());
            jcd.setSelectedIndex(0);
            jcd.setEditable(false);
            JOptionPane.showMessageDialog(this, jcd, "Seleccione la habitacion", JOptionPane.QUESTION_MESSAGE, null);

            int posHabitacion = jcd.getSelectedIndex();
            long idHabitacion = habitaciones.get(posHabitacion).getId();


            List<Servicio> servicios = hotelAndes.obtenerServicios();
            JComboBox jcs = new JComboBox(servicios.toArray());
            jcs.setSelectedIndex(0);
            jcs.setEditable(false);

            JOptionPane.showMessageDialog(this, jcs, "Seleccione el servicio", JOptionPane.QUESTION_MESSAGE, null);

            int posServicio = jcs.getSelectedIndex();
            long idServicio = servicios.get(posServicio).getId();


            String lugarConsumo = JOptionPane.showInputDialog(this, "Donde se hizo este consumo?:", "Lugar", JOptionPane.QUESTION_MESSAGE);

            String nombreCliente = JOptionPane.showInputDialog(this, "Nombre del cliente:", "Lugar", JOptionPane.QUESTION_MESSAGE);

            long costoTotal= Long.parseLong(JOptionPane.showInputDialog(this, "costo total: diguite un numero:", "costototal", JOptionPane.QUESTION_MESSAGE));


            String fecha= JOptionPane.showInputDialog(this, "Ponga la fecha de final en el siguiente formato 2012-11-01 (si el numero no tiene decena poner 0)año-mes-dia", "FECHA FINAL", JOptionPane.QUESTION_MESSAGE);
            long tb  = hotelAndes.agregarConsumoServicio(idHabitacion,lugarConsumo,nombreCliente,costoTotal,idServicio,fecha);
            if(tb!=1){
                throw new Exception("no se realizo: ");
            }

            String resultado = "Se insertó en agregarConsumoServicio:\n\n";
            resultado += "agregarConsumoServicio: " + tb;
            resultado += "\n Operación terminada";
            panelDatos.actualizarInterfaz(resultado);
        } catch (Exception e) {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }
    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     *
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(JsonArray jsonMenu) {
        // Creación de la barra de menús
        menuBar = new JMenuBar();
        for (JsonElement men : jsonMenu) {
            // Creación de cada uno de los menús
            JsonObject jom = men.getAsJsonObject();

            String menuTitle = jom.get("menuTitle").getAsString();
            JsonArray opciones = jom.getAsJsonArray("options");

            JMenu menu = new JMenu(menuTitle);

            for (JsonElement op : opciones) {
                // Creación de cada una de las opciones del menú
                JsonObject jo = op.getAsJsonObject();
                String lb = jo.get("label").getAsString();
                String event = jo.get("event").getAsString();

                JMenuItem mItem = new JMenuItem(lb);
                mItem.addActionListener(this);
                mItem.setActionCommand(event);

                menu.add(mItem);
            }
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        try {

            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            /*Administrador interfaz = new Administrador( );
            interfaz.setVisible( true );*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent pEvento) {
        String evento = pEvento.getActionCommand();
        try {
            System.out.println(evento);
            Method req = Empleado.class.getMethod(evento);
            req.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String darDetalleException(Exception e)
    {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
        {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions() [0].getMessage();
        }
        return resp;
    }

    /**
     * Genera una cadena para indicar al usuario que hubo un error en la aplicación
     * @param e - La excepción generada
     * @return La cadena con la información de la excepción y detalles adicionales
     */
    private String generarMensajeError(Exception e)
    {
        String resultado = "************ Error en la ejecución\n";
        resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
        resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
        return resultado;
    }
}

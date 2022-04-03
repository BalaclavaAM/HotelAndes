package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.VOHabitacion;
import uniandes.isis2304.hotelandes.negocio.VOTipoHabitacion;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;
import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;

import javax.jdo.JDODataStoreException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

@SuppressWarnings("serial")
public class Administrador extends JFrame implements ActionListener {
    private static Logger log = Logger.getLogger(Administrador.class.getName());

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

    public Administrador() {
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
    /* ****************************************************************
     * 			Métodos de la Interacción
     *****************************************************************/

    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     *
     * @param pEvento - El evento del usuario
     */
    @Override
    public void actionPerformed(ActionEvent pEvento) {
        String evento = pEvento.getActionCommand();
        try {
            Method req = Administrador.class.getMethod(evento);
            req.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ****************************************************************
     * 			Programa principal
     *****************************************************************/

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     *
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
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

    /////////METODOS DE TIPOHABITACION
    public void adicionarTipoHabitacion() {
        try {
            String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del tipo habitacion?", "Adicionar Nombre tipo habitacion", JOptionPane.QUESTION_MESSAGE);
            Float precio = Float.parseFloat(JOptionPane.showInputDialog(this, "Precio habitacion (poner solo numeros)?", "Adicionar precio tipo habitacion", JOptionPane.QUESTION_MESSAGE));
            String descripcion = JOptionPane.showInputDialog(this, "Poner descripcion de la habitacion", "Adicionar descripcion tipo habitacion", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipo != null && precio !=null &&descripcion!=null) {
                VOTipoHabitacion tb = hotelAndes.adicionarTipoHabitacion(nombreTipo, precio, descripcion);
                if (tb == null) {
                    throw new Exception("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
                }
                String resultado = "En adicionarTipoBebida\n\n";
                resultado += "Tipo de bebida adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }


    }
    public void adicionarHabitacion() {
        System.out.println("entro en la interfaz");
        try {
            long tipo = Long.parseLong(JOptionPane.showInputDialog(this, "Tipo Habitacion (poner solo numeros)?", "Adicionar tipo habitacion", JOptionPane.QUESTION_MESSAGE));
            long hotel = Long.parseLong(JOptionPane.showInputDialog(this, "Hotel habitacion (poner solo numeros)?", "Adicionar hotel habitacion", JOptionPane.QUESTION_MESSAGE));
            long numberoHabitacion = Long.parseLong(JOptionPane.showInputDialog(this, "numero habitacion (poner solo numeros)?", "Adicionar numero habitacion", JOptionPane.QUESTION_MESSAGE));
            if (tipo >0 && hotel >0 && numberoHabitacion>0) {
                VOHabitacion tb = hotelAndes.adicionarHabitacion(tipo, hotel, numberoHabitacion);
                if (tb == null) {
                    throw new Exception("No se pudo crear un tipo de bebida con nombre: " + tipo);
                }
                String resultado = "En adicionarTipoBebida\n\n";
                resultado += "Tipo de bebida adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }


    }


    /* ****************************************************************
     * 			Métodos privados para la presentación de resultados y otras operaciones
     *****************************************************************/
    /**
     * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
     * @param lista - La lista con los tipos de bebida
     * @return La cadena con una líea para cada tipo de bebida recibido
     */
    private String listarTiposBebida(List<VOTipoBebida> lista)
    {
        String resp = "Los tipos de bebida existentes son:\n";
        int i = 1;
        for (VOTipoBebida tb : lista)
        {
            resp += i++ + ". " + tb.toString() + "\n";
        }
        return resp;
    }

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
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

package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.TipoPlan;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

@SuppressWarnings("serial")
public class OrganizadorEventos extends JFrame implements ActionListener {
    private static Logger log = Logger.getLogger(Administrador.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigOrganizadorEventos.json";

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

    public OrganizadorEventos() {
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
            Method req = OrganizadorEventos.class.getMethod(evento);
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
    public void RF12() {
        String hotel= JOptionPane.showInputDialog(this, "Ingrese el nombre del hotel", JOptionPane.QUESTION_MESSAGE);
        String cuartos = JOptionPane.showInputDialog(this, "Ponga el tipo y la cantidad en el sigiente formato Tipo1, cantidad1, Tipo2, Cantidad2, ..., Tipon, cantidadn", JOptionPane.QUESTION_MESSAGE);
        String[] CuartosArray = cuartos.split(",");
        String inicio = JOptionPane.showInputDialog(this, "Ponga la fecha de inicio en el siguiente formato 2012-11-01 (si el numero no tiene decena poner 0) año-mes-dia ->dia(numero mayor que 0 y menor que 32, esto depende del mes )-mes(de 0 a 11 donde 0 es enero)-año(numerormayor que 0)", "FECHA INICIO", JOptionPane.QUESTION_MESSAGE);
        inicio+= " 00:00:01.742000000";
        String finals= JOptionPane.showInputDialog(this, "Ponga la fecha de final en el siguiente formato 2012-11-01 (si el numero no tiene decena poner 0)año-mes-dia", "FECHA FINAL", JOptionPane.QUESTION_MESSAGE);
        finals+= " 00:00:01.742000000";
        String servicios = JOptionPane.showInputDialog(this, "Ponga la id de los servicios separados por , ejemplo: id1, id2, id3, ... , idn", JOptionPane.QUESTION_MESSAGE);
        String[] ServiciosArray = servicios.split(",");
        // reserva habitaciones
        long idusuario=Long.parseLong(JOptionPane.showInputDialog(this, "idUsuario", "IDUSUARIO", JOptionPane.QUESTION_MESSAGE));
        for (int i = 0; i < CuartosArray.length; i++) {
            CuartosArray[i] = CuartosArray[i].trim();
        }

        for (int i = 0; i < CuartosArray.length; i+=2) {
            String tipo = CuartosArray[i];
            int cantidad = Integer.parseInt(CuartosArray[i+1]);
            List<Habitacion> tiposPlan = hotelAndes.obtenerHabitacionesSinOcupar(tipo, hotel,cantidad );
            if (tiposPlan.isEmpty()) {
                //escribir error en pantalla
            }
            else if (tiposPlan.size() < cantidad) {
                //escribir error en pantalla
            }
            else {
                for (Habitacion h : tiposPlan) {
                    long tb = hotelAndes.registrarReserva(inicio,finals,idusuario, h.getId());
                }
            }
        }
        // reserva habitaciones
        // reserva servicios
        for (int i = 0; i < ServiciosArray.length; i++) {
            ServiciosArray[i] = ServiciosArray[i].trim();
        }
        for (int i = 0; i < ServiciosArray.length; i++) {
            long tb = hotelAndes.registrarReservaServicio(idusuario,inicio,finals, Long.parseLong(ServiciosArray[i]));
            if (tb == 0) {
                //escribir error en pantalla
            }
        }
        // reserva servicios

    }
    public void RF13() throws Exception {
        long idusuario=Long.parseLong(JOptionPane.showInputDialog(this, "idUsuario", "IDUSUARIO", JOptionPane.QUESTION_MESSAGE));
        //Liberacion de habitaciones
        long ln= hotelAndes.reservaCambiarEstadoConUsuario(idusuario);
        if (ln==0) {
            throw new Exception("No se pudo realizar: ");
        }
        long ln2= hotelAndes.reservaServicioCambiarEstadoConUsuario(idusuario);
        if (ln2==0) {
            throw new Exception("No se pudo realizar: ");
        }
    }
}

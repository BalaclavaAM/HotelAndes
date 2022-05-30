package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.*;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class OrganizadorEventos extends JFrame implements ActionListener {
    private static Logger log = Logger.getLogger(Administrador.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigOrganizador.json";

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
    public void RF12() throws Exception {
        String hotel= JOptionPane.showInputDialog(this, "Ingrese la id del hotel", JOptionPane.QUESTION_MESSAGE);
        String cuartos = JOptionPane.showInputDialog(this, "Ponga el tipo y la cantidad en el sigiente formato Tipo1 (SIENDO LA ID DEL TIPO), cantidad1, Tipo2 (SIENDO LA ID DEL TIPO), Cantidad2, ..., Tipon, cantidadn", JOptionPane.QUESTION_MESSAGE);
        String[] CuartosArray = cuartos.split(",");
        String inicio = JOptionPane.showInputDialog(this, "Ponga la fecha de inicio en el siguiente formato 2012-10-01 (si el numero no tiene decena poner 0) año-mes-dia ->dia(numero mayor que 0 y menor que 32, esto depende del mes )-mes(de 0 a 11 donde 0 es enero)-año(numerormayor que 0)", "FECHA INICIO", JOptionPane.QUESTION_MESSAGE);
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
            long tipo = Long.parseLong(CuartosArray[i]) ;
            int cantidad = Integer.parseInt(CuartosArray[i+1]);
            List<VOHabitacion> tiposPlan = hotelAndes.obtenerHabitacionesSinOcupar(tipo, Long.parseLong(hotel),cantidad );
            if (tiposPlan.isEmpty()) {
                throw new Exception("No hay habitaciones: ");
            }
            else if (tiposPlan.size() < cantidad) {
                throw new Exception("No hay habitaciones suficientes: ");
            }
            else {
                int a = 0;
                for (a=0; a<tiposPlan.size(); a++) {
                    //a
                    VOHabitacion habitacion = tiposPlan.get(a);
                    long habitacionId = habitacion.getId();
                    long tb = hotelAndes.registrarReserva(inicio,finals,idusuario, habitacionId);
                }

            }
            panelDatos.actualizarInterfaz(tiposPlan.toString());
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
        long ln2= hotelAndes.reservaServicioCambiarEstadoConUsuario(idusuario);
    }


    public void RF14() throws Exception {
        List<Usuario> usuariosConConvenciones = hotelAndes.getUsersWConvenciones(); 
        if (usuariosConConvenciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay usuarios con convenciones");
            throw new Exception("No hay usuarios con convenciones");
        }
        JComboBox usuarios = new JComboBox(usuariosConConvenciones.toArray());
        usuarios.setSelectedIndex(0);
        usuarios.setEditable(false);

        JOptionPane.showMessageDialog(this, usuarios, "Seleccione el usuario que creó la convención", JOptionPane.QUESTION_MESSAGE);
        Usuario usuario = (Usuario) usuarios.getSelectedItem();
        long idUsuario = usuario.getId();

        List<Reserva> reservasServicios = hotelAndes.obtenerReservasActivaConUsuario(idUsuario);
        if (reservasServicios == null) {
            JOptionPane.showMessageDialog(this, "No hay convenciones con este usuario activas");
            throw new Exception("No hay convenciones con este usuario activas");
        }
        HashMap <java.sql.Timestamp, List<Reserva>> convenciones = new HashMap<java.sql.Timestamp, List<Reserva>>();
        for (Reserva reserva : reservasServicios) {
            if (convenciones.containsKey(reserva.horaInicio)){
                convenciones.get(reserva.horaInicio).add(reserva);
            } else {
                List<Reserva> reservas = new LinkedList<>();
                reservas.add(reserva);
                convenciones.put(reserva.horaInicio, reservas);
            }
        }
        List convencionesList = new LinkedList();
        for (java.sql.Timestamp hora : convenciones.keySet()) {
            List<Reserva> reservas = convenciones.get(hora);
            List asistentes = new LinkedList<>();
            for (Reserva reserva : reservas) {
                asistentes.add(reserva.getIdUsuario());
            }
            convencionesList.add(new Convencion(asistentes, hora, reservas.get(0).getHoraFin()));
        }
        if (convencionesList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay convenciones con este usuario activas");
            throw new Exception("No hay convenciones con este usuario activas");
        }
        JComboBox convencionesCombo = new JComboBox(convencionesList.toArray());
        convencionesCombo.setSelectedIndex(0);
        convencionesCombo.setEditable(false);
        
        JOptionPane.showMessageDialog(this, convencionesCombo, "Seleccione la convención", JOptionPane.QUESTION_MESSAGE);

        Convencion convencion = (Convencion) convencionesCombo.getSelectedItem();

        Boolean delete = JOptionPane.showConfirmDialog(this, "¿Desea terminar la convención?", "Terminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (delete) {
            long filasModificadas = hotelAndes.terminarConvencion(convencion.getHoraInicio(), convencion.getHoraFin(), idUsuario);
            if (filasModificadas == 0) {
                JOptionPane.showMessageDialog(this, "No se pudo terminar la convención");
                throw new Exception("No se pudo terminar la convención");
            } else {
                JOptionPane.showMessageDialog(this, "Se terminó la convención");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se terminó la convención");
        }

    }
}

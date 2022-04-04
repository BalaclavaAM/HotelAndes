package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.*;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.jdo.JDODataStoreException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;

public class Recepcionista extends JFrame implements ActionListener {
    private static Logger log = Logger.getLogger(Administrador.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigRecepcionista.json";

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

    public Recepcionista() {
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
            Method req = Recepcionista.class.getMethod(evento);
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
    public void checkout() {
        System.out.println("entro en la interfaz");
        try {
            long idHabitacion = Long.parseLong(JOptionPane.showInputDialog(this, "idHabitacion:", "Check out idHabitacion", JOptionPane.QUESTION_MESSAGE));
            if (idHabitacion >0) {
                VOHabitacion hb=hotelAndes.obtenerHabitacion(idHabitacion);
                if (hb == null) {
                    throw new Exception("No hay una habitacion con esa id: " + idHabitacion);
                }
                if (hb.getValorAPagar()!=0){
                    throw new Exception("Falta Pagar: " + idHabitacion);
                }
                else{
                    VOPersonasHabitacion tb = hotelAndes.obtenerPersonasHabitacion(idHabitacion);

                    if (tb == null) {
                        throw new Exception("No hay un servicio activo en esa habitacion: " + idHabitacion);
                    }
                    long valorAPagar=hb.getValorAPagar();
                    long cambiar=0;
                    System.out.println("ya creo el VO");
                    if(valorAPagar==0){
                        cambiar = hotelAndes.cambiarEstadoUso(idHabitacion);
                    }
                    else {
                        throw new Exception("No se ha pagado todo por ende no se puede hacer check out: " + idHabitacion);
                    }

                    String resultado = "En adicionarTipoBebida\n\n";
                    resultado += "Tipo de bebida adicionado exitosamente: " + cambiar;
                    resultado += "\n Operación terminada";
                    panelDatos.actualizarInterfaz(resultado);
                }
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }
    public void checkIn() {
        System.out.println("entro en la interfaz");
        try {
            long numeroHabitacion= Long.parseLong(JOptionPane.showInputDialog(this, "numeroHabitacion (dado que el recepcionista sabe, que habitaciones hay, el debe elegir en cual ponerlo):", "Check IN numeroHabitacion", JOptionPane.QUESTION_MESSAGE));
            String usuarios = JOptionPane.showInputDialog(this, "Usuario con el que se hizo la reserva:", "Check IN Usuario", JOptionPane.QUESTION_MESSAGE);

            if (numeroHabitacion >0) {
                VOUsuario usuario = hotelAndes.darUsuarioPorLogin(usuarios);

                if (usuario == null) {
                    throw new Exception("No hay usuario con ese login: " + usuarios);
                }

                VOHabitacion habitacion = hotelAndes.obtenerHabitacionConNumero(numeroHabitacion);
                if (habitacion == null) {
                    throw new Exception("No hay habitaciones con ese numero: " + numeroHabitacion);
                }
                VOReserva reserva = hotelAndes.obtenerReservaActivaConUsuario(usuario.getId());
                if (reserva == null) {
                    throw new Exception("No hay reserva activa a nombre de ese usuario: " + numeroHabitacion);
                }
                long cambioReservaEstado= hotelAndes.reservaCambiarEstado(usuario.getId());
                int Uso=1;
                long tb  = hotelAndes.crearPersonasHabitacion(habitacion.getId(),reserva.getHoraInicio(),reserva.getHoraFin(),Uso);

                String resultado = "En adicionarTipoBebida\n\n";
                resultado += "Tipo de bebida PersonasHabitacion: " + numeroHabitacion;
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

}

package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.*;
import uniandes.isis2304.hotelandes.negocio.enums.FilterAnalisisType;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;

import javax.jdo.JDODataStoreException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    /*
     * ****************************************************************
     * Atributos
     *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren
     * utilizar
     */
    private JsonObject tableConfig;

    /**
     * Asociación a la clase principal del negocio.
     */
    private HotelAndes hotelAndes;

    /*
     * ****************************************************************
     * Atributos de interfaz
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
            // e.printStackTrace ();
            log.info("NO se encontró un archivo de configuración válido");
            JOptionPane.showMessageDialog(null,
                    "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App",
                    JOptionPane.ERROR_MESSAGE);
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
    /*
     * ****************************************************************
     * Métodos de la Interacción
     *****************************************************************/

    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos
     * de negocio
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

    /*
     * ****************************************************************
     * Programa principal
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
            /*
             * Administrador interfaz = new Administrador( );
             * interfaz.setVisible( true );
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////// METODOS DE TIPOHABITACION
    public void adicionarTipoHabitacion() {
        try {
            String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del tipo habitacion?",
                    "Adicionar Nombre tipo habitacion", JOptionPane.QUESTION_MESSAGE);
            Float precio = Float.parseFloat(JOptionPane.showInputDialog(this, "Precio habitacion (poner solo numeros)?",
                    "Adicionar precio tipo habitacion", JOptionPane.QUESTION_MESSAGE));
            String descripcion = JOptionPane.showInputDialog(this, "Poner descripcion de la habitacion",
                    "Adicionar descripcion tipo habitacion", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipo != null && precio != null && descripcion != null) {
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
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void veinteServiciosPopulares() {
        String inicio = JOptionPane.showInputDialog(this,
                "Ponga la fecha de inicio en el siguiente formato 12-01-2012 dia-mes-año", "FECHA INICIO",
                JOptionPane.QUESTION_MESSAGE);
        inicio += " 00:00:01";
        String finals = JOptionPane.showInputDialog(this,
                "Ponga la fecha de final en el siguiente formato 12-01-2012 dia-mes-año", "FECHA FINAL",
                JOptionPane.QUESTION_MESSAGE);
        finals += " 00:00:01";
        try {
            List<Servicio> tb = hotelAndes.veinteServiciosPopulares(inicio, finals);
            if (tb.get(0) == null) {
                throw new Exception("No hay servicios con ese nombre: ");
            }
            String resultado = "En Servicios\n\n";
            resultado += "Busqueda existosa : " + tb;
            resultado += "\n Operación terminada";
            resultado += tb.toString();
            panelDatos.actualizarInterfaz(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void dineroPorHabitacion() {
        String inicio = JOptionPane.showInputDialog(this,
                "Ponga la fecha de inicio en el siguiente formato 12-01-2012 dia-mes-año", "FECHA INICIO",
                JOptionPane.QUESTION_MESSAGE);
        inicio += " 00:00:01";
        String finals = JOptionPane.showInputDialog(this,
                "Ponga la fecha de final en el siguiente formato 12-01-2012 dia-mes-año", "FECHA FINAL",
                JOptionPane.QUESTION_MESSAGE);
        finals += " 00:00:01";
        try {
            List<DineroPorHabitacion> tb = hotelAndes.dineroPorHabitacion(inicio, finals);
            if (tb.isEmpty()) {
                throw new Exception("No hay habitaciones, o registros de servicios: ");
            }
            String resultado = "En Servicios\n\n";
            resultado += "Busqueda existosa : " + tb;
            resultado += "\n Operación terminada";
            resultado += tb.toString();
            panelDatos.actualizarInterfaz(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void adicionarHabitacion() {
        System.out.println("entro en la interfaz");
        try {
            long tipo = Long.parseLong(JOptionPane.showInputDialog(this, "Tipo Habitacion (poner solo numeros)?",
                    "Adicionar tipo habitacion", JOptionPane.QUESTION_MESSAGE));
            long hotel = Long.parseLong(JOptionPane.showInputDialog(this, "Hotel habitacion (poner solo numeros)?",
                    "Adicionar hotel habitacion", JOptionPane.QUESTION_MESSAGE));
            long numberoHabitacion = Long
                    .parseLong(JOptionPane.showInputDialog(this, "numero habitacion (poner solo numeros)?",
                            "Adicionar numero habitacion", JOptionPane.QUESTION_MESSAGE));
            if (tipo > 0 && hotel > 0 && numberoHabitacion > 0) {
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
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void createUserType() {
        try {
            String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del tipo de usuario?",
                    "Adicionar Nombre tipo usuario", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipo != null) {
                TipoUsuario tb = hotelAndes.adicionaTipoUsuario(nombreTipo);
                if (tb == null) {
                    throw new Exception("No se pudo crear un tipo de usuario con nombre: " + nombreTipo);
                }
                String resultado = "En adicionarTipoUsuario\n\n";
                resultado += "Tipo de usuario adicionado exitosamente: " + tb.getId() + " " + tb.getTipo();
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void createUser() {
        try {
            String nombrePersona = JOptionPane.showInputDialog(this, "Nombre de la persona?",
                    "Adicionar Nombre persona", JOptionPane.QUESTION_MESSAGE);
            String emailPersona = JOptionPane.showInputDialog(this, "Email de la persona?", "Adicionar Email persona",
                    JOptionPane.QUESTION_MESSAGE);
            String nombreUsuario = JOptionPane.showInputDialog(this, "Nombre del usuario?", "Adicionar Nombre usuario",
                    JOptionPane.QUESTION_MESSAGE);
            String passwordUsuario = JOptionPane.showInputDialog(this, "Password del usuario?",
                    "Adicionar Password usuario", JOptionPane.QUESTION_MESSAGE);
            // dropdown to tipousuario
            List<TipoPlan> tiposPlan = hotelAndes.obtenerTiposPlanes();
            List<TipoUsuario> tiposUsuario = hotelAndes.getUserTypes();
            List<String> tiposUsuarioString = new ArrayList<String>();
            List<TipoDocumento> tiposDocumento = hotelAndes.getDocumentTypes();
            System.out.println(tiposUsuario.size());
            for (TipoUsuario tipoUsuario : tiposUsuario) {
                tiposUsuarioString.add(tipoUsuario.getTipo() + '-' + tipoUsuario.getId());
            }
            List<String> tiposDocumentoString = new ArrayList<String>();
            for (TipoDocumento tipoDocumento : tiposDocumento) {
                tiposDocumentoString.add(tipoDocumento.getTipo() + '-' + tipoDocumento.getId());
            }
            List<String> tiposPlanString = new ArrayList<String>();
            for (TipoPlan tipoPlan : tiposPlan) {
                tiposPlanString.add(tipoPlan.getTipo() + '-' + tipoPlan.getId());
            }
            int idTipoPlan = JOptionPane.showOptionDialog(this, "Seleccione el tipo de plan", "Adicionar tipo plan",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, tiposPlanString.toArray(), null);
            int idTipoUsuario = JOptionPane.showOptionDialog(this, "Seleccione el tipo de usuario",
                    "Adicionar tipo usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                    tiposUsuarioString.toArray(), null);
            int idTipoDocumento = JOptionPane.showOptionDialog(this, "Seleccione el tipo de documento",
                    "Adicionar tipo documento", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                    tiposDocumentoString.toArray(), null);
            String numeroDocumento = JOptionPane.showInputDialog(this, "Numero de documento?",
                    "Adicionar numero documento", JOptionPane.QUESTION_MESSAGE);
            if (nombreUsuario != null && passwordUsuario != null && idTipoPlan >= 0 && idTipoUsuario >= 0
                    && idTipoDocumento >= 0 && numeroDocumento != null) {
                long idUser = hotelAndes.adicionarUsuario(nombrePersona, numeroDocumento, idTipoUsuario,
                        idTipoDocumento, idTipoPlan, nombreUsuario, passwordUsuario, emailPersona);
                if (idUser == 0) {
                    throw new Exception("No se pudo crear un usuario con nombre: " + nombreUsuario);
                }
                String resultado = "En adicionarUsuario\n\n";
                resultado += "Usuario adicionado exitosamente: " + idUser;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }
    public void RFC10() {
        try {
            String nombreUsuario = JOptionPane.showInputDialog(this, "Nombre del usuario?", "Adicionar Nombre usuario", JOptionPane.QUESTION_MESSAGE);
            String idUsuario = JOptionPane.showInputDialog(this, "ID del usuario?", "Adicionar ID usuario", JOptionPane.QUESTION_MESSAGE);
            String tipoPlan = JOptionPane.showInputDialog(this, "Tipo plan de la persona? (int)", "Tipo planEmail persona", JOptionPane.QUESTION_MESSAGE);
            String numeroDocumento = JOptionPane.showInputDialog(this, "Numero de documento?", "Adicionar numero documento", JOptionPane.QUESTION_MESSAGE);
            //dropdown to tipousuario
            String fechaInicio = JOptionPane.showInputDialog(this, "Fecha de inicio? ano-mes-dia", "Adicionar fecha inicio", JOptionPane.QUESTION_MESSAGE);
            String fechaFin = JOptionPane.showInputDialog(this, "Fecha de fin? ano-mes-dia", "Adicionar fecha fin", JOptionPane.QUESTION_MESSAGE);
            ArrayList<String> newQuery = new ArrayList<String>();
            if (!nombreUsuario.equals("-")){
                String query = " WHERE nombre ='" + nombreUsuario + "' ";
                newQuery.add(query);
            }
            if (!idUsuario.equals("-")){
                String query = " WHERE USUARIO.ID = " + idUsuario+" ";
                newQuery.add(query);
            }
            if (!numeroDocumento.equals("-")){
                String query = " WHERE USUARIO.DOCUMENTO = " + numeroDocumento +" ";
                newQuery.add(query);
            }
            if (!tipoPlan .equals("-")){
                String query = " WHERE USUARIO.EMAIL = '" + tipoPlan + "' ";
                newQuery.add(query);
            }
            if (!fechaInicio.equals("-")){
                String query = " WHERE fecha >TO_DATE('" + fechaInicio + "', 'yyyy-mm-dd') ";
                newQuery.add(query);
            }
            if (!fechaFin.equals("-")){
                String query = " WHERE fecha < TO_DATE('" + fechaFin + "', 'yyyy-mm-dd') ";
                newQuery.add(query);
            }
            String conteo = JOptionPane.showInputDialog(this, "Cuantas veces tuvo que consumirlo (ponga - si no importa)", "Veces consumo persona", JOptionPane.QUESTION_MESSAGE);
            if (conteo.equals("-")){
                List<Usuario> result= hotelAndes.darUsuarioPorConsumoEnRangoYOtrasCaracteristicas( newQuery);
                panelDatos.actualizarInterfaz(result.toString());
            }
            else   {
                String query = " WHERE COUNT(*) >= " + conteo ;
                List<Usuario> result=hotelAndes.darUsuarioPorConsumoEnRangoYOtrasCaracteristicasConNumeroDeVeces(newQuery);
                panelDatos.actualizarInterfaz(result.toString());
            }

        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }
    public void RFC7 () {
        List<Usuario> a =hotelAndes.RFC7();
        panelDatos.actualizarInterfaz(a.toString());
    }

    public void registrarTipoServicio() {
        try {
            System.out.println("Registrar tipo de servicio");
            String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del tipo de servicio?",
                    "Adicionar Nombre tipo servicio", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipo != null) {
                long tb = hotelAndes.adicionarTipoServicio(nombreTipo);
                if (tb == 0) {
                    throw new Exception("No se pudo crear un tipo de servicio con nombre: " + nombreTipo);
                }
                String resultado = "En adicionarTipoServicio\n\n";
                resultado += "Tipo de servicio adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void registrarServicio() {
        try {
            String nombreServicio = JOptionPane.showInputDialog(this, "Nombre del servicio?",
                    "Adicionar Nombre servicio", JOptionPane.QUESTION_MESSAGE);
            List<TipoServicio> tiposServicio = hotelAndes.gTipoServicios();
            List<String> tiposServicioString = new ArrayList<String>();
            for (TipoServicio tipoServicio : tiposServicio) {
                tiposServicioString.add(tipoServicio.getTipo() + '-' + tipoServicio.getId());
            }
            int idTipoServicio = JOptionPane.showOptionDialog(this, "Seleccione el tipo de servicio",
                    "Adicionar tipo servicio", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                    tiposServicioString.toArray(), null);
            idTipoServicio++;
            boolean descuentoTarjetaCredito = JOptionPane.showConfirmDialog(this,
                    "¿Tiene descuento en tarjeta de crédito?", "Adicionar descuento tarjeta de crédito",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            if (nombreServicio != null) {
                long tb = hotelAndes.adicionarServicio(nombreServicio, idTipoServicio, descuentoTarjetaCredito);
                if (tb == 0) {
                    throw new Exception("No se pudo crear un servicio con nombre: " + nombreServicio);
                }
                String resultado = "En adicionarServicio\n\n";
                resultado += "Servicio adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void createPlan() {
        try {
            String nombreTipoPlan = JOptionPane.showInputDialog(this, "Nombre del tipo de plan?",
                    "Adicionar Nombre tipo plan", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipoPlan != null) {
                long tb = hotelAndes.adicionarTipoPlan(nombreTipoPlan);
                if (tb == 0) {
                    throw new Exception("No se pudo crear un tipo de plan con nombre: " + nombreTipoPlan);
                }
                String resultado = "En adicionarTipoPlan\n\n";
                resultado += "Tipo de plan adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }

        } catch (Exception e) {
            // e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void RFC5() {

        String nombreCliente = JOptionPane.showInputDialog(this, "Nombre cliente", "Nombre cliente",
                JOptionPane.QUESTION_MESSAGE);
        String inicio = JOptionPane.showInputDialog(this,
                "Ponga la fecha de inicio en el siguiente formato 2012-01-12 año-mes dia", "FECHA INICIO",
                JOptionPane.QUESTION_MESSAGE);
        inicio += " 00:00:01.742000000";
        String finals = JOptionPane.showInputDialog(this,
                "Ponga la fecha de final en el siguiente formato 2012-01-12 año-mes dia", "FECHA FINAL",
                JOptionPane.QUESTION_MESSAGE);
        finals += " 00:00:01.742000000";
        List<RegistroServicio> listaServicios = hotelAndes.darRegistrosServicioPorUsuario(nombreCliente, inicio,
                finals);
        String resultado = " " + listaServicios.toString();
        panelDatos.actualizarInterfaz(resultado);
    }

    public void analisisOperacion() {
        try {
            ArrayList<String> listaFiltroAnalisis = new ArrayList<String>();
            listaFiltroAnalisis.add("Tipo de Habitacion");
            listaFiltroAnalisis.add("Servicio");
            JComboBox<String> comboBox = new JComboBox<>(listaFiltroAnalisis.toArray(new String[listaFiltroAnalisis.size()]));
            comboBox.setEditable(false);
            JOptionPane.showMessageDialog(this, comboBox, "Seleccione el filtro", JOptionPane.QUESTION_MESSAGE);

            String filtro = (String) comboBox.getSelectedItem();

            FilterAnalisisType filtroAnalisis = FilterAnalisisType.SERVICIO;
            if (filtro.equals("Tipo de Habitacion")){
                filtroAnalisis = FilterAnalisisType.TIPOHABITACION;
            }

            ArrayList<String> opciones = new ArrayList<String>();
            opciones.add("Semana");
            opciones.add("Mes");
            opciones.add("Año");
            opciones.add("Dia");
            JComboBox<String> comboBox2 = new JComboBox<>(opciones.toArray(new String[opciones.size()]));
            comboBox2.setEditable(false);
            JOptionPane.showMessageDialog(this, comboBox2, "Seleccione el filtro", JOptionPane.QUESTION_MESSAGE);

            String tipoTiempo = (String) comboBox2.getSelectedItem();

            long parameterExtra = 0;
            switch (filtroAnalisis) {
                case TIPOHABITACION:
                    List<TipoHabitacion> tiposHabitacion = hotelAndes.gTiposHabitacion();
                    JComboBox comboBox3 = new JComboBox(tiposHabitacion.toArray());
                    comboBox3.setEditable(false);
                    JOptionPane.showMessageDialog(this, comboBox3, "Seleccione el tipo de habitación",
                            JOptionPane.QUESTION_MESSAGE);
                    TipoHabitacion tipoHabitacion = (TipoHabitacion) comboBox3.getSelectedItem();
                    parameterExtra = tipoHabitacion.getId();
                    break;
                case SERVICIO:
                    List<TipoServicio> tiposServicios = hotelAndes.gTipoServicios();
                    JComboBox comboBox4 = new JComboBox(tiposServicios.toArray());
                    comboBox4.setEditable(false);
                    JOptionPane.showMessageDialog(this, comboBox4, "Seleccione el tipo de servicio",
                            JOptionPane.QUESTION_MESSAGE);
                    TipoServicio tipoServicio = (TipoServicio) comboBox4.getSelectedItem();
                    parameterExtra = tipoServicio.getId();
                    break;
            }
            List<ResponseRegistroServicioStatistics> topCounters =  this.hotelAndes.analisisHotelandes(filtroAnalisis, true, parameterExtra, tipoTiempo, true);
            List<ResponseRegistroServicioStatistics> downCounters =  this.hotelAndes.analisisHotelandes(filtroAnalisis, false, parameterExtra, tipoTiempo, true);

            List<ResponseRegistroServicioStatistics> topRecaudo = this.hotelAndes.analisisHotelandes(filtroAnalisis, true, parameterExtra, tipoTiempo, false);
            List<ResponseRegistroServicioStatistics> downRecaudo = this.hotelAndes.analisisHotelandes(filtroAnalisis, false, parameterExtra, tipoTiempo, false);
            String resultado = "-----------TOP ACTIVIDAD-------------\n";
            for (ResponseRegistroServicioStatistics counter : topCounters) {
                resultado+= "filtro"+counter.filter+" cantidad: "+counter.quantity+" "+tipoTiempo+": "+counter.tiempo+"\n";
            }
            resultado += "-----------DOWN ACTIVIDAD-------------\n";
            for (ResponseRegistroServicioStatistics counter : downCounters) {
                resultado+= "filtro"+counter.filter+" cantidad: "+counter.quantity+" "+tipoTiempo+": "+counter.tiempo+"\n";
            }
            resultado += "-----------TOP RECAUDO-------------\n";
            for (ResponseRegistroServicioStatistics counter : topRecaudo) {
                resultado+= "filtro"+counter.filter+" cantidad: "+counter.quantity+" "+tipoTiempo+": "+counter.tiempo+"\n";
            }
            resultado += "-----------DOWN RECAUDO-------------\n";
            for (ResponseRegistroServicioStatistics counter : downRecaudo) {
                resultado+= "filtro"+counter.filter+" cantidad: "+counter.quantity+" "+tipoTiempo+": "+counter.tiempo+"\n";
            }
            panelDatos.actualizarInterfaz(resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RFC9IT4(){
        try{
            String fechaInicio = JOptionPane.showInputDialog(this, "Ponga la fecha de inicio en el siguiente formato 2012-01-12 año-mes dia", "FECHA INICIO",
                    JOptionPane.QUESTION_MESSAGE);
            //format string yyyy-MM-dd to timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = (Date) sdf.parse(fechaInicio);
            String fechaFinal = JOptionPane.showInputDialog(this, "Ponga la fecha de final en el siguiente formato 2012-01-12 año-mes dia", "FECHA FINAL",
                    JOptionPane.QUESTION_MESSAGE);
            Date endDate = (Date) sdf.parse(fechaFinal);
            panelDatos.actualizarInterfaz("Obteniendo servicios... ");
            List<Servicio> servicios = hotelAndes.obtenerServicios();
            panelDatos.actualizarInterfaz("Servicios obtenidos exitosamente. "+servicios.size()+ " servicios");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * ****************************************************************
     * Métodos privados para la presentación de resultados y otras operaciones
     *****************************************************************/

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e,
     * haciendo énfasis en las excepcionsde JDO
     * 
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es
     *         javax.jdo.JDODataStoreException, "" de lo contrario
     */
    private String darDetalleException(Exception e) {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions()[0].getMessage();
        }
        return resp;
    }

    /**
     * Genera una cadena para indicar al usuario que hubo un error en la aplicación
     * 
     * @param e - La excepción generada
     * @return La cadena con la información de la excepción y detalles adicionales
     */
    private String generarMensajeError(Exception e) {
        String resultado = "************ Error en la ejecución\n";
        resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
        resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
        return resultado;
    }
}

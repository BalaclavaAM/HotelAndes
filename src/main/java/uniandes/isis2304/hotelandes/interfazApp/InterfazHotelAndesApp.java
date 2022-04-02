package uniandes.isis2304.hotelandes.interfazApp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.parranderos.interfazApp.InterfazParranderosApp;
import uniandes.isis2304.parranderos.interfazApp.PanelDatos;
import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class InterfazHotelAndesApp {

    /* ****************************************************************
     * 			Constantes
     *****************************************************************/
    /**
     * Logger para escribir la traza de la ejecución
     */
    private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());

    /**
     * Ruta al archivo de configuración de la interfaz
     */
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json";

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

    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /*
    public InterfazHotelAndesApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);

        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null)
        {
            crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }

        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        parranderos = new Parranderos (tableConfig);

        String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );
        add( panelDatos, BorderLayout.CENTER );
    }
    private void crearMenu(  JsonArray jsonMenu )
    {
        // Creación de la barra de menús
        menuBar = new JMenuBar();
        for (JsonElement men : jsonMenu)
        {
            // Creación de cada uno de los menús
            JsonObject jom = men.getAsJsonObject();

            String menuTitle = jom.get("menuTitle").getAsString();
            JsonArray opciones = jom.getAsJsonArray("options");

            JMenu menu = new JMenu( menuTitle);

            for (JsonElement op : opciones)
            {
                // Creación de cada una de las opciones del menú
                JsonObject jo = op.getAsJsonObject();
                String lb =   jo.get("label").getAsString();
                String event = jo.get("event").getAsString();

                JMenuItem mItem = new JMenuItem( lb );
                mItem.addActionListener( this );
                mItem.setActionCommand(event);

                menu.add(mItem);
            }
            menuBar.add( menu );
        }
        setJMenuBar ( menuBar );
    }
    public void adicionarTipoBebida( )
    {
        try
        {
            String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
            if (nombreTipo != null)
            {
                VOTipoBebida tb = parranderos.adicionarTipoBebida (nombreTipo);
                if (tb == null)
                {
                    throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
                }
                String resultado = "En adicionarTipoBebida\n\n";
                resultado += "Tipo de bebida adicionado exitosamente: " + tb;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            }
            else
            {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        }
        catch (Exception e)
        {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }
    private JsonObject openConfig (String tipo, String archConfig)
    {
        JsonObject config = null;
        try
        {
            Gson gson = new Gson( );
            FileReader file = new FileReader (archConfig);
            JsonReader reader = new JsonReader ( file );
            config = gson.fromJson(reader, JsonObject.class);
            log.info ("Se encontró un archivo de configuración válido: " + tipo);
        }
        catch (Exception e)
        {
//			e.printStackTrace ();
            log.info ("NO se encontró un archivo de configuración válido");
            JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
        }
        return config;
    }
    private void configurarFrame(  )
    {
        int alto = 0;
        int ancho = 0;
        String titulo = "";

        if ( guiConfig == null )
        {
            log.info ( "Se aplica configuración por defecto" );
            titulo = "Parranderos APP Default";
            alto = 300;
            ancho = 500;
        }
        else
        {
            log.info ( "Se aplica configuración indicada en el archivo de configuración" );
            titulo = guiConfig.get("title").getAsString();
            alto= guiConfig.get("frameH").getAsInt();
            ancho = guiConfig.get("frameW").getAsInt();
        }

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
        setSize ( ancho, alto);
    }

    private String generarMensajeError(Exception e)
    {
        String resultado = "************ Error en la ejecución\n";
        resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
        resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
        return resultado;
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
    }*/

}
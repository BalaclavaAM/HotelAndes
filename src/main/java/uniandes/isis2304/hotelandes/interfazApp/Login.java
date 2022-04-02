package uniandes.isis2304.hotelandes.interfazApp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.VOUsuario;
import uniandes.isis2304.parranderos.interfazApp.InterfazParranderosApp;
import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;

import javax.jdo.JDODataStoreException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Locale;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login extends JFrame{
    private JPanel panel1;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JFrame frame;
    private HotelAndes hotelAndes;
    private JsonObject tableConfig;
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_HotelAndes.json";
    private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());
    public Login(){
        frame=new JFrame("Login Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,200));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loginButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        String password = new String(passwordText.getPassword());
                        JOptionPane.showMessageDialog(frame,
                                "Password is " + password);
                    }
                });
        //parte hotelandes
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        hotelAndes = new HotelAndes(tableConfig);

    }
    private void jButtonActionPerformed(){
        String user = userText.getText();
        String pass = new String(passwordText.getPassword());
        JOptionPane.showMessageDialog(frame, "Password is " + pass);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void buscarTipoBebidaPorNombre( )
    {
        try
        {
            String login = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Buscar tipo de bebida por nombre", JOptionPane.QUESTION_MESSAGE);
            if (login != null)
            {
                VOUsuario usuario = hotelAndes.darUsuarioPorLogin (login);
                String resultado = "En buscar Tipo Bebida por nombre\n\n";
                if (usuario!= null)
                {
                    resultado += "El tipo de bebida es: " + usuario;
                    JOptionPane.showMessageDialog(frame, "Ingreso de " + login +"succesfull");
                    String tipoUsuario=usuario.getNombreTipoUsuario();
                    if(tipoUsuario.toUpperCase(Locale.ROOT) =="CLIENTE"){//Cliente
                        Cliente cliente = new Cliente();
                        cliente.setLocationRelativeTo(null);
                        cliente.setVisible(true);
                        this.setVisible(false);
                    }
                    else if(tipoUsuario.toUpperCase(Locale.ROOT) =="ADMINISTRADOR"){
                        Administrador admin= new Administrador();
                        admin.setLocationRelativeTo(null);
                        admin.setVisible(true);
                        this.setVisible(false);
                    }
                    else if(tipoUsuario.toUpperCase(Locale.ROOT) =="EMPLEADO"){
                        Empleado empleado= new Empleado();
                        empleado.setLocationRelativeTo(null);
                        empleado.setVisible(true);
                        this.setVisible(false);
                    }
                    else if(tipoUsuario.toUpperCase(Locale.ROOT) =="GERENTE"){
                        Gerente gerente = new Gerente();
                        gerente.setLocationRelativeTo(null);
                        gerente.setVisible(true);
                        this.setVisible(false);
                    }
                }
                else
                {
                    resultado += "El usuario con login: " + login + " NO EXISTE\n";
                    JOptionPane.showMessageDialog(frame, resultado);
                }
                resultado += "\n Operación terminada";
            }
        }
        catch (Exception e)
        {
//			e.printStackTrace();
            String resultado = generarMensajeError(e);
        }
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

package uniandes.isis2304.hotelandes.negocio;

import java.util.LinkedList;

public class Usuario implements VOUsuario{
    public String nombreTipoUsuario;
    public String login;
    public String contrasena;
    public long id;
    public String nombre;
    public long documento;
    public long tipoUsuario;
    public long tipoDocumento;
    public long tipoPlan;
    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.documento = 0;
        this.tipoUsuario = 0;
        this.tipoDocumento = 0;
        this.contrasena="";
    }
    public Usuario(long id, String nombre, long documento, long tipoUsuario, long tipoDocumento, String login, String nombreTipoUsuario, String contrasena, long tipoPlan)
    {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
        this.tipoDocumento = tipoDocumento;
        this.login=login;
        this.nombreTipoUsuario=nombreTipoUsuario;//esta variable no esta en la tabla perse del usuario, esta en tipo usuario, pero se pone aca por conveniencia
        this.contrasena=contrasena;
        this.tipoPlan=tipoPlan;

        // Estos valores no se conocen en el momento de la construcción del bebedor

    }

    public long getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(long tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString()
    {
        return "Usuario [nombreUsuario=" + nombre + ", tipoUsuario=" + tipoUsuario + "]";
    }
}

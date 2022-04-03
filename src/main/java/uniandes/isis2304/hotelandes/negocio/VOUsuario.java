package uniandes.isis2304.hotelandes.negocio;

public interface VOUsuario {
    public long getId();

    public void setId(long id);

    public String getNombre();

    public void setNombre(String nombre);

    public long getDocumento();

    public void setDocumento(long documento);

    public long getTipoUsuario();

    public void setTipoUsuario(long tipoUsuario);

    public long getTipoDocumento();

    public void setTipoDocumento(long tipoDocumento);

    public String getLogin();

    public void setLogin(String login);

    public String getNombreTipoUsuario();

    public void setNombreTipoUsuario(String nombreTipoUsuario);

    public String getContrasena();

    public void setContrasena(String contrasena);

    public long getTipoPlan();

    public void setTipoPlan(long tipoPlan);
    @Override
    public String toString();


}

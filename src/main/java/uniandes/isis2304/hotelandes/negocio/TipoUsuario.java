package uniandes.isis2304.hotelandes.negocio;

public class TipoUsuario {

    private long idUsuario;
    private String tipo;

    public TipoUsuario() {
        this.idUsuario = 0;
        this.tipo = "Default";
    }

    public TipoUsuario(long idUsuario, String tipo) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

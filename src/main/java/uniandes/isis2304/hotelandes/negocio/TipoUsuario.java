package uniandes.isis2304.hotelandes.negocio;

public class TipoUsuario {

    private long id;
    private String tipo;

    public TipoUsuario() {
        this.id = 0;
        this.tipo = "Default";
    }

    public TipoUsuario(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoUsuario [id=" + id + ", tipo=" + tipo + "]";
    }
}

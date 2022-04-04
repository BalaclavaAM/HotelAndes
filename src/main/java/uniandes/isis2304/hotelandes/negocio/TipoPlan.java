package uniandes.isis2304.hotelandes.negocio;

public class TipoPlan {
    private long id;
    private String tipo;

    public TipoPlan() {
        this.id = 0;
        this.tipo = "Default";
    }

    public TipoPlan(long id, String tipo) {
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
        return "TipoPlan [id=" + id + ", tipo=" + tipo + "]";
    }
}

package uniandes.isis2304.hotelandes.negocio;

public class TipoHabitacion {

    private long id;

    private String tipo;

    private Float precio;

    private String descripcion;

    public TipoHabitacion(){
        this.id=0;
        this.tipo="Default";
        this.precio=0f;
        this.descripcion="Default";
    }

    public TipoHabitacion(long id, String tipo, Float precio, String descripcion){
        this.id=id;
        this.tipo=tipo;
        this.precio=precio;
        this.descripcion=descripcion;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

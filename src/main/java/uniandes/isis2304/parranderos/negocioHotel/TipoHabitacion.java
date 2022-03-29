package uniandes.isis2304.parranderos.negocioHotel;

public class TipoHabitacion {

    private long id;

    private String tipo;

    private long precio;

    private String descripcion;

    public TipoHabitacion(){
        this.id=0;
        this.tipo="Default";
        this.precio=0;
        this.descripcion="Default";
    }

    public TipoHabitacion(long id, String tipo, long precio, String descripcion){
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

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

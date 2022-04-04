package uniandes.isis2304.hotelandes.negocio;

public class Habitacion implements VOHabitacion{
    public long id;
    public long tipo;
    public long hotel;
    public long numeroHabitacion;
    public long valorAPagar;

    public Habitacion(){
        this.id=0;
        this.tipo=0;
        this.hotel=0;
        this.numeroHabitacion=0;
        this.valorAPagar=0;
    }
    public Habitacion(long id, long tipo, long hotel, long numberoHabitacion, long valorAPagar){
        this.id=id;
        this.tipo=tipo;
        this.hotel=hotel;
        this.numeroHabitacion=numberoHabitacion;
        this.valorAPagar=valorAPagar;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }


    public long getTipo() {
        return tipo;
    }

    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    public long getHotel() {
        return hotel;
    }

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    public long getNumberoHabitacion() {
        return numeroHabitacion;
    }

    public void setNumberoHabitacion(long numberoHabitacion) {
        this.numeroHabitacion = numberoHabitacion;
    }

    public long getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(long valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    @Override
    public String toString()
    {
        return "TipoHabitacion [tipo=" + tipo + ", NumeroHabitacion=" + numeroHabitacion + "]";
    }
}

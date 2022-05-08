package uniandes.isis2304.hotelandes.negocio;

public class Habitacion implements VOHabitacion{
    public long id;
    public long tipo;
    public long hotel;
    public long numeroHabitacion;
    public long valorAPagar;
    public long enuso;

    public Habitacion(){
        this.id=0;
        this.tipo=0;
        this.hotel=0;
        this.numeroHabitacion=0;
        this.valorAPagar=0;
    }
    public Habitacion(long id, long tipo, long hotel, long numberoHabitacion, long valorAPagar, long enuso){
        this.id=id;
        this.tipo=tipo;
        this.hotel=hotel;
        this.enuso=enuso;
        this.numeroHabitacion=numberoHabitacion;
        this.valorAPagar=valorAPagar;
    }
    @Override
    public long getNumeroHabitacion() {
        return numeroHabitacion;
    }
    @Override
    public void setNumeroHabitacion(long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    @Override
    public long getEnuso() {
        return enuso;
    }
    @Override
    public void setEnuso(long ensuo) {
        this.enuso = ensuo;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    @Override
    public long getHotel() {
        return hotel;
    }

    @Override

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    @Override

    public long getNumberoHabitacion() {
        return numeroHabitacion;
    }

    @Override

    public void setNumberoHabitacion(long numberoHabitacion) {
        this.numeroHabitacion = numberoHabitacion;
    }

    @Override

    public long getValorAPagar() {
        return valorAPagar;
    }

    @Override

    public void setValorAPagar(long valorAPagar) {
        this.valorAPagar = valorAPagar;
    }



    @Override
    public String toString()
    {
        return "TipoHabitacion [tipo=" + tipo + ", NumeroHabitacion=" + numeroHabitacion + "]";
    }
}

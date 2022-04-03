package uniandes.isis2304.hotelandes.negocio;

public class Habitacion implements VOHabitacion{
    public long id;
    public long tipo;
    public long hotel;
    public long numberoHabitacion;

    public Habitacion(){
        this.id=0;
        this.tipo=0;
        this.hotel=0;
        this.numberoHabitacion=0;
    }
    public Habitacion(long id, long tipo, long hotel, long numberoHabitacion){
        this.id=id;
        this.tipo=tipo;
        this.hotel=hotel;
        this.numberoHabitacion=numberoHabitacion;
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
        return numberoHabitacion;
    }

    public void setNumberoHabitacion(long numberoHabitacion) {
        this.numberoHabitacion = numberoHabitacion;
    }
    @Override
    public String toString()
    {
        return "TipoHabitacion [tipo=" + tipo + ", NumeroHabitacion=" + numberoHabitacion + "]";
    }
}

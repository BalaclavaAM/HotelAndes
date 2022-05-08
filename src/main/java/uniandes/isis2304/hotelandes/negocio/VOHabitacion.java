package uniandes.isis2304.hotelandes.negocio;

public interface VOHabitacion {

    public long getId();


    public void setId(long id);


    public long getTipo();

    public void setTipo(long tipo);

    public long getHotel();

    public void setHotel(long hotel);

    public long getNumberoHabitacion();

    public void setNumberoHabitacion(long numeroHabitacion);

    public long getValorAPagar();

    public void setValorAPagar(long valorAPagar);

    public long getNumeroHabitacion();

    public void setNumeroHabitacion(long numeroHabitacion);

    public long getEnuso();

    public void setEnuso(long ensuo);

    @Override
    public String toString();


}

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

    @Override
    public String toString();
}

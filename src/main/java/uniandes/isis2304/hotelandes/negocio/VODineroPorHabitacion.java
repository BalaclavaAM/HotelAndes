package uniandes.isis2304.hotelandes.negocio;

public interface VODineroPorHabitacion {

    public long getNumHabitacion();

    public void setNumHabitacion(long numHabitacion);

    public long getDinero();

    public void setDinero(long dinero);
    @Override
    public String toString();
}
